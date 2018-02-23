/**
 * 
 */
package com.meikai.kenhome.test;

import java.util.Random;

/**
 * 生成[min,max]的随机整数
 * @author meikai
 * @version 2017年11月4日 上午11:04:52
 */
public class RandomTest {
	
	public static void main(String args[]) {
		int num =new RandomTest().test(5,12);
		System.out.println("返回的是"+num);
				
	}
	
	/**
	 * 返回[min,max]的随机整数
	 * @param min
	 * @param max
	 * @return
	 */
	public int test(int min ,int max) {
		
		Random r = new Random();
		int num =r.nextInt(max+1-min)+min;
		return num;		 
	}
	

}

 