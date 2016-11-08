package com.manahealth.sv.ui.tests.framework.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtils {

	public static String getCurDate() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat();
		format.applyPattern("dd-MM-yyyy_HH-mm-ss");
		return format.format(cal.getTime());
	}
}
