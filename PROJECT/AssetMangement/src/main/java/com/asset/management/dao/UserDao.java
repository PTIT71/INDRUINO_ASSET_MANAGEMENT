package com.asset.management.dao;

public class UserDao {
	
	public UserDao()
	{
		
	}
	
	public String getUserDao()
	{
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT *");
		sql.append(" FROM");
		sql.append(" USER_SYSTEM");
		
		return sql.toString();
	}

}
