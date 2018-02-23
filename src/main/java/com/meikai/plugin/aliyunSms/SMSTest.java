/**
 * 
 */
package com.meikai.plugin.aliyunSms;

import com.aliyuncs.exceptions.ClientException;


/**
 * @author Administrator
 * @version 2017年8月31日 下午3:35:30
 */
public class SMSTest {

	/**
	 * @param args
	 * @throws ClientException 
	 */
	public static void main(String[] args) throws ClientException {
		
		String phoneNumbers ="13068259290";
				
		String validateCode="123456";	
		
		SendSms.sendSms(phoneNumbers, validateCode);
		
	}

}
