package com.zwort.matahata.core.utils;

import com.zwort.matahata.core.model.Month;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {
	
	public static Date getBeginningDate(Month month, int year) {
		Date now = new Date();
		GregorianCalendar gcal = new GregorianCalendar();
		gcal.setTime(now);
		gcal.set(Calendar.DAY_OF_MONTH, 1);
		gcal.set(Calendar.MONTH, month.ordinal());
		gcal.set(Calendar.YEAR, year);
		return gcal.getTime();
	}
	
	public static Date getEndDate(Month month) {
		Date now = new Date();
		GregorianCalendar gcal = new GregorianCalendar();
		gcal.setTime(now);
		boolean isLeapYear = isLeapYear(gcal.get(Calendar.YEAR));
		
		switch (month) {
		
			case MONTH_1:
				gcal.set(Calendar.DAY_OF_MONTH, 31);
				break;
			
			case MONTH_2:
				gcal.set(Calendar.DAY_OF_MONTH, isLeapYear ? 29 : 28);
				break;
				
			case MONTH_3:
				gcal.set(Calendar.DAY_OF_MONTH, 31);
				break;

			case MONTH_4:
				gcal.set(Calendar.DAY_OF_MONTH, 30);
				break;

			case MONTH_5:
				gcal.set(Calendar.DAY_OF_MONTH, 31);
				break;

			case MONTH_6:
				gcal.set(Calendar.DAY_OF_MONTH, 30);
				break;

			case MONTH_7:
				gcal.set(Calendar.DAY_OF_MONTH, 31);
				break;

			case MONTH_8:
				gcal.set(Calendar.DAY_OF_MONTH, 31);
				break;

			case MONTH_9:
				gcal.set(Calendar.DAY_OF_MONTH, 30);
				break;

			case MONTH_10:
				gcal.set(Calendar.DAY_OF_MONTH, 31);
				break;

			case MONTH_11:
				gcal.set(Calendar.DAY_OF_MONTH, 30);
				break;

			case MONTH_12:
				gcal.set(Calendar.DAY_OF_MONTH, 31);
				break;
				
			default:
				gcal.set(0, 0, 0);
		}
		
		return gcal.getTime();
	}

    public static java.sql.Date getCurrentSqlDate() {
        Date now = new Date();
        return new java.sql.Date(now.getTime());
    }


    private static boolean isLeapYear(int year) {
        boolean isLeapYear;

        // divisible by 4
        isLeapYear = (year % 4 == 0);

        // divisible by 4 and not 100
        isLeapYear = isLeapYear && (year % 100 != 0);

        // divisible by 4 and not 100 unless divisible by 400
        isLeapYear = isLeapYear || (year % 400 == 0);

        return isLeapYear;
	}

}
