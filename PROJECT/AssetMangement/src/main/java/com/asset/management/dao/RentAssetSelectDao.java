package com.asset.management.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.asset.management.database.DatabaseConnection;
import com.asset.management.model.BorrowAssetModel;
import com.asset.management.model.RentAsset;

public class RentAssetSelectDao {
	RentAsset rentAsset = null;

	public RentAssetSelectDao() {

	}

	public RentAssetSelectDao(RentAsset rentAsset) {
		this.rentAsset = rentAsset;
	}

	public List<RentAsset> excute() throws SQLException {
		
		DatabaseConnection conn = new DatabaseConnection();
		Connection connectString = conn.getConnection();
		Statement stmt = connectString.createStatement();
		ResultSet result = null;
		System.out.println(getSQL());
		result = stmt.executeQuery(getSQL());
		List<RentAsset> lstAsset =new ArrayList<RentAsset>();
		while (result.next()) {
			RentAsset Asset = new RentAsset();
			Asset.setRent_cd(result.getString("RENT_CD"));
			Asset.setCmpn_cd(result.getString("COMPANY_CD"));
			Asset.setDept_cd(result.getString("DEPARTMENT_CD"));
			Asset.setDept_name(result.getString("DEPARTMENT_NAME"));
			Asset.setAsset_name(result.getString("ASSET_NAME"));
			Asset.setAccountant_cd(result.getString("ACCOUNTANT_CD"));
			Asset.setBussiness_name(result.getString("BUSSINESS_NAME"));
			Asset.setBussiness_address(result.getString("BUSSINESS_ADDRESS"));
			Asset.setRent_date(result.getString("RENT_DATE"));
			Asset.setPaid_1(result.getString("PAY_DATE_1"));
			Asset.setPaid_2(result.getString("PAY_DATE_2"));
			Asset.setStatus(result.getString("STATUS"));
			lstAsset.add(Asset);
		}
		
		return lstAsset;

	}

	public String getSQL()
	{
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append("    RENT_CD ");
		sql.append("   ,RA.CMPN_CD as COMPANY_CD ");
		sql.append("   ,DEPARTMENT_CD ");
		sql.append("   ,DEPARTMENT_NAME ");
		sql.append("   ,ASSET_NAME ");
		sql.append("   ,ACCOUNTANT_CD ");
		sql.append("   ,BUSSINESS_NAME ");
		sql.append("   ,BUSSINESS_ADDRESS ");
		sql.append("   ,RENT_DATE ");
		sql.append("   ,PAY_DATE_1 ");
		sql.append("   ,PAY_DATE_2 ");
		sql.append("   ,STATUS ");
		sql.append(" FROM RENT_ASSET RA,DEPRATMENT DT ");
		sql.append(" WHERE RA.DEPARTMENT_CD = DT.DEPT_CD ");
		if(rentAsset!=null)
		{
			if(rentAsset.getCmpn_cd() != null && rentAsset.getCmpn_cd().trim().length()>0)
			{
				sql.append(" AND RA.CMPN_CD =  ").append("'"+ rentAsset.getCmpn_cd()+"'");
			}
		}
		
		
		return sql.toString();
	}
}
