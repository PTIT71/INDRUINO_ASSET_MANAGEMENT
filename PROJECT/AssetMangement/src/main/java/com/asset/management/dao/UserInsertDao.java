package com.asset.management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.asset.management.database.DatabaseConnection;
import com.asset.management.model.LoanAssetModel;
import com.asset.management.model.UserModel;
import com.asset.management.util.Common;

public class UserInsertDao {
	UserModel user = null;
	
	public UserInsertDao()
	{
		
	}
	
	public UserInsertDao(UserModel us)
	{
		this.user = us;
	}
	
	public int excute() throws SQLException
	{
		int result = 0;
		
		DatabaseConnection conn = new DatabaseConnection();
		Connection connectString = conn.getConnection();
		PreparedStatement sqlStatement = connectString.prepareStatement(getSQL());
		System.out.println(getSQL());
		
			sqlStatement.setString(1,Common.getDateCurrent("YYYYMMDDHHMMSS"));
			sqlStatement.setString(2,user.getName());
			sqlStatement.setString(3,user.getEmployee_cd());
			//System.out.println(bam.getName());
			sqlStatement.setString(4,user.getPasword());
			sqlStatement.setString(5,user.getCompany_cd());
			
			
			
			 result = sqlStatement.executeUpdate();
		
		return result;
	}
	
	public String getSQL()
	{
StringBuilder sql = new StringBuilder();
		
		sql.append(" INSERT INTO");
		sql.append(" USER_SYSTEM");
		sql.append(" (");
		sql.append(" 	ID");
		sql.append(" 	,NAME");
		sql.append(" 	,EMPLOYEE_CD");
		sql.append(" 	,PASSWORD");
		sql.append(" 	,CMPN_CD");
		sql.append(" )");
		sql.append(" VALUES");
		sql.append(" (");
		sql.append(" 	?");//BORROW_CD
		sql.append(" 	,?");//LOAN_CMPN_CD
		sql.append(" 	,?");//LOAN_DEPT
		sql.append(" 	,?");//ASSET_RFID
		sql.append(" 	,?");//BORROW_CMPN_CD
		sql.append(" )");
		
		return sql.toString();
	}

}
