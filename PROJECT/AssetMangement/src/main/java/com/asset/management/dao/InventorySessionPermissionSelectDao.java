package com.asset.management.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.asset.management.database.DatabaseConnection;
import com.asset.management.model.InventorySession;
import com.asset.management.model.InventorySessionPermission;

public class InventorySessionPermissionSelectDao {
	
	InventorySessionPermission inventorySessionPermission =null;
	
	public InventorySessionPermissionSelectDao()
	{
		
	}
	public InventorySessionPermissionSelectDao( InventorySessionPermission inventorySessionPermission)
	{
		this.inventorySessionPermission = inventorySessionPermission;
		
	}
	
	public List<InventorySessionPermission> excute() throws SQLException
	{
		DatabaseConnection conn = new DatabaseConnection();
		Connection connectString = conn.getConnection();
		Statement stmt = connectString.createStatement();
		ResultSet result = null;
		System.out.println(getSql());
		result = stmt.executeQuery(getSql());
		List<InventorySessionPermission> lstInventorySessionPermission =new ArrayList<InventorySessionPermission>();
		while (result.next()) {
			InventorySessionPermission invSessionPermission= new InventorySessionPermission();
			invSessionPermission.setEmployee_id(result.getString("ID_EMPLOYEE"));
			invSessionPermission.setInventory_session_id(result.getString("ID_SESSION"));
			invSessionPermission.setPermission_id(result.getString("ID_PERMISSION"));
			
			lstInventorySessionPermission.add(invSessionPermission);
		}
		
		return lstInventorySessionPermission;
	}
	
	public String getSql()
	{
		StringBuilder sql = new StringBuilder();
		
		sql.append(" SELECT *");
		sql.append(" FROM");
		sql.append(" 	INVENTORY_SESSION_PERMISSION");
		sql.append(" WHERE");
		sql.append(" 	1=1");
		if(inventorySessionPermission != null)
		{
			if(inventorySessionPermission.getEmployee_id() != null)
			{
				sql.append(" AND ID_EMPLOYEE=").append("'" + inventorySessionPermission.getEmployee_id()+"'");
			}
			if(inventorySessionPermission.getInventory_session_id() != null)
			{
				sql.append(" AND ID_SESSION=").append("'" + inventorySessionPermission.getInventory_session_id()+"'");
			}
			if(inventorySessionPermission.getPermission_id() != null)
			{
				sql.append(" AND ID_PERMISSION=").append("'" + inventorySessionPermission.getPermission_id()+"'");
			}
		}
		
		
		return sql.toString();
	}

}
