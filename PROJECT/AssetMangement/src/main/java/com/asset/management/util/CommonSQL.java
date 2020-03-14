package com.asset.management.util;

public class CommonSQL {
	 
	 public static String DB_NAME = "ASSET_MANAGEMENT";
	 public static String DB_IP="192.168.1.82";
	 public static String DB_PORT="1433";
	 public static String DB_URL = "jdbc:sqlserver://"+DB_IP+"\\SQLEXPRESS:"+DB_PORT+";databaseName="+DB_NAME+"";
     public static String DRIVERSQLSERVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
     public static  String DB_USER = "ASSET";
     public static  String DB_PASS = "123456";
}
