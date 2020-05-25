package com.asset.management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.asset.management.database.DatabaseConnection;
import com.asset.management.model.BorrowAssetModel;
import com.asset.management.model.LoanAssetModel;
import com.asset.management.util.Common;

public class LoanAssetInsertDao {
	LoanAssetModel bam = null;
	
	public LoanAssetInsertDao()
	{
		
	}
	
	public LoanAssetInsertDao(LoanAssetModel bams)
	{
		this.bam = bams;
	}
	
	public int excute() throws SQLException
	{
		int result = 0;
		
		DatabaseConnection conn = new DatabaseConnection();
		Connection connectString = conn.getConnection();
		PreparedStatement sqlStatement = connectString.prepareStatement(getSQL());
		System.out.println(getSQL());
		
			sqlStatement.setString(1,Common.getDateCurrent("YYYYMMDDHHMMSS"));
			sqlStatement.setString(2,bam.getLoan_cmpn_cd());
			sqlStatement.setString(3,bam.getLoan_dept());
			//System.out.println(bam.getName());
			sqlStatement.setString(4,bam.getAsset_rfid());
			sqlStatement.setString(5,bam.getBorrow_cmpn_cd());
			sqlStatement.setString(6,bam.getBorrow_dept());
			sqlStatement.setString(7,bam.getLoad_Date());
			sqlStatement.setString(8,bam.getPay_date());
			sqlStatement.setString(9,bam.getBorrow_reason());
			sqlStatement.setString(10,"");
			sqlStatement.setString(11,Common.getDateCurrent("YYYYmmdd"));
			sqlStatement.setString(12,"3");
			
			 result = sqlStatement.executeUpdate();
		
		return result;
	}
	
	public String getSQL()
	{
StringBuilder sql = new StringBuilder();
		
		sql.append(" INSERT INTO");
		sql.append(" LOAN_ASSET");
		sql.append(" (");
		sql.append(" 	LOAN_CD");
		sql.append(" 	,LOAN_CMPN_CD");
		sql.append(" 	,LOAN_DEPT");
		sql.append(" 	,ASSET_RFID");
		sql.append(" 	,BORROW_CMPN_CD");
		sql.append(" 	,BORROW_DEPT");
		sql.append(" 	,DATE_START");
		sql.append(" 	,DATE_END");
		sql.append(" 	,REASON");
		sql.append(" 	,USER_TS");
		sql.append(" 	,INSERT_DT");
		sql.append(" 	,STATUS");
		sql.append(" )");
		sql.append(" VALUES");
		sql.append(" (");
		sql.append(" 	?");//BORROW_CD
		sql.append(" 	,?");//LOAN_CMPN_CD
		sql.append(" 	,?");//LOAN_DEPT
		sql.append(" 	,?");//ASSET_RFID
		sql.append(" 	,?");//BORROW_CMPN_CD
		sql.append(" 	,?");//BORROW_DEPT
		sql.append(" 	,?");//DATE_START
		sql.append(" 	,?");//DATE_END
		sql.append(" 	,?");//REASON
		sql.append(" 	,?");//USER_TS
		sql.append(" 	,?");//INSERT_DT
		sql.append(" 	,?");//STATUS
		sql.append(" )");
		
		return sql.toString();
	}

}
