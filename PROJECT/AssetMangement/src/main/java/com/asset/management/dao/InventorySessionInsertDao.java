package com.asset.management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.asset.management.database.DatabaseConnection;
import com.asset.management.model.AssetObject;
import com.asset.management.model.InventorySession;
import com.asset.management.util.Common;

public class InventorySessionInsertDao {
	
	List<String> lstEmployeeCD = new ArrayList<String>();
	InventorySession inventorySession = new InventorySession();
	
	public InventorySessionInsertDao(InventorySession inventorySession, List<String> lstEmployeeCD)
	{
		this.inventorySession = inventorySession;
		this.lstEmployeeCD = lstEmployeeCD;
	}
	
	public int Excute() throws SQLException
	{
		int result =0;
		DatabaseConnection conn = new DatabaseConnection();
		Connection connectString = conn.getConnection();
		PreparedStatement sqlStatement;
		
			sqlStatement = connectString.prepareStatement(getSql());
			System.out.println(getSql());
			sqlStatement.setString(1,inventorySession.getInventory_id());
			sqlStatement.setString(2,inventorySession.getInventory_session_name());
			sqlStatement.setString(3,inventorySession.getInventory_start_date());
			sqlStatement.setString(4,inventorySession.getInventory_end_date());
			sqlStatement.setString(5,inventorySession.getInventory_session_id());
			String ID_Permission = Common.getDateCurrent("YYYYMMDDHHMMSS");
			sqlStatement.setString(6,ID_Permission);
			result = sqlStatement.executeUpdate();
			
			sqlStatement = connectString.prepareStatement(getSqlPermission());
			System.out.println(getSqlPermission());
			for(int i=0;i<lstEmployeeCD.size();i++)
			{
				sqlStatement.setString(1,ID_Permission);
				sqlStatement.setString(2,inventorySession.getInventory_id());
				sqlStatement.setString(3,lstEmployeeCD.get(i));
				result = sqlStatement.executeUpdate();
			}
				
			
		
		return result;
	}
	
	public String getSql()
	{
		StringBuilder sql = new StringBuilder();
		
		sql.append(" INSERT INTO");
		sql.append(" INVENTORY_SESSION");
		sql.append(" (");
		sql.append(" 	ID_SESSION");
		sql.append(" 	,SESSION_NAME");
		sql.append(" 	,START_DT");
		sql.append(" 	,END_DT");
		sql.append(" 	,ID_INVENTORY");
		sql.append(" 	,ID_PERMISSION");
		sql.append(" )");
		sql.append(" VALUES");
		sql.append(" (");
		sql.append(" 	?");//ASSET_CD
		sql.append(" 	,?");//ASSET_RFID
		sql.append(" 	,?");//ASSET_NAME
		sql.append(" 	,?");//ASSET_MODEL
		sql.append(" 	,?");//ASSET_SERIES
		sql.append(" 	,?");//ASSET_DEPARTMENT
		sql.append(" )");
		
		return sql.toString();
	}
	
	public String getSqlPermission()
	{
		StringBuilder sql = new StringBuilder();
		
		sql.append(" INSERT INTO");
		sql.append(" INVENTORY_SESSION_PERMISSION");
		sql.append(" (");
		sql.append(" 	ID_PERMISSION");
		sql.append(" 	,ID_SESSION");
		sql.append(" 	,ID_EMPLOYEE");
		sql.append(" )");
		sql.append(" VALUES");
		sql.append(" (");
		sql.append(" 	?");//ASSET_CD
		sql.append(" 	,?");//ASSET_RFID
		sql.append(" 	,?");//ASSET_NAMET
		sql.append(" )");
		
		return sql.toString();
	}

}
