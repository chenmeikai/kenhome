/**********************************************
*Copyright 2016 fengxing Corporation
*
* 2016年4月22日 wangshu 创建文件
*
***********************************************/
package com.meikai.redisCache;

/**
 * @author wangshu
 * @date 2016年4月22日
 * @what 缓存常量
 * @description TODO
 */
public class CacheConstant {
	private static final String PROJECT_PREFIX="flow:";//项目前缀
	
	public static final String REQUEST_LIMT_PREFIX=PROJECT_PREFIX+"req:limit:";//请求限速key前缀
	
	public static final String NUMBER_SEGMENT="numbersegment";//号段
	
	public static final String SIGN_PREFIX="sign:appid:";//签名前缀
	
	public static final String ORDERID_APPID_PREFIX=PROJECT_PREFIX+"orderid:appid:";//订单id-appid映射key前缀
	
	public static final String ORDERID_OUTORDERID_PREFIX=PROJECT_PREFIX+"orderid:outorderid:";//订单id-接入方订单id映射key前缀

	public static final String CHANNELORDERID_ORDERID_PREFIX=PROJECT_PREFIX+"channelorderid:orderid:";//渠道方订单id-订单id映射key前缀
	public static final String MODEL_PREFIX_USER_PRODUCT_DETAILS= PROJECT_PREFIX+"userproductdetails:";//用户产品明细  +appid
	public static final String ORDER_QUOTARETURN_FLAG=PROJECT_PREFIX+"quotareturnflag:orderid:";//订单回补标记，订单id
	public static final String ORDER_REPEAT_FLAG=PROJECT_PREFIX+"repeatflag:orderid:";//订单重复标记，订单id
	public static final String REPORT_REPEAT_FLAG=PROJECT_PREFIX+"report:repeatflag:orderid:";//订单重复标记，订单id
	public static final String CHANNEL_ORDER_CALLBACK_FLAG = PROJECT_PREFIX+"channel:order_callback_flag:orderid:";//订单重复回调标记
	
	
	//Model
	public static final String MODEL_PREFIX_CHANNEL= PROJECT_PREFIX+"channel:code:";//渠道  +渠道code
	public static final String MODEL_PREFIX_PRODUCT= PROJECT_PREFIX+"product:code:";//产品  +产品code+流量值
	public static final String MODEL_PREFIX_PRODUCT_DETAIL= PROJECT_PREFIX+"productdetail:code:";//产品明细  +产品code+流量值
	public static final String MODEL_PREFIX_USER = PROJECT_PREFIX+"user:appid:";//用户 +appid
//	public static final String MODEL_PREFIX_USERWALLET= PROJECT_PREFIX+"wallet:userid:"; //钱包 +用户id
	
//	public static final String MODEL_PREFIX_USERWALLET_BLANCE= PROJECT_PREFIX+"wallet:blance:userid:"; //钱包余额
//	public static final String MODEL_PREFIX_ORDERID_MONEY= PROJECT_PREFIX+"orderid:money:"; //订单余额
	public static final String MODEL_PREFIX_SYS_PARAM= PROJECT_PREFIX+"sysparam:"; //系统参数+code
	public static final String MODEL_PREFIX_USER_PRODUCT_DETAIL= PROJECT_PREFIX+"userproductdetail:";//用户产品明细  +appid+产品code+流量值
	
	//openid
	public static final String OPENID = "orderid:openid:";
	
	//爱流量套餐
	public static final String IFLOW_PKG = "iflow:flowval:";
	//爱流量套餐产品code
	public static final String IFLOW_PKG_PRODUCT_CODE = "iflow:flowval:code:";
	
	public static final String ACCESS_TOKEN = "access_token:";
	//荆州德海渠道token
	public static final String JZDH_CHANNEL_TOKEN = "jzdh:";
	//订单回调地址缓存
	public static final String MODEL_PREFIX_ORDER_CALLBACK_URL = PROJECT_PREFIX+"ordercallbackurl:";
	//根据运营商、流量类型缓存用户产品
	public static final String MODEL_PREFIX_USER_PRODUCT_DETAILS_V2 = PROJECT_PREFIX+"userproductdetailv22:";//app_id+运营商+流量类型+号码覆盖区域
	//湖南移动token
	public static final String HUNANYD_TOKEN = "hunanydtoken:";
	//贵州格安token
	public static final String GZGA_TOKEN = "gzgatoken:";
	//黑龙江移动token
	public static final String HEILJYD_TOKEN = "heiljydtoken:";
	//渠道token
	public static final String CHANNEL_TOKEN = "channeltoken:";//channel_code:
	//订单id映射渠道code
	public static final String CHANNEL_CODE_ORDERID = "channelcode:orderid:";
	//渠道失败订单下发短信虑重flag，给商店做营销用
	public static final String SMS_FORSHOP_SENDFLAG = "smsforshopsendflag:";
}
