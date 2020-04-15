package com.asset.management.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.asset.management.database.DatabaseConnection;
import com.asset.management.form.CompanyForm;
import com.asset.management.model.CompanyLevelModel;
import com.asset.management.model.UserModel;

public class CompanyLevelSelectDao {
	
	public CompanyLevelSelectDao()
	{
		
	}
	
	
	
	public List<CompanyLevelModel> excute() throws SQLException
	{
		//Kết nối cơ sở dữ liệu
		DatabaseConnection conn = new DatabaseConnection();
		Connection connectString = conn.getConnection();
		Statement stmt = connectString.createStatement();
		ResultSet result = null;
		
		System.out.println(getSql());
		
		result = stmt.executeQuery(getSql());
		List<CompanyLevelModel> lstLevel =new ArrayList<CompanyLevelModel>();
		while (result.next()) {
			CompanyLevelModel cmpLvl = new CompanyLevelModel();
			cmpLvl.setCmp_level_cd(result.getString("CMP_LEVEL_CD").trim());
			cmpLvl.setCmp_level_name(result.getString("CMP_LEVEL_NAME").trim());
			lstLevel.add(cmpLvl);
		}
		
		return lstLevel;
	}
	
	public String getSql()
	{
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT *");
		sql.append(" FROM");
		sql.append(" COMPANY_LEVEL");
		
		return sql.toString();
	}

}
