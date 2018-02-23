/**
 * 
 */
package com.meikai.kenhome.test;


/**
 * @author meikai
 * @version 2018年1月13日 下午9:42:00
 */
public class ValueTest {
    
	 public static void main(String[] args)
	    {
	        int x = 0;
	        int y = 0;
	        int k = 0;
	        for (int z = 0; z < 5; z++) {
	            if ((++x > 2) && (++y > 2) && (k++ > 2))
	            {
	                x++;
	                ++y;
	                k++;
	            }
	        }
	        System.out.println(x + ""  +y +"" +k);
	    }
    
    
   
}
