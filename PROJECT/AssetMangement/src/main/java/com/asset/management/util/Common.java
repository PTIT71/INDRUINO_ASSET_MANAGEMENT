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
	
	public static String TITLE_SCREEN="TittleScreen";
	public static String MESSAGE_ERROR="message";
	
	
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
        date.setMonth(date.getMonth()+1);
		 return formatter.format(date);
	}
	
	public static Date convertStringToDate(String dateInString, String formatOriginal) throws ParseException
	{
		SimpleDateFormat formatter = new SimpleDateFormat(formatOriginal);
		Date date = formatter.parse(dateInString);
		 return date;
	}
	
	public static String StandarStringDate(String strDate, String OrigalStr, String NewStr) throws ParseException
	{
		Date date = convertStringToDate(strDate, OrigalStr);
		Calendar cal = Calendar.getInstance(); cal.setTime(date); // don't forget this if date is arbitrary e.g. 01-01-2014
		cal.setTime(date);
		
		// empno = Common.convertDateToString(date, "dd/mm/yyyy");
		int month = cal.get(Calendar.MONTH) + 1;
		String empnos = cal.get(Calendar.DAY_OF_MONTH) +"/" + month + "/" + cal.get(Calendar.YEAR);
		return  Common.convertStringToDateString(empnos, "dd/mm/yyyy");
	}
	
	public static String ConvertStringToDateStr(String date, String fmt_src, String fmt_des) throws ParseException
	{
		SimpleDateFormat formatter = new SimpleDateFormat(fmt_src);
		Date DateConvert = formatter.parse(date);
		SimpleDateFormat formatter2 = new SimpleDateFormat(fmt_des);  
	    String strDate = formatter2.format(DateConvert);  
	    return strDate;
		
	}
	


}
