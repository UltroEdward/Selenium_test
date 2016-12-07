package com.manahealth.sv.ui.tests.framework.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtils {

	private static final String DEFAUL_DATE_FORMAT = "dd-MM-yyyy_HH-mm-ss";

	public static String getCurDate(String dateFormat) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat();
		format.applyPattern(dateFormat);
		return format.format(cal.getTime());
	}

	public static String getCurDate() {
		return getCurDate(DEFAUL_DATE_FORMAT);
	}

}
