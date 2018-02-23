/**
 * 
 */
package com.meikai.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 *  定时器测试
 */


@Component("taskTest")
public class TaskTest {
	
	
//	@Scheduled(cron = "${job.test}")
	public void test(){
		
		
		System.out.println("当前时间是:"+System.currentTimeMillis());
		
	}

}
