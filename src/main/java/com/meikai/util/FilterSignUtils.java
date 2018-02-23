package com.meikai.util;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * @author liaofg
 * @date 2016年7月13日
 * @what 过滤标点符号工具类
 * @description TODO
 */
public class FilterSignUtils {
	private static String REGULAR = "[\\pP\\p{Punct}]";
	/**
	  * @author liaofg
	  * @date 2016年7月13日
	  * @what 过滤字符串标点符号
	  * @description TODO
	  * @param str 要过滤的字符串
	  * @return
	 */
	public static String formart(String str){
		if(StringUtils.isBlank(str)){
			return "";
		}
		str = str.replaceAll(REGULAR, "");  
		return str;
	}
	/**
	  * @author liaofg
	  * @date 2016年7月13日
	  * @what 过滤字符串标点符号，并截取字符串长度
	  * @description TODO
	  * @param str 要过滤的字符串
	  * @param len 指定截取长度
	  * @return
	 */
	public static String formart(String str,int len){
		if(StringUtils.isBlank(str)){
			return "";
		}
		str = str.replaceAll(REGULAR, "");
		if(len<=0||str.length()<=len){
			return str;
		}
		return str.substring(0, len);
	}
}
