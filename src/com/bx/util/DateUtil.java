package com.bx.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @date 2016年3月29日 dateUtil.java
 * @author CZP
 * @parameter
 */
public class DateUtil {

	public static String formatDate(Date date, String format) {
		if (date != null) {
			SimpleDateFormat dateFormat = new SimpleDateFormat(format);
			return dateFormat.format(date);
		} else {
			return null;
		}
	}

	public static Date formatString(String str, String format) throws Exception {
		if (str != null) {
			SimpleDateFormat dateFormat = new SimpleDateFormat(format);
			return dateFormat.parse(str);
		} else {
			return null;
		}
	}

	public static String getCurrentDate() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		return dateFormat.format(date);
	}

}
