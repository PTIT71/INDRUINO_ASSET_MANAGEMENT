package com.asset.management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.asset.management.database.DatabaseConnection;
import com.asset.management.model.AssetObject;
import com.asset.management.model.UserModel;

public class UserSelectDao {

	public UserSelectDao()
	{
		
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
		//	user.setDepartment(department);
			lstAsset.add(user);
		}
		
		return lstAsset;
	}
	
	public String getSql()
	{
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT *");
		sql.append(" FROM");
		sql.append(" USER_SYS");
		
		return sql.toString();
	}
}
