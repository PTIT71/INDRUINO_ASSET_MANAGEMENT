package com.asset.management.util;

import javax.servlet.http.HttpServletRequest;

import com.sun.org.apache.bcel.internal.generic.RETURN;

public class SystemControl {
	
	public static String CompanyCD = null;
	public static String EmployeeCD = null;
	
	public SystemControl()
	{
		
	}
	public SystemControl(HttpServletRequest request)
	{
		CompanyCD = (String) request.getSession().getAttribute(Constants.SESSION_USER_CMPN_CD);
	}
	
	public void setProperties()
	{
		//getCompanyImformation();
	}
	public void getProperties()
	{
		//getCompanyImformation();
	}
	
	public String getCompanyCD()
	{
		return CompanyCD;
	}

}
