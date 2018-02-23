/**
 * 
 */
package com.meikai.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Administrator
 *  MD5加密
 */

public class MD5 {
	
	private static final MD5 instance = new MD5();
		
		public static MD5 getIntance() {
			return instance;
		}
		
		public String start(String value) {
			if (value == null || value.trim().equals(""))
				return null;
			else
				return md5(value);
		}
	
		// 加密成32位
		private String md5(String string) {
			MessageDigest md = null;
			try {
				md = MessageDigest.getInstance("md5");
				md.update(string.getBytes());
				byte[] md5Bytes = md.digest();
				return bytes2Hex(md5Bytes);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			return null;
		}
	
		private String bytes2Hex(byte[] byteArray) {
			StringBuffer strBuf = new StringBuffer();
			for (int i = 0; i < byteArray.length; i++) {
				if (byteArray[i] >= 0 && byteArray[i] < 16) {
					strBuf.append("0");
				}
				strBuf.append(Integer.toHexString(byteArray[i] & 0xFF));
			}
			return strBuf.toString();
		}

}
