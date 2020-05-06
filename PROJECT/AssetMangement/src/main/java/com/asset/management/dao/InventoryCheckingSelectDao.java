package com.asset.management.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.asset.management.database.DatabaseConnection;
import com.asset.management.model.AssetObject;
import com.asset.management.model.InventoryChecking;
import com.asset.management.table.AssetManagementTable;

public class InventoryCheckingSelectDao {
	
	InventoryChecking InventoryChecking = null;
	public InventoryCheckingSelectDao()
	{
		
	}
	public InventoryCheckingSelectDao(InventoryChecking inventoryChecking)
	{
		this.InventoryChecking = inventoryChecking;
	}
	
	public List<AssetManagementTable> excuteAssetManagementTable() throws SQLException
	{
		DatabaseConnection conn = new DatabaseConnection();
		Connection connectString = conn.getConnection();
		Statement stmt = connectString.createStatement();
		ResultSet result = null;
		System.out.println(getSQLAssetManagementTable());
		result = stmt.executeQuery(getSQLAssetManagementTable());
		List<AssetManagementTable> lstChecking =new ArrayList<AssetManagementTable>();
		while (result.next()) {
			AssetManagementTable assetTable = new AssetManagementTable();
			assetTable.setInventorySessionCD(result.getString("INVENTORY_CHECK"));
			assetTable.setAsset_Name(result.getString("ASSET_NAME"));
			assetTable.setDepartment(result.getString("ASSET_DEPARTMENT"));
			assetTable.setInventory_Date(result.getString("INVENTORY_DATE"));
			assetTable.setUserName(result.getString("NAME"));
			assetTable.setUserChecking(result.getString("USER_CHECK"));
			assetTable.setStatus(result.getString("STATUS"));
			if(result.getString("STATUS").trim().equals("1"))
			{
				assetTable.setStatus_name("Kiểm kê thành công");
			}
			if(result.getString("STATUS").trim().equals("2"))
			{
				assetTable.setStatus_name("Báo mới");
			}
			if(result.getString("STATUS").trim().equals("3"))
			{
				assetTable.setStatus_name("Không tìm thấy");
			}
			
			
			lstChecking.add(assetTable);
		}
		
		return lstChecking;
	}
	
	public List<InventoryChecking> excute() throws SQLException
	{
		DatabaseConnection conn = new DatabaseConnection();
		Connection connectString = conn.getConnection();
		Statement stmt = connectString.createStatement();
		ResultSet result = null;
		System.out.println(getSql());
		result = stmt.executeQuery(getSql());
		List<InventoryChecking> lstChecking =new ArrayList<InventoryChecking>();
		while (result.next()) {
			InventoryChecking invChecking = new InventoryChecking();
			invChecking.setAsset_Rfid(result.getString("ASSET_RFID"));
			invChecking.setInventorySessionChecking_CD(result.getString("INVENTORY_SESSION_CD"));
			invChecking.setInventory_Date(result.getString("INVENTORY_DATE"));
			invChecking.setInventorySessionCD(result.getString("INVENTORY_CHECK"));
			invChecking.setUserChecking(result.getString("USER_CHECK"));
			
			lstChecking.add(invChecking);
		}
		
		return lstChecking;
	}
	
	public String getSQLAssetManagementTable()
	{
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT *");
		sql.append(" FROM");
		sql.append(" 	ASSETS_GENERAL  ASG");
		sql.append(" INNER JOIN ");
		sql.append(" ( ");
		sql.append(   getSql());
		sql.append(" ) INV");
		sql.append(" ON ");
		sql.append(" ASG.ASSET_RFID = INV.ASSET_RFID ");
		sql.append(" INNER JOIN ");
		sql.append(" USER_SYSTEM URS ");
		sql.append(" ON ");
		sql.append(" INV.USER_CHECK = URS.EMPLOYEE_CD ");
		
		//return sql.toString();
		return "  " + 
				"select ISNULL(INVENTORY_CHECK, 'KKDK20200102') AS INVENTORY_CHECK,  " + 
				"ISNULL(ASSET_NAME,'-') AS ASSET_NAME,  " + 
				"ISNULL(ASSET_DEPARTMENT,'-') AS ASSET_DEPARTMENT,  " + 
				"ISNULL(INVENTORY_DATE,'-') AS INVENTORY_DATE,  " + 
				"ISNULL(NAME,'-') AS NAME,  " + 
				"ISNULL(USER_CHECK,'-') AS USER_CHECK,  " + 
				"ISNULL(STATUS, '3') AS STATUS FROM   " + 
				"  " + 
				"(SELECT INVENTORY_CHECK,ASSET_NAME,ASSET_DEPARTMENT,INVENTORY_DATE,NAME,USER_CHECK, STATUS  " + 
				"FROM ASSETS_GENERAL ASG  " + 
				"LEFT JOIN  " + 
				" INVENTORY INV  " + 
				"  ON  INV.ASSET_RFID = ASG.ASSET_RFID  " + 
				"     AND INVENTORY_CHECK = 'KKDK20200102'  " + 
				"LEFT JOIN USER_SYSTEM USR ON USR.EMPLOYEE_CD = INV.USER_CHECK  " + 
				"UNION ALL  " + 
				"SELECT CHECKING_CD AS INVENTORY_CHECK, ASSET_NAME AS ASSET_NAME,CAN.DEPARTMENT AS ASSET_DEPARTMENT, DATE_CREATE AS INVENTORY_DATE,NAME,USER_INSERT AS USER_CHECK, STATUS FROM   " + 
				"CHECKING_ASSET_NEW CAN  " + 
				"LEFT JOIN USER_SYSTEM USR ON USR.EMPLOYEE_CD = CAN.USER_INSERT  " + 
				") AV  " + 
				"ORDER BY ASSET_DEPARTMENT" ;
				
	}
	
	public String getSql()
	{
		StringBuilder sql = new StringBuilder();
		InventoryChecking inv = this.InventoryChecking;
		
		sql.append(" SELECT *");
		sql.append(" FROM");
		sql.append(" 	INVENTORY");
		sql.append(" WHERE");
		sql.append(" 	1 = 1");
		if( inv != null)
		{
			if(inv.getAsset_Rfid() != null && inv.getAsset_Rfid().trim().length()>0)
			{
				sql.append(" 	AND ASSET_RFID = ").append("'" + inv.getAsset_Rfid()+ "'");
			}
			if(inv.getInventorySessionCD()!=null && inv.getInventorySessionCD().trim().length()>0)
			{
				sql.append(" 	AND INVENTORY_CHECK = ").append("'" + inv.getInventorySessionCD()+ "'");
			}
			if(inv.getInventorySessionChecking_CD()!=null && inv.getInventorySessionChecking_CD().trim().length()>0)
			{
				sql.append(" 	AND INVENTORY_SESSION_CD = ").append("'" + inv.getInventorySessionChecking_CD()+ "'");
			}
			if(inv.getInventory_Date()!=null && inv.getInventory_Date().trim().length()>0)
			{
				sql.append(" 	AND INVENTORY_DATE = ").append("'" + inv.getInventory_Date()+ "'");
			}
			if(inv.getUserChecking()!=null && inv.getUserChecking().trim().length()>0)
			{
				sql.append(" 	AND USER_CHECK = ").append("'" + inv.getUserChecking()+ "'");
			}
		}
		
		return sql.toString();
	}
	

}
