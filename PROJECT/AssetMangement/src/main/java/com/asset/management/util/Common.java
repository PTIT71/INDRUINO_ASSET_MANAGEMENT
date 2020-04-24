package com.asset.management.util;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar; 
public class Common {
	
	public static String TITLE_MENU="TittleScreen";
	
	
	public static String getDateCurrent(String format)
	{
	     Date date = Calendar.getInstance().getTime();  
	     DateFormat dateFormat = new SimpleDateFormat(format);  
	     String strDate = dateFormat.format(date);  
			System.out.println(strDate);
		 return strDate;
	}
	
	public static String convertDateToString(Date date, String format)
	{
	     DateFormat dateFormat = new SimpleDateFormat(format); 
	     String strDate = dateFormat.format(date);  
			System.out.println(strDate);
		 return strDate;
	}
	
	public static String convertStringToDateString(String dateInString, String format) throws ParseException
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
		Date date = formatter.parse(dateInString);
        System.out.println(date);
        System.out.println(formatter.format(date));
		 return formatter.format(date);
	}


}
