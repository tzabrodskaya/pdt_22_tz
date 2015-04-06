package com.example.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateGenerator {
	
	public static Date generateDate(Calendar initialDate, Calendar finalDate) {
    	return new Date(generateLongBetween(initialDate.getTimeInMillis(), finalDate.getTimeInMillis()));
    }
		
    private static long generateLongBetween(long start, long end) {
    	return start + (long) Math.round(Math.random() * (end - start));
    }
   
	public static void main (String[] args) {
		
		/*Calendar initialDate = new GregorianCalendar(1940,1,1);
		Calendar finalDate = new GregorianCalendar(2000,1,1);
	
		Date generatedData = generateDate(initialDate,finalDate);
		
		//DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss")
		DateFormat df = new SimpleDateFormat("yyyyMMMM d", Locale.ENGLISH);
		System.out.println(df.format(generatedData));
		System.out.println(df.format(generatedData).substring(0, 4));
		
		System.out.println(df.format(generatedData).replaceAll("[^a-zA-Z]",""));
		System.out.println(df.format(generatedData).replaceAll("\\d+\\w+ ",""));
		//TODO: jodaTime - pochitat'
//		 * 
		 */
	}	


}
