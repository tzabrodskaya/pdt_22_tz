package com.example.tests;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * Basic methods for Data Generation
 * 
 * @version 0.1
 *
 */

public abstract class DataGeneratorBase {

	public static String generateRandomString(String field) {
		  Random rnd = new Random();
		  if (rnd.nextInt(5) == 0) {
			  return "";
		  } else {
			  return field + rnd.nextInt();
		  }
	 }

	public static Date generateDate(Calendar initialDate, Calendar finalDate) {
		return new Date(DataGeneratorBase.generateLongBetween(initialDate.getTimeInMillis(), finalDate.getTimeInMillis()));
	}

	public static long generateLongBetween(long start, long end) {
		return start + (long) Math.round(Math.random() * (end - start));
	}

}
