package com.asset.management.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.asset.management.util.CommonSQL;

public class DatabaseConnection {
	
	Connection conn = null;
	public DatabaseConnection()
	{
		
	}
	
	public Connection getConnection() {
		
		 try {
	            Class.forName(CommonSQL.DRIVERSQLSERVER).newInstance();
	            conn = DriverManager.getConnection(CommonSQL.DB_URL, CommonSQL.DB_USER, CommonSQL.DB_PASS);
	            if(conn!=null){
	            	System.out.println("Ket Noi Thanh Cong!!");
	            }
	            else{
	            	System.out.println("Ket Noi That Bai!!");
	            }     
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		 return conn;
	}
	
	public boolean closeConnection() {
		
		try {
			this.conn.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

}
