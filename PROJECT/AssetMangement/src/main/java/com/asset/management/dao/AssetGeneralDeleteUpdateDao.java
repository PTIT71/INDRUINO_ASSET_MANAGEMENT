package com.asset.management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.asset.management.database.DatabaseConnection;
import com.asset.management.model.AssetObject;

public class AssetGeneralDeleteUpdateDao {
	
	public AssetGeneralDeleteUpdateDao()
	{
		
	}
	
	
	public int excuteUpdateDeleteData(AssetObject asset, String reasonDelete) throws SQLException
	{
		int result = 0;
		
		DatabaseConnection conn = new DatabaseConnection();
		Connection connectString = conn.getConnection();
		PreparedStatement sqlStatement = connectString.prepareStatement(getSql());
		System.out.println(getSql());
		sqlStatement.setString(1, reasonDelete);
		sqlStatement.setString(2, asset.getRFID());
		
			
		result = sqlStatement.executeUpdate();
		
		return result;
	}
	
	public String getIDSetup()
	{
		DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
        String ID = sdf.format(date);
		return ID;
	}
	
	public String getSql()
	{
		StringBuilder sql = new StringBuilder();
		
		sql.append(" UPDATE");
		sql.append(" 	ASSETS_GENERAL");
		sql.append(" SET ");
		sql.append(" 	DELETE_FG = 1");
		sql.append(" 	,DELETE_REASON = ?");
		sql.append(" WHERE ");
		sql.append(" 	ASSET_RFID = ?");
		
		
		return sql.toString();
	}

}
