package com.asset.management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.User;

import com.asset.management.database.DatabaseConnection;
import com.asset.management.model.AssetObject;
import com.asset.management.model.UserModel;

public class UserSelectDao {

	UserModel user;
	
	public UserSelectDao()
	{
		
	}
	
	public UserSelectDao(UserModel user)
	{
		this.user = user;
	}
	
	public List<UserModel> excute() throws SQLException
	{
		//Kết nối cơ sở dữ liệu
		DatabaseConnection conn = new DatabaseConnection();
		Connection connectString = conn.getConnection();
		Statement stmt = connectString.createStatement();
		ResultSet result = null;
		//---
		System.out.println(getSql());
		//---
		result = stmt.executeQuery(getSql());
		List<UserModel> lstAsset =new ArrayList<UserModel>();
		while (result.next()) {
			UserModel user = new UserModel();
			user.setName(result.getString("NAME"));
			user.setDepartment(result.getString("DEPARTMENT"));
			user.setEmployment_CD(result.getString("EMPLOYEE_CD"));
			user.setPosition(result.getString("POSITION"));
			user.setCompany_cd(result.getString("CMPN_CD"));
			lstAsset.add(user);
		}
		
		return lstAsset;
	}
	
	public String getSql()
	{
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT *");
		sql.append(" FROM");
		sql.append(" USER_SYSTEM");
		sql.append(" WHERE");
		sql.append(" 1=1 ");
		if(user != null)
		{
			if(user.getEmployment_CD()!=null && user.getEmployment_CD().trim().length() >0)
			{
				sql.append(" AND EMPLOYEE_CD = ").append("'" + user.getEmployment_CD() + "'");
			}
			if(user.getName()!=null && user.getName().trim().length() >0)
			{
				sql.append(" AND NAME = ").append("'" + user.getName() + "'");
			}
		}
		
		return sql.toString();
	}
}
