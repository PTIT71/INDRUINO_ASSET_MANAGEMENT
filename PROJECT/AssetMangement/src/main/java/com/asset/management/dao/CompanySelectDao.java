package com.asset.management.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.asset.management.database.DatabaseConnection;
import com.asset.management.form.CompanyForm;
import com.asset.management.model.AssetObject;
import com.asset.management.model.CompanyLevelModel;
import com.asset.management.model.CompanyModel;

public class CompanySelectDao {
	
	public CompanySelectDao()
	{
		
	}
	public CompanyForm excuteById(String id) throws SQLException
	{
		CompanyForm company = new CompanyForm();
		//Kết nối cơ sở dữ liệu
		DatabaseConnection conn = new DatabaseConnection();
		Connection connectString = conn.getConnection();
		Statement stmt = connectString.createStatement();
		ResultSet result = null;
		
		System.out.println(getSqlById(id));
		
		result = stmt.executeQuery(getSqlById(id));
		while (result.next()) {
			company.setName(result.getString("COMPANY_CD"));
			company.setFile_name(result.getString("COMPANY_LOGO"));
			company.setAddress(result.getString("COMPANY_ADDRESS"));
			company.setTax(result.getString("COMPANY_TAX"));
			company.setPhone(result.getString("COMPANY_PHONE"));
			company.setEmail(result.getString("COMPANY_EMAIL"));
			company.setWebsite(result.getString("COMPANY_WEBISTE"));
			company.setLevel(result.getString("COMPANY_LEVEL"));
			company.setDesciption(result.getString("COMPANY_DESCRIPTION"));
		}
		return company;
	}
	public List<CompanyModel> excute() throws SQLException
	{
		DatabaseConnection conn = new DatabaseConnection();
		Connection connectString = conn.getConnection();
		Statement stmt = connectString.createStatement();
		ResultSet result = null;
		System.out.println(getSql());
		result = stmt.executeQuery(getSql());
		List<CompanyModel> lstCompany =new ArrayList<CompanyModel>();
		while (result.next()) {
			CompanyModel company = new CompanyModel();
			company.setCompany_cd(result.getString("COMPANY_CD"));
			company.setCompany_name(result.getString("COMPANY_NAME"));
			company.setCompany_address(result.getString("COMPANY_ADDRESS"));
			
			lstCompany.add(company);
		}
		return lstCompany;
	}
	
	public String getSql()
	{
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT 	*	");
		sql.append("FROM		");
		sql.append(" 	COMPANY");
		
		return sql.toString();
	}
	
	public String getSqlById(String id)
	{
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT 	*	");
		sql.append("FROM		");
		sql.append(" 	COMPANY ");
		sql.append("WHERE 	 	");
		sql.append("COMPANY_CD = ").append("'" + id + "'");
		
		return sql.toString();
	}
	
	

}
