/**
 * 
 */
package com.meikai.kenhome.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.meikai.activemq.QueueSender;
import com.meikai.util.FilterSignUtils;

/**
 * 生产者
 * @author meikai
 * @version 2018年1月10日 下午11:20:04
 */
public class ActivemqTest {
	
	
	
	@Test
	public void test() {
		
		String a =null;
		if(StringUtils.isBlank(a)) {
			System.out.println("hello world");
		}
	}
	
	@Test
	public void test2() throws ParseException {
		
		String s ="20180111163638";
		String pattern ="yyyyMMddHHmmss";
		SimpleDateFormat sf =new SimpleDateFormat(pattern);
		Date date =sf.parse(s);
		String pattern2 ="yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sf2 =new SimpleDateFormat(pattern2);
		String time =sf2.format(date);
		System.out.println(time);
		
	}
	
	@Test
	public void test3() {
		String str ="hello,world、tomcat。and:well";
		String s = FilterSignUtils.formart(str);
		System.out.println(s);
		
	}
	
     @Test
     public void test4() {
    	 String ss ="hello-world-tomcat-svn";
    	 String s = ss.replace("-", "|");
    	 System.out.println(s);
     }
	
     @Test
     public void test5() {
    	 String ss ="wearethedreamer";
    	 
     }

}
