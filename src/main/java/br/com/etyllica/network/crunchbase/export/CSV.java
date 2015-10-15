package br.com.etyllica.network.crunchbase.export;

import java.text.SimpleDateFormat;

public class CSV {

	public static final String SEP = ",";
	public static final String NEW_LINE = "\r\n";

	public static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd");
	
	public static String avoidNull(String text) {
		if(text == null) {
			return "";
		}
		return text;
	}
	
	public static String month(String date) {
		if(date == null)
			return "";
		return year(date)+"-"+date.split("-")[1];	
	}

	public static String year(String date) {
		if(date == null)
			return "";

		return date.split("-")[0];
	}

	public static String quarter(String date) {
		if(date == null)
			return "";
		String month = date.split("-")[1];
		int m = Integer.parseInt(month);
		return year(date)+"-Q"+(m/4+1);
	}
	
}
