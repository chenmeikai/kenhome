package com.meikai.util;

/**
 * 全局公共参数
 * @author meikai
 * @version 2017年11月24日 下午3:45:21
 */
public final class CommonParams {
    
	/**
	 * 私有化构造函数，不可被实例化，保持单例
	 */
	private CommonParams() {}
	
	/** 日期格式配比 */
	public static final String[] DATE_PATTERNS = new String[] { "yyyy",
			"yyyy-MM", "yyyyMM", "yyyy/MM", "yyyy-MM-dd", "yyyyMMdd",
			"yyyy/MM/dd", "yyyy-MM-dd HH:mm:ss", "yyyyMMddHHmmss", 	"yyyy/MM/dd HH:mm:ss" };	
	/** 日期格式配比:yyyy-MM-dd */
	public static final String DATE_PATTERN1 ="yyyy-MM-dd";
	/** 日期格式配比:yyyyMMdd */
	public static final String DATE_PATTERN2 ="yyyyMMdd";
	/** 日期格式配比:yyyy/MM/dd */
	public static final String DATE_PATTERN3 ="yyyy/MM/dd";
	/** 日期格式配比:yyyy-MM-dd HH:mm:ss */
	public static final String DATE_PATTERN4 ="yyyy-MM-dd HH:mm:ss";
	/** 日期格式配比:DATE_PATTERN5 */
	public static final String DATE_PATTERN5 ="yyyyMMddHHmmss";
	/** 日期格式配比:yyyy/MM/dd HH:mm:ss */
	public static final String DATE_PATTERN6 ="yyyy/MM/dd HH:mm:ss";

    /** spring.properties */
    public static final String SPRING_PROPERTIES_PATH = "spring.properties";
	/** kenhome-common.properties */
    public static final String KENHONME_COMMON_PROPERTIES_PATH = "kenhome-common.properties";
	
    
	/** kenhome-setting.xml文件路径 */
	public static final String SETTING_XML_PATH = "setting/kenhome-setting.xml";

	
	/** 物流公司文件路径 */
	public static final String DELIVERY_CORP_XML_PATH = "setting/delivery_corp.xml";
	
	/** 日志记录内容request attribute名 */
	public static final String LOG_ATTRIBUTE ="operation_attribute";
	
}
