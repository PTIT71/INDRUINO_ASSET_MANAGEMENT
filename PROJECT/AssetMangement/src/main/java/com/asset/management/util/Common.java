package com.asset.management.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar; 
public class Common {
	
	public static String TITLE_MENU="TittleScreen";
	
	
	public static String getDateCurren(String format)
	{
	     Date date = Calendar.getInstance().getTime();  
	     DateFormat dateFormat = new SimpleDateFormat(format);  
	     String strDate = dateFormat.format(date);  
			System.out.println(strDate);
		 return strDate;
	}

}
