/**
 * 
 */
package com.meikai.quartz;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

/**
 * 任务一
 * @author Administrator
 * @version 2017年9月25日 上午10:26:34
 */
public class QuartzTaskOne {
	
	
	public void test(){
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time =sd.format(cal.getTime());
		System.out.println("任务一的当前时间是------"+time);
	}

}
