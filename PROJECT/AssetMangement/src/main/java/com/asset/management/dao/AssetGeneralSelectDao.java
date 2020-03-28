package com.asset.management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.asset.management.database.DatabaseConnection;
import com.asset.management.form.AssetGeneralFormSearch;
import com.asset.management.model.AssetObject;
import com.asset.management.model.UserModel;

public class AssetGeneralSelectDao {
	AssetGeneralFormSearch form = new AssetGeneralFormSearch();
	public AssetGeneralSelectDao(AssetGeneralFormSearch form)
	{
		this.form  = form;
	}
	public AssetGeneralSelectDao()
	{
		
	}
	
	public List<AssetObject> excuteSearch() throws SQLException
	{
		
		
		DatabaseConnection conn = new DatabaseConnection();
		Connection connectString = conn.getConnection();
		Statement stmt = connectString.createStatement();
		ResultSet result = null;
		System.out.println(getSql());
		result = stmt.executeQuery(getSql());
		List<AssetObject> lstAsset =new ArrayList<AssetObject>();
		while (result.next()) {
			AssetObject Asset = new AssetObject();
			Asset.setRFID(result.getString("ASSET_RFID"));
			Asset.setName(result.getString("ASSET_NAME"));
			Asset.setModel(result.getString("ASSET_MODEL"));
			Asset.setSeries(result.getString("ASSET_SERIES"));
			Asset.setDepartment(result.getString("ASSET_DEPARTMENT"));
			Asset.setAccountant_CD(result.getString("ASSET_ACCOUNTANT"));
			Asset.setDateStart(result.getString("ASSET_DATE_INVEST"));
			Asset.setPrice(result.getString("ASSET_PRICE"));
			Asset.setNote(result.getString("ASSET_NOTE"));
			lstAsset.add(Asset);
		}
		
		return lstAsset;
	}
	
	public List<AssetObject> excute() throws SQLException
	{
		
		
		DatabaseConnection conn = new DatabaseConnection();
		Connection connectString = conn.getConnection();
		Statement stmt = connectString.createStatement();
		ResultSet result = null;
		System.out.println(getSql());
		result = stmt.executeQuery(getSql());
		List<AssetObject> lstAsset =new ArrayList<AssetObject>();
		while (result.next()) {
			AssetObject Asset = new AssetObject();
			Asset.setRFID(result.getString("ASSET_RFID"));
			Asset.setName(result.getString("ASSET_NAME"));
			Asset.setModel(result.getString("ASSET_MODEL"));
			Asset.setSeries(result.getString("ASSET_SERIES"));
			Asset.setDepartment(result.getString("ASSET_DEPARTMENT"));
			Asset.setAccountant_CD(result.getString("ASSET_ACCOUNTANT"));
			Asset.setDateStart(result.getString("ASSET_DATE_INVEST"));
			Asset.setPrice(result.getString("ASSET_PRICE"));
			Asset.setNote(result.getString("ASSET_NOTE"));
			lstAsset.add(Asset);
		}
		
		return lstAsset;
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
		
		sql.append(" SELECT *");
		sql.append(" FROM");
		sql.append(" 	ASSETS_GENERAL");
		sql.append(" WHERE");
		sql.append(" 	1=1");
		if(form != null)
		{
			if(form.getRFID()!=null && form.getRFID().trim().length()>0)
			{
				sql.append(" AND");
				sql.append(" 	ASSET_RFID = " ).append("'" + form.getRFID().trim()+"'");
			}
			if(form.getName()!=null && form.getName().trim().length()>0)
			{
				sql.append(" AND");
				sql.append(" 	ASSET_NAME = " ).append("N'" +form.getName().trim() +"'");
			}
			if(form.getModel()!=null && form.getModel().trim().length()>0)
			{
				sql.append(" AND");
				sql.append(" 	ASSET_MODEL = " ).append("'" + form.getModel().trim()+"'");
			}
			if(form.getSeries()!=null && form.getSeries().trim().length()>0)
			{
				sql.append(" AND");
				sql.append(" 	ASSET_SERIES = " ).append("'" +form.getSeries().trim() +"'");
			}
			if(form.getDepartment()!=null && form.getDepartment().trim().length()>0)
			{
				sql.append(" AND");
				sql.append(" 	ASSET_DEPARTMENT = " ).append("'" +form.getDepartment().trim() +"'");
			}
			if(form.getAccountant_CD()!=null && form.getAccountant_CD().trim().length()>0)
			{
				sql.append(" AND");
				sql.append(" 	ASSET_ACCOUNTANT = " ).append("'" +form.getAccountant_CD().trim() +"'");
			}
			if(form.getDateStart()!=null && form.getDateStart().trim().length()>0)
			{
				sql.append(" AND");
				sql.append(" 	ASSET_DATE_INVEST >= " ).append("'" + form.getDateStart().trim()+"'");
			}
			if(form.getDateEnd()!=null && form.getDateEnd().trim().length()>0)
			{
				sql.append(" AND");
				sql.append(" 	ASSET_DATE_INVEST <= " ).append("'" +form.getDateStart().trim() +"'");
			}
			if(form.getPriceStart()!=null && form.getPriceStart().trim().length()>0)
			{
				sql.append(" AND");
				sql.append(" 	ASSET_PRICE >= " ).append("'" + form.getPriceStart()+"'");
			}
			if(form.getPriceEnd()!=null && form.getPriceEnd().trim().length()>0)
			{
				sql.append(" AND");
				sql.append(" 	ASSET_PRICE <= " ).append("'" + form.getPriceStart()+"'");
			}
		}
		
		return sql.toString();
	}
}
