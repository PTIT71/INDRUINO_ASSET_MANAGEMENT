package com.asset.management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.asset.management.database.DatabaseConnection;
import com.asset.management.model.RentAsset;
import com.asset.management.util.Common;

public class RentAssetInsertDao {
	
	RentAsset rentAsset = null;
	
	public RentAssetInsertDao(RentAsset asset)
	{
		this.rentAsset = asset;
	}
	
	public int excute() throws SQLException
	{
		int result = 0;
		
		DatabaseConnection conn = new DatabaseConnection();
		Connection connectString = conn.getConnection();
		PreparedStatement sqlStatement = connectString.prepareStatement(getSQL());
		System.out.println(getSQL());
			
		sqlStatement.setString(1,rentAsset.getRent_cd());//RENT_CD 
		sqlStatement.setString(2,rentAsset.getCmpn_cd()); //CMPN_CD 
		sqlStatement.setString(3,rentAsset.getDept_cd());//DEPARTMENT_CD 
		sqlStatement.setString(4,rentAsset.getAsset_name());//ASSET_NAME 
		sqlStatement.setString(5,rentAsset.getAccountant_cd());//ACCOUNTANT_CD 
		sqlStatement.setString(6,rentAsset.getBussiness_name());//BUSSINESS_NAME 
		sqlStatement.setString(7,rentAsset.getBussiness_address());//BUSSINESS_ADDRESS 
		sqlStatement.setString(8,rentAsset.getRent_date());//RENT_DATE 
		sqlStatement.setString(9,rentAsset.getPaid_1());//PAY_DATE_1 
		sqlStatement.setString(10,null);//PAY_DATE_2 
		sqlStatement.setString(11,rentAsset.getStatus());//STATUS 
		sqlStatement.setString(12,rentAsset.getUser_insert());//USER_INSERT 
		sqlStatement.setString(13,rentAsset.getInsert_dt());//INSTER_DT 
		sqlStatement.setString(14,null);//USER_UPDATE 
		sqlStatement.setString(15,null);//UPDATE_DT 
		sqlStatement.setString(16,rentAsset.getRfid());//UPDATE_DT 
			
			
			
			 result = sqlStatement.executeUpdate();
		
		return result;
	}
	
	public String getSQL()
	{
		StringBuilder sql = new StringBuilder();
		
		sql.append(" INSERT INTO ");
		sql.append(" RENT_ASSET ");
		sql.append(" (");
		sql.append(" 			RENT_CD ");
		sql.append("	      ,CMPN_CD ");
		sql.append("	      ,DEPARTMENT_CD ");
		sql.append("	      ,ASSET_NAME ");
		sql.append("	      ,ACCOUNTANT_CD ");
		sql.append("	      ,BUSSINESS_NAME ");
		sql.append("	      ,BUSSINESS_ADDRESS ");
		sql.append("	      ,RENT_DATE ");
		sql.append("	      ,PAY_DATE_1 ");
		sql.append("	      ,PAY_DATE_2 ");
		sql.append("	      ,STATUS ");
		sql.append("	      ,USER_INSERT ");
		sql.append("	      ,INSTER_DT ");
		sql.append("	      ,USER_UPDATE ");
		sql.append("	      ,UPDATE_DT ");
		sql.append("	      ,ASSET_RFID ");
		sql.append(" )");
		sql.append(" VALUES");
		sql.append(" (");
		sql.append(" 			? "); //RENT_CD 
		sql.append("	      ,? "); //CMPN_CD 
		sql.append("	      ,? ");//DEPARTMENT_CD 
		sql.append("	      ,?  ");//ASSET_NAME 
		sql.append("	      ,?  ");//ACCOUNTANT_CD 
		sql.append("	      ,?  ");//BUSSINESS_NAME 
		sql.append("	      ,?  ");//BUSSINESS_ADDRESS 
		sql.append("	      ,?  ");//RENT_DATE 
		sql.append("	      ,?  ");//PAY_DATE_1 
		sql.append("	      ,?  ");//PAY_DATE_2 
		sql.append("	      ,?  ");//STATUS 
		sql.append("	      ,?  ");//USER_INSERT 
		sql.append("	      ,?  ");//INSTER_DT 
		sql.append("	      ,?  ");//USER_UPDATE 
		sql.append("	      ,?  ");//UPDATE_DT 
		sql.append("	      ,?  ");//UPDATE_DT 
		sql.append(" )");
		
		return sql.toString();
	}

}
