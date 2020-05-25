package com.asset.management.util;

import javax.servlet.http.HttpServletRequest;

import com.sun.org.apache.bcel.internal.generic.RETURN;

public class SystemControl {
	
	public static String CompanyCDUser = null;
	public static String CompanyCDCurrent= null;
	public static String EmployeeCD = null;
	
	public SystemControl()
	{
		
	}
	public SystemControl(HttpServletRequest request)
	{
		CompanyCDUser = (String) request.getSession().getAttribute(Constants.SESSION_USER_CMPN_CD);
		CompanyCDCurrent = (String) request.getSession().getAttribute(Constants.SUB_SYSTEM_CD);
		EmployeeCD = (String) request.getSession().getAttribute(Constants.SESSION_USER_ID);
	}
	
	public void setProperties()
	{
		//getCompanyImformation();
	}
	public void getProperties()
	{
		//getCompanyImformation();
	}
	
	

}
