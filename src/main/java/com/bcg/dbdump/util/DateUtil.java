package com.bcg.dbdump.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static String formattedDateNow(String format) {
		Date date = new Date();
		SimpleDateFormat toFormat = new SimpleDateFormat(format);
		return toFormat.format(date);
	}
}
