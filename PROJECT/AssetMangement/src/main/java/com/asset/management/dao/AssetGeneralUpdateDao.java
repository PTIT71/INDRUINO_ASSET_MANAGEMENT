package com.asset.management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.asset.management.database.DatabaseConnection;
import com.asset.management.model.AssetObject;

public class AssetGeneralUpdateDao {
	public AssetGeneralUpdateDao()
	{
		
	}
	
	
	
	public int excuteData(AssetObject asset) throws SQLException
	{
		int result = 0;
		
		DatabaseConnection conn = new DatabaseConnection();
		Connection connectString = conn.getConnection();
		PreparedStatement sqlStatement = connectString.prepareStatement(getSql(asset));
		System.out.println(getSql(asset));
		
			
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
	
	public String getSql(AssetObject asset)
	{
		StringBuilder sql = new StringBuilder();
		
		sql.append(" UPDATE");
		sql.append(" 	ASSETS_GENERAL");
		sql.append(" SET ");
		sql.append(" 	ASSET_NAME = ").append("N'" + asset.getName() + "'");
		sql.append(" 	,ASSET_MODEL = ").append("N'" + asset.getModel() + "'");
		sql.append(" 	,ASSET_SERIES = ").append("N'" + asset.getSeries() + "'");
		sql.append(" 	,ASSET_DEPARTMENT = ").append("N'" + asset.getDepartment() + "'");
		sql.append(" 	,ASSET_ACCOUNTANT = ").append("N'" + asset.getAccountant_CD() + "'");
		sql.append(" 	,ASSET_DATE_INVEST = ").append("N'" + asset.getDateStart() + "'");
		sql.append(" 	,ASSET_PRICE = ").append("N'" + asset.getPrice() + "'");
		sql.append(" 	,ASSET_NOTE = ").append("N'" + asset.getNote() + "'");
		sql.append(" WHERE ");
		sql.append(" 	ASSET_RFID = ").append("'" + asset.getRFID() + "'");
		
		
		return sql.toString();
	}

}
