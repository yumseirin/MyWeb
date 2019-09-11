package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 将字符串转为Date格式
 * 
 * @author seirin
 * @version v2.0
 */
public class DateUtil {
	public static Date stringToDate(String str) {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
			Log.logger.error(e.toString());
		}
		return date;
	}
}
