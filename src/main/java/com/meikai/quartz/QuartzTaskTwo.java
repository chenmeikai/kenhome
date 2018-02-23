/**
 * 
 */
package com.meikai.quartz;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.springframework.stereotype.Component;

/**
 * 任务二
 * @author Administrator
 * @version 2017年9月25日 上午10:26:34
 */


public class QuartzTaskTwo {
	
	public void test2(){
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time =sd.format(cal.getTime());
		System.out.println("任务二的当前时间是------"+time);
	}

}
