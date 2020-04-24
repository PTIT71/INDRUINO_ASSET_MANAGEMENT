package com.asset.management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.print.attribute.standard.DateTimeAtCompleted;

import com.asset.management.database.DatabaseConnection;
import com.asset.management.model.AssetObject;

public class AssetGeneralInsertDao {
	
	public AssetGeneralInsertDao()
	{
		
	}
	
	public int excuteListData(List<AssetObject> lstData) throws SQLException
	{
		int result = 0;
		
		DatabaseConnection conn = new DatabaseConnection();
		Connection connectString = conn.getConnection();
		PreparedStatement sqlStatement = connectString.prepareStatement(getSql());
		System.out.println(getSql());
		
		for(int i=0;i<lstData.size();i++)
		{
			AssetObject assetObject = lstData.get(i);
			String ID = getIDSetup();
			sqlStatement.setString(1,ID);
			sqlStatement.setString(2,assetObject.getRFID());
			sqlStatement.setString(3,assetObject.getName());
			sqlStatement.setString(4,assetObject.getModel());
			sqlStatement.setString(5,assetObject.getSeries());
			sqlStatement.setString(6,assetObject.getDepartment());
			sqlStatement.setString(7,assetObject.getAccountant_CD());
			sqlStatement.setString(8,assetObject.getDateStart());
			sqlStatement.setString(9,assetObject.getPrice());
			sqlStatement.setString(10,assetObject.getNote());
			
			 result = sqlStatement.executeUpdate();
		}
		
		return result;
	}
	
	public int excuteData(AssetObject asset) throws SQLException
	{
		int result = 0;
		
		DatabaseConnection conn = new DatabaseConnection();
		Connection connectString = conn.getConnection();
		PreparedStatement sqlStatement = connectString.prepareStatement(getSql());
		//System.out.println(getSql());
		
			sqlStatement.setString(1,asset.getId());
			sqlStatement.setString(2,asset.getRFID());
			sqlStatement.setString(3,asset.getName());
			System.out.println(asset.getName());
			sqlStatement.setString(4,asset.getModel());
			sqlStatement.setString(5,asset.getSeries());
			sqlStatement.setString(6,asset.getDepartment());
			sqlStatement.setString(7,asset.getAccountant_CD());
			sqlStatement.setString(8,asset.getDateStart());
			sqlStatement.setString(9,asset.getPrice());
			sqlStatement.setString(10,asset.getNote());
			
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
		
		sql.append(" INSERT INTO");
		sql.append(" ASSETS_GENERAL");
		sql.append(" (");
		sql.append(" 	ASSET_CD");
		sql.append(" 	,ASSET_RFID");
		sql.append(" 	,ASSET_NAME");
		sql.append(" 	,ASSET_MODEL");
		sql.append(" 	,ASSET_SERIES");
		sql.append(" 	,ASSET_DEPARTMENT");
		sql.append(" 	,ASSET_ACCOUNTANT");
		sql.append(" 	,ASSET_DATE_INVEST");
		sql.append(" 	,ASSET_PRICE");
		sql.append(" 	,ASSET_NOTE");
		sql.append(" )");
		sql.append(" VALUES");
		sql.append(" (");
		sql.append(" 	?");//ASSET_CD
		sql.append(" 	,?");//ASSET_RFID
		sql.append(" 	,?");//ASSET_NAME
		sql.append(" 	,?");//ASSET_MODEL
		sql.append(" 	,?");//ASSET_SERIES
		sql.append(" 	,?");//ASSET_DEPARTMENT
		sql.append(" 	,?");//ASSET_ACCOUNTANT
		sql.append(" 	,?");//ASSET_DATE_INVEST
		sql.append(" 	,?");//ASSET_PRICE
		sql.append(" 	,?");//ASSET_NOTE
		sql.append(" )");
		
		return sql.toString();
	}
}
