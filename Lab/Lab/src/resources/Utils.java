package resources;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//import org.apache.poi.util.IOUtils;


public final class Utils { 
	
	private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	public static Date stringToDate(String dateStr) {
		try {
			return dateFormat.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String dateToString(Date date) {
		try {
			return dateFormat.format(date);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
