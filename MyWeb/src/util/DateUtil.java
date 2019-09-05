package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * 将字符串转为Date格式
 * 
 * @author seirin
 * @version v1.0
 */
public class DateUtil {
	public static Date stringToDate(String str) {
		Date date = null;
		DateFormat df = DateFormat.getDateTimeInstance();
		try {
			date = df.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
