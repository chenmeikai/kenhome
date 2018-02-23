package com.meikai.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * 
 *         字母 日期或时间元素 表示 示例 <br>
 *         G Era 标志符 Text AD <br>
 *         y 年 Year 1996; 96 M 年中的月份 Month July; Jul; 07 <br>
 *         w 年中的周数 Number 27 <br>
 *         W 月份中的周数 Number 2 <br>
 *         D 年中的天数 Number 189 <br>
 *         d 月份中的天数 Number 10 <br>
 *         F 月份中的星期 Number 2 E 星期中的天数 Text Tuesday; Tue <br>
 *         a Am/pm 标记 Text PM <br>
 *         H 一天中的小时数（0-23） Number 0 <br>
 *         k 一天中的小时数（1-24） Number 24 <br>
 *         K am/pm 中的小时数（0-11） Number 0 <br>
 *         h am/pm 中的小时数（1-12） Number 12 <br>
 *         m 小时中的分钟数 Number 30 <br>
 *         s 分钟中的秒数 Number 55 <br>
 *         S 毫秒数 Number 978 <br>
 *         z 时区 General time zone Pacific Standard Time; PST; GMT-08:00 <br>
 *         Z 时区 RFC 822 time zone -0800 <br>
 * 
 * 
 */
public class DateUtils {
	public static int TIME_MONTH = Calendar.MONTH;

	public static final int TIME_HOUROFDAY = Calendar.HOUR_OF_DAY;

	public static int TIME_DAYOFYEAR = Calendar.DAY_OF_YEAR;

	public static final int TIME_MINUTE = Calendar.MINUTE;

	public static final int TIME_SECOND = Calendar.SECOND;
	
	public static int TIME_YEAR = Calendar.YEAR;

	public static int TIME_DAYOFWEEK = Calendar.DAY_OF_WEEK;

	/**
	 * 日期运算
	 * 
	 * @param date
	 *            源
	 * @param part
	 *            操作部份
	 * @param value
	 *            改变值
	 * @return 计算后的日期
	 */
	public static Date add(Date date, int part, int value) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(part, value);
		return calendar.getTime();
	}

	/**
	 * 取两个日期的差值
	 * 
	 * @param from
	 *            开始时间
	 * @param to
	 *            结束时间
	 * @param part
	 *            Time_Minute--相关多少分,Time_HourOfDay-时，other-天
	 * @return 差值
	 */
	public static long diff(Date from, Date to, int part) {
		if (to == null || from == null)
			return 0;
		long d = to.getTime() - from.getTime();
		switch (part) {
		case TIME_SECOND:
			return d / 1000;
		case TIME_MINUTE:
			return d / 1000 / 60;
		case TIME_HOUROFDAY:
			return d / 1000 / 60 / 60;
		default:
			return d / 1000 / 60 / 60 / 24;
		}

	}

	/**
	 * 格式化为指定格式的日期，缺省以东八区时间格式化
	 * 
	 * @param date
	 * @param format
	 *            如 yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String format(Date date, String format) {
		return format(date, format, "GMT+8");
	}

	public static String format(Date date) {
		return format(date, "yyyy-MM-dd HH:mm:ss", "GMT+8");
	}

	/**
	 * 日期格式化函数
	 * 
	 * @param date
	 * @param format
	 * @param timeZone
	 *            时区如东八区GMT+8
	 * @return
	 */
	public static String format(Date date, String format, String timeZone) {

		if (date == null)
			return "";
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		if (timeZone != null && !timeZone.trim().equals(""))
			formatter.setTimeZone(TimeZone.getTimeZone(timeZone));
		return formatter.format(date);
	}

	/**
	 * 格式化为指定格式的日期，缺省以东八区时间格式化
	 * 
	 * @param date
	 * @param format
	 *            如 yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String formatDateTime(Date date, String format) {

		return formatDateTime(date, format, true);
	}

	/**
	 * 格式化为指定格式的日期
	 * 
	 * @param date
	 * @param format
	 * @param locate
	 *            当locate为true时使用东八区时间格式化，否则不进行时区转换
	 * @return
	 */
	public static String formatDateTime(Date date, String format, boolean locate) {
		if (date == null)
			return "";
		if (locate)
			return formatDateTime(date, format, "GMT+8");
		else
			return formatDateTime(date, format, null);

	}

	/**
	 * 日期格式化函数
	 * 
	 * @param date
	 * @param format
	 * @param timeZone
	 *            时区如东八区GMT+8
	 * @return
	 */
	public static String formatDateTime(Date date, String format,
			String timeZone) {

		if (date == null)
			return "";
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		if (timeZone != null && !timeZone.trim().equals(""))
			formatter.setTimeZone(TimeZone.getTimeZone(timeZone));
		return formatter.format(date);
	}

	/**
	 * 获取指定日期的部份如月,以东8区为准
	 * 
	 * @param date
	 * @param part
	 * @return
	 */
	public static int get(Date date, int part) {
		return get(date, part, "");

	}

	/**
	 * 获取日期的部份数据
	 * 
	 * @param date
	 * @param part
	 * @param timeZone
	 *            时区如GMT+8
	 * @return
	 */
	public static int get(Date date, int part, String timeZone) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		if (timeZone != null && !timeZone.trim().equals(""))
			calendar.setTimeZone(TimeZone.getTimeZone(timeZone));
		int ret = calendar.get(part);
		if (part == TIME_MONTH)
			ret++;
		return ret;

	}

	/**
	 * 时区转换
	 * 
	 * @param date
	 * @param locate
	 * @return
	 */
	public static Date get(Date date, String locate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		if (locate != null && !locate.trim().equals(""))
			calendar.setTimeZone(TimeZone.getTimeZone(locate));
		return calendar.getTime();
	}

	/**
	 * 取出时间中的日期
	 * 
	 * @param date
	 * @return
	 */
	public static int getDaily(Date date) {

		return getTimePart(date, Calendar.DATE);

	}

	/**
	 * 取出时间月份的天数
	 * 
	 * @param date
	 * @return
	 */
	public static int getDay(Date date) {
		Calendar cal = new GregorianCalendar(getYear(new Date()),
				getMonth(new Date()), 1);
		return cal.getActualMaximum(Calendar.DAY_OF_MONTH);

	}



	/**
	 * 取出时间中的小时
	 * 
	 * @param date
	 * @return
	 */
	public static int getHour(Date date) {

		return getTimePart(date, Calendar.HOUR_OF_DAY);

	}

	

	/**
	 * 取出时间中的分钟
	 * 
	 * @param date
	 * @return
	 */
	public static int getMinute(Date date) {

		return getTimePart(date, Calendar.MINUTE);

	}



	/**
	 * 取出时间中的月份
	 * 
	 * @param date
	 * @return
	 */
	public static int getMonth(Date date) {

		return getTimePart(date, Calendar.MONTH);

	}



	/**
	 * 获取指定日期的部份如月,以东8区为准
	 * 
	 * @param date
	 * @param part
	 * @return
	 */
	public static int getTimePart(Date date, int part) {
		return getTimePart(date, part, "GMT+8");

	}

	/**
	 * 获取日期的部份数据
	 * 
	 * @param date
	 * @param part
	 * @param timeZone
	 *            时区如GMT+8
	 * @return
	 */
	public static int getTimePart(Date date, int part, String timeZone) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		if (timeZone != null && !timeZone.trim().equals(""))
			calendar.setTimeZone(TimeZone.getTimeZone(timeZone));
		return calendar.get(part);

	}

	/**
	 * 取当前日期
	 * 
	 * @param includeHours
	 *            是否包括时分
	 * @param zone
	 *            时区
	 * @return Date
	 */
	public static Date getToday(boolean includeHours, String zone) {
		if (includeHours)
			return get(new Date(), zone);
		else
			return valueOf(format(new Date(), "yyyy-MM-dd", zone), "");
	}

	/**
	 * 取出时间中的年份数据
	 * 
	 * @param date
	 * @return
	 */
	public static int getYear(Date date) {

		return getTimePart(date, Calendar.YEAR);

	}

	/**
	 * 字符转换为日期。
	 * 
	 * @param source
	 * @param patterns日期格式串如yyyy
	 *            -MM-dd HH:mm:ss
	 * @return
	 */
	public static Date stringToDate(String source, String patterns) {
		return stringToDate(source, patterns, true);
	}

	/**
	 * 字符转换为日期。
	 * 
	 * @param source
	 * @param patterns日期格式串如yyyy
	 *            -MM-dd HH:mm:ss
	 * @param locate
	 *            true--转化为东八区时间
	 * @return
	 */
	public static Date stringToDate(String source, String patterns,
			boolean locate) {
		if (locate)
			return stringToDate(source, patterns, "GMT+8");
		else
			return stringToDate(source, patterns, "");
	}

	/**
	 * 字符串转换为指定时区时间
	 * 
	 * @param source
	 * @param patterns
	 * @param timeZone如东八区GMT
	 *            +8
	 * @return
	 */
	public static Date stringToDate(String source, String patterns,
			String timeZone) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(patterns);
		Date date = null;
		if (source == null)
			return date;
		if (timeZone != null && !timeZone.trim().equals(""))
			dateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));
		try {
			date = dateFormat.parse(source);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}

		return date;
	}

	/**
	 * 字符转换为日期。
	 * 
	 * @param source
	 * @param patterns日期格式串如yyyy
	 *            -MM-dd HH:mm:ss
	 * @return
	 */
	public static Date valueOf(String source, String patterns) {
		return valueOf(source, patterns, "GMT+8");
	}

	/**
	 * 字符串转换为指定时区时间
	 * 
	 * @param value
	 * @param patterns
	 *            如yyyy-MM-dd HH:mm:ss
	 * @param timeZone如东八区GMT
	 *            +8
	 * @return
	 */
	public static Date valueOf(String value, String patterns, String timeZone) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(patterns);
		Date date = null;
		if (value == null)
			return date;
		if (timeZone != null && !timeZone.trim().equals(""))
			dateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));
		try {
			date = dateFormat.parse(value);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}

		return date;
	}

	/**
	 * 字符串转换为指定时区时间
	 * 
	 * 默认根据字串长度格式为yyyy-MM-dd或yyyy-MM-dd HH:mm
	 * 
	 * @param value
	 *            日期
	 * @param timeZone
	 *            timeZone如东八区GMT+8
	 * @return
	 */
	public static Date valueOfA(String value, String timeZone) {
		if (value == null || value.length() == 10)
			return valueOf(value, "yyyy-MM-dd", timeZone);
		else
			return valueOf(value, "yyyy-MM-dd HH:mm", timeZone);
	}

	/**
	 * 
	 * @param date
	 * @return
	 */
	public static Date lastDayOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int value = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH, value);
		return cal.getTime();
	}

	public static Date firstDayOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int value = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH, value);
		return cal.getTime();
	}

	/**
	 * 按照格式格式化成date型
	 * 
	 * 
	 * @param dateStr
	 * @param pattern
	 * @return
	 */
	public static Date parseDate(String dateStr, String pattern) {
		try {
			return new SimpleDateFormat(pattern).parse(dateStr);
		} catch (Exception e) {
			throw new IllegalStateException("parse date string has a error:"
					+ e.getMessage(), e);
		}
	}

	/**
	 * 按照格式格式化成date型 默认 pattern yyyy-MM-dd HH:mm:ss
	 * 
	 * @param dateStr
	 * @return
	 */
	public static Date parseDate(String dateStr) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateStr);
		} catch (Exception e) {
			throw new IllegalStateException("parse date string has a error:"
					+ e.getMessage(), e);
		}
	}

	/**
	 * 按照格式格式化成date型
	 * 
	 * 
	 * @param dateStr
	 * @param pattern
	 * @return
	 */
	public static Date parseDate(Date date, String pattern) {
		try {

			return new SimpleDateFormat(pattern).parse(format(date, pattern));
		} catch (Exception e) {
			throw new IllegalStateException("parse date string has a error:"
					+ e.getMessage(), e);
		}
	}

	/**
	 * 返回年份字符串
	 * 
	 * @param date
	 * @param format
	 *            yyyy or yy
	 * @return
	 */
	public static String getYearStr(Date date, String format) {
		String y = String.valueOf(getYear(date));
		if (format.equals("yyyy")) {
			return y;
		} else if (format.equals("yy")) {
			return y.substring(2, 4);
		}
		return y;
	}

	/**
	 * 获取月份字符串 格式:MM
	 * 
	 * @param date
	 * @return
	 */
	public static String getMonthStr(Date date) {
		int m = getMonth(date);

		if (m + 1 > 9) {
			return String.valueOf(m + 1);
		} else {
			return "0" + String.valueOf(m + 1);
		}
	}

	/**
	 * 返回时间字符串 格式 YYMM,主要用于月表后缀
	 * 
	 * @param date
	 * @return
	 */
	public static String getYYMMStr(Date date) {
		return getYearStr(date, "yy") + getMonthStr(date);
	}
	
	/**
	 * 返回时间字符串 格式 YYYYMM,主要用于月表后缀
	 * 
	 * @param date
	 * @return
	 */
	public static String getYYMMStr2(Date date) {
		return getYearStr(date, "yyyy") + "_"+getMonthStr(date);
	}

	/**
	 * 根据时间区间,返回月表后缀字符串数组 [1111,1112,1201,1202...]
	 * 
	 * @param from
	 * @param to
	 * @return
	 */
	public static String[] getYYMMArr(Date from, Date to) {
		String[] result = null;
		long yDiff = DateUtils.getYear(to) - DateUtils.getYear(from);
		long mDiff = DateUtils.getMonth(to) - DateUtils.getMonth(from);
		if (yDiff == 0 && mDiff == 0) {
			result = new String[1];
			result[0] = getYYMMStr(from);
		} else if (yDiff == 0 && mDiff != 0) {
			result = new String[(int) mDiff + 1];
			for (int i = 0; i <= mDiff; i++) {
				result[i] = getYYMMStr(from);
				from = DateUtils.add(from, DateUtils.TIME_MONTH, 1);
			}
		} else if (yDiff != 0) {
			int realMdiff = (int) (yDiff * 12 + mDiff);
			result = new String[realMdiff + 1];
			for (int i = 0; i <= realMdiff; i++) {
				result[i] = getYYMMStr(from);
				from = DateUtils.add(from, DateUtils.TIME_MONTH, 1);
			}
		}

		return result;
	}
	/**
	 * 根据时间区间,返回月表后缀字符串数组 [2017_01,2017_02,2017_03,2017_04...]
	 * 
	 * @param from
	 * @param to
	 * @return
	 */
	public static String[] getYYMMArr2(Date from, Date to) {
		String[] result = null;
		long yDiff = DateUtils.getYear(to) - DateUtils.getYear(from);
		long mDiff = DateUtils.getMonth(to) - DateUtils.getMonth(from);
		if (yDiff == 0 && mDiff == 0) {
			result = new String[1];
			result[0] = getYYMMStr(from);
		} else if (yDiff == 0 && mDiff != 0) {
			result = new String[(int) mDiff + 1];
			for (int i = 0; i <= mDiff; i++) {
				result[i] = getYYMMStr2(from);
				from = DateUtils.add(from, DateUtils.TIME_MONTH, 1);
			}
		} else if (yDiff != 0) {
			int realMdiff = (int) (yDiff * 12 + mDiff);
			result = new String[realMdiff + 1];
			for (int i = 0; i <= realMdiff; i++) {
				result[i] = getYYMMStr2(from);
				from = DateUtils.add(from, DateUtils.TIME_MONTH, 1);
			}
		}

		return result;
	}

	public static String[] getYYMMddArr(Date from, Date to) {
		String[] result = null;

		int diff = (int) diff(from, to, TIME_DAYOFYEAR);
		result = new String[diff + 1];
		for (int i = 0; i <= diff; i++) {

			String str = format(from, "yyyy-MM-dd");
			result[i] = str;
			from = add(from, TIME_DAYOFYEAR, 1);
		}

		return result;
	}

	public static String[] getYYMMddArr(String from, String to, String fmt) {

		Date f = parseDate(from, fmt);
		Date t = parseDate(to, fmt);
		String[] result = null;

		int diff = (int) diff(f, t, TIME_DAYOFYEAR);
		result = new String[diff + 1];
		for (int i = 0; i <= diff; i++) {

			String str = format(f, "yyyy-MM-dd");
			result[i] = str;
			f = add(f, TIME_DAYOFYEAR, 1);
		}

		return result;
	}
	/**
	 * 作用：获取当前日期 格式 2007－3－4 12：10：20 返回类型：Date 参数：null
	 */
	public static Timestamp datetime() {
		// 获取当前日期
		String strTimestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(Calendar.getInstance().getTime());
		// 将字符串日期转换成 java.sql.Date 日期类型
		return Timestamp.valueOf(strTimestamp);
	}
	
	public static Date tomorrowZero(){
		Date t=add(new Date(),TIME_DAYOFYEAR, 1);
		return parseDate(t, "yyyyMMdd");
	}
	
	public static void main(String[] args) {
		System.out.println(DateUtils.parseDate("2013-09-11 12:12:12",
				"yyyy-MM-dd"));

	}
}
