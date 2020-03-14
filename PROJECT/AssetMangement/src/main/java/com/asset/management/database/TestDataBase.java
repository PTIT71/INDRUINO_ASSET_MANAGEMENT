package com.asset.management.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.formula.functions.T;

import com.asset.management.util.CommonSQL;

public class TestDataBase {
	
	private java.sql.Connection con = null;
    private final String url = "jdbc:microsoft:sqlserver://";
    private final String serverName = "192.168.1.82";
    private final String portNumber = "1433";
    private final String databaseName = "ASSET_MANAGEMENT";
    private final String userName = "sa";
    private final String password = "123456";

    public static void main(String[] args) {

        Connection conn = null;
       
        Statement stmt = null;
        ResultSet result = null;
        List<T> results = new ArrayList<T>();
        try {
            Class.forName(CommonSQL.DRIVERSQLSERVER).newInstance();
            conn = DriverManager.getConnection(CommonSQL.DB_URL, CommonSQL.DB_USER, CommonSQL.DB_PASS);
//            stmt = conn.createStatement();
//            result = null;
//            String pa,us;
//            result = stmt.executeQuery("select * from table1 ");
//
//            while (result.next()) {
//                us=result.getString("uname");
//                pa = result.getString("pass");              
//                System.out.println(us+"  "+pa);
//            }
            
            if(conn!=null)
            {
            	System.out.println("Ket Noi Thanh Cong!!");
            }
            else
            {
            	System.out.println("Ket Noi That Bai!!");
            }
//
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
		
	}


