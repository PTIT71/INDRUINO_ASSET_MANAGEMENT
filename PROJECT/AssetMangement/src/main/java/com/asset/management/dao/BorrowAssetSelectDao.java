package com.asset.management.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.asset.management.database.DatabaseConnection;
import com.asset.management.model.AssetObject;
import com.asset.management.model.BorrowAssetModel;
import com.asset.management.util.SystemControl;

public class BorrowAssetSelectDao {

	BorrowAssetModel borrowAssetModel = null;

	public BorrowAssetSelectDao() {

	}

	public BorrowAssetSelectDao(BorrowAssetModel borrowAssetModel) {
		this.borrowAssetModel = borrowAssetModel;
	}

	public List<BorrowAssetModel> excute() throws SQLException {
		
		DatabaseConnection conn = new DatabaseConnection();
		Connection connectString = conn.getConnection();
		Statement stmt = connectString.createStatement();
		ResultSet result = null;
		System.out.println(getSQL());
		result = stmt.executeQuery(getSQL());
		List<BorrowAssetModel> lstAsset =new ArrayList<BorrowAssetModel>();
		while (result.next()) {
			BorrowAssetModel Asset = new BorrowAssetModel();
			Asset.setLoan_cmpn_name(result.getString("SHRT_NAME"));
			Asset.setLoan_dept(result.getString("LOAN_DEPT"));
			Asset.setLoad_Date(result.getString("DATE_START"));
			Asset.setAsset_name(result.getString("ASSET_NAME"));
			Asset.setAsset_rfid(result.getString("RFID"));
			Asset.setAsset_model(result.getString("ASSET_MODEL"));
			Asset.setAsset_series(result.getString("ASSET_SERIES"));
			Asset.setBorrow_dept(result.getString("BORROW_DEPT"));
			Asset.setBorrow_reason(result.getString("REASON"));
			Asset.setPay_date(result.getString("DATE_END"));
			Asset.setStatus(result.getString("STATUS"));
			Asset.setId(result.getString("BORROW_CD"));
			lstAsset.add(Asset);
		}
		
		return lstAsset;

	}

	public String getSQL()
	{
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT  ");
		sql.append(" SHRT_NAME ");
		sql.append(" , BORROW_CD ");
		sql.append(" , LOAN_DEPT ");
		sql.append(" , DATE_START ");
		sql.append(" , ASSET_NAME ");
		sql.append(" , BS.ASSET_RFID AS RFID");
		sql.append(" , ASSET_SERIES ");
		sql.append(" , ASSET_MODEL ");
		sql.append(" , BORROW_DEPT ");
		sql.append(" , REASON ");
		sql.append(" , DATE_END ");
		sql.append(" , STATUS ");
		sql.append("FROM ");
		sql.append("BORROW_ASSET BS ");
		sql.append("INNER JOIN  COMPANY CMPN ");
		sql.append("ON COMPANY_CD = LOAN_CMPN_CD ");
		sql.append("INNER JOIN ASSETS_GENERAL  AG ");
		sql.append("ON AG.ASSET_RFID =BS.ASSET_RFID ");
		sql.append("WHERE 1=1 ");
		if(borrowAssetModel!=null)
		{
			if(borrowAssetModel.getBorrow_cmpn_cd() != null)
			{
				sql.append("AND BS.BORROW_CMPN_CD = ").append("'"+ borrowAssetModel.getBorrow_cmpn_cd()+"'");
			}
			if(borrowAssetModel.getId() != null && borrowAssetModel.getId().trim().length()>0)
			{
				sql.append("AND BS.BORROW_CD = ").append("'"+ borrowAssetModel.getId()+"'");
			}
		}
		
		
		return sql.toString();
	}
}
