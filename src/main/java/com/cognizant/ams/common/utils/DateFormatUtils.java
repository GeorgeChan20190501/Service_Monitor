package com.cognizant.ams.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtils {
	public static String getSTDCNDate() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = simpleDateFormat.format(new Date());
		return date;
	}
	
	public static void main(String[] args) {
		System.out.println(getSTDCNDate());
	}
}
