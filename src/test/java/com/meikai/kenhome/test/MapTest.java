/**
 * 
 */
package com.meikai.kenhome.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


/**
 * @author meikai
 * @version 2018年1月15日 下午10:13:29
 */
public class MapTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Map<String,String> hs =new HashMap<String,String>();
		hs.put("one", "cat");
		hs.put("two","dog");
		hs.put("three","duck");
		hs.put("four", "fish");
		
        Iterator iterator =hs.entrySet().iterator();
        while(iterator.hasNext()) {
        	Map.Entry<String, String> entry =(Entry<String, String>) iterator.next();
        	entry.getKey();
        	entry.getValue();
        }

	}

}
