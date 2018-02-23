/**
 * 
 */
package com.meikai.kenhome.test;

/**
 * 单例模式
 * @author meikai
 * @version 2017年11月28日 下午9:13:16
 */
public class SingleTonTest {
	
	public static void main(String args[]) {
		int a ;
		a =5/2;
		System.out.println(a);
	}
	
	
	

}


//饿汉模式
class Hungry{
	
	private Hungry() {
	}
	
	private static Hungry instance =new Hungry();
	
	public static Hungry getInstance() {
		return instance;
	}	
}

//懒汉模式
class Lazy{
	private Lazy() {}
	
	private static Lazy lazy;
	
	public static synchronized  Lazy getInstance() {
		if (lazy == null) {
			lazy =new Lazy();
		}
		return lazy;
	}	
	
}