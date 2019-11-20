/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package expressionparse;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类, 继承org.apache.commons.lang.time.DateUtils类
 *
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

	/**
	 * 年(yyyy)
	 */
	public static final String YEAR = "yyyy";

	/**
	 * 年-月(yyyy-MM)
	 */
	public static final String YEAR_MONTH = "yyyy-MM";

	/**
	 * 年-月-日(yyyy-MM-dd)
	 */
	public static final String YEAR_MONTH_DAY = "yyyy-MM-dd";

	public static final String YEAR_MONTH_DAY_Z = "yyyy年MM月dd日";

	/**
	 * 年月日(yyyyMMdd)
	 */
	public static final String YEAR_MONTH_DAY_SIMPLE = "yyyyMMdd";

	/**
	 * 年-月-日 小时(yyyy-MM-dd HH)
	 */
	public static final String YEAR_MONTH_DAY_HOUR = "yyyy-MM-dd HH";

	/**
	 * 年-月-日 小时(yyyy-MM-dd HH)中文输出
	 */
	public static final String YEAR_MONTH_DAY_HOUR_CN = "yyyy年MM月dd日HH时";

	/**
	 * 年-月-日 小时:分钟(yyyy-MM-dd HH:mm)
	 */
	public static final String YEAR_MONTH_DAY_HOUR_MINUTE = "yyyy-MM-dd HH:mm";

	/**
	 * 年-月-日 小时:分钟:秒钟(yyyy-MM-dd HH:mm:ss)
	 */
	public static final String YEAR_MONTH_DAY_HOUR_MINUTE_SECOND = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 年月日小时分钟秒钟(yyyyMMddHHmmss)
	 */
	public static final String YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_SIMPLE = "yyyyMMddHHmmss";

	/**
	 * 小时:分钟:秒钟(HH:mm:ss)
	 */
	public static final String HOUR_MINUTE_SECOND = "HH:mm:ss";

	/**
	 * 小时:分钟(HH:mm)
	 */
	public static final String HOUR_MINUTE = "HH:mm";

	/**
	 * 月.日(M.d)
	 */
	public static final String MONTH_DAY = "M.d";

	/**
	 * 一天的秒数
	 */
	private static final int DAY_SECOND = 24 * 60 * 60;

	/**
	 * 一小时的秒数
	 */
	private static final int HOUR_SECOND = 60 * 60;

	/**
	 * 一分钟的秒数
	 */
	private static final int MINUTE_SECOND = 60;
	
	private static String[] parsePatterns = {
		"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM", 
		"yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
		"yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd）
	 */
	public static String getDate() {
		return getDate("yyyy-MM-dd");
	}
	
	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String getDate(String pattern) {
		return DateFormatUtils.format(new Date(), pattern);
	}
	
	/**
	 * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String formatDate(Date date, Object... pattern) {
		if(date==null){
			return null;
		}
		if (pattern != null && pattern.length > 0) {
			if(!StringUtils.isNullOrEmpty(pattern[0])){
				return DateFormatUtils.format(date, pattern[0].toString());
			}

		}
		return DateFormatUtils.format(date, "yyyy-MM-dd");

	}
	
	/**
	 * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String formatDateTime(Date date) {
		return formatDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到当前时间字符串 格式（HH:mm:ss）
	 */
	public static String getTime() {
		return formatDate(new Date(), "HH:mm:ss");
	}

	/**
	 * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String getDateTime() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到当前年份字符串 格式（yyyy）
	 */
	public static String getYear() {
		return formatDate(new Date(), "yyyy");
	}

	public static String getYear(Date dt) {
		return formatDate(dt, "yyyy");
	}

	/**
	 * 得到当前月份字符串 格式（MM）
	 */
	public static String getMonth() {
		return formatDate(new Date(), "MM");
	}
	public static String getMonth(Date dt) {
		return formatDate(dt, "MM");
	}
	/**
	 * 得到当天字符串 格式（dd）
	 */
	public static String getDay() {
		return formatDate(new Date(), "dd");
	}
	public static String getDay(Date dt) {
		return formatDate(dt, "dd");
	}
	/**
	 * 得到当前星期字符串 格式（E）星期几
	 */
	public static String getWeek() {
		return formatDate(new Date(), "E");
	}
	
	/**
	 * 日期型字符串转化为日期 格式
	 * { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", 
	 *   "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm",
	 *   "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm" }
	 */
	public static Date parseDate(Object str) {
		if (str == null){
			return null;
		}
		try {
			return parseDate(str.toString(), parsePatterns);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 获取过去的天数
	 * @param date
	 * @return
	 */
	public static long pastDays(Date date) {
		long t = new Date().getTime()-date.getTime();
		return t/(24*60*60*1000);
	}

	/**
	 * 获取过去的小时
	 * @param date
	 * @return
	 */
	public static long pastHour(Date date) {
		long t = new Date().getTime()-date.getTime();
		return t/(60*60*1000);
	}
	
	/**
	 * 获取过去的分钟
	 * @param date
	 * @return
	 */
	public static long pastMinutes(Date date) {
		long t = new Date().getTime()-date.getTime();
		return t/(60*1000);
	}
	
	/**
	 * 转换为时间（天,时:分:秒.毫秒）
	 * @param timeMillis
	 * @return
	 */
    public static String formatDateTime(long timeMillis){
		long day = timeMillis/(24*60*60*1000);
		long hour = (timeMillis/(60*60*1000)-day*24);
		long min = ((timeMillis/(60*1000))-day*24*60-hour*60);
		long s = (timeMillis/1000-day*24*60*60-hour*60*60-min*60);
		long sss = (timeMillis-day*24*60*60*1000-hour*60*60*1000-min*60*1000-s*1000);
		return (day>0?day+",":"")+hour+":"+min+":"+s+"."+sss;
    }
	
	/**
	 * 获取两个日期之间的天数
	 * 
	 * @param before
	 * @param after
	 * @return
	 */
	public static double getDistanceOfTwoDate(Date before, Date after) {
		long beforeTime = before.getTime();
		long afterTime = after.getTime();
		return (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
	}

	/**
	 * 获取当前时间
	 * @return the number of milliseconds since January 1, 1970, 00:00:00 GMT
	 *          represented by this date.
	 */
	public static long getNowTime(){
		return new Date().getTime();
	}

	/**
	 * 获得指定日期的后几天 小时 分钟
	 * @param specifiedDay
	 * @param nextday
	 * @param hours
	 * @param min
     * @return
     */
	public static String getSpecifiedDayAfter(String specifiedDay, int nextday,int hours,int min) {
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(specifiedDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + nextday);
		if( 0 != hours ){
			int localhours = c.get(Calendar.HOUR_OF_DAY);
			c.set(Calendar.HOUR_OF_DAY, localhours + hours);
		}
		if( 0 != min){
			int localmin = c.get(Calendar.MINUTE);
			c.set(Calendar.MINUTE, localmin + min);
		}

		String dayAfter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(c.getTime());
		return dayAfter;
	}


}
