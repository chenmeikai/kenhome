/**
 * 
 */
package com.meikai.listener;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.meikai.util.PropertiesUtil;

/**
 * 设值全局变量
 * @author meikai
 * @version 2017年10月23日 下午2:15:19
 */
public class PropertyListenter implements ServletContextListener {

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		
		/**
		 * 读取properties文件
		 * 
		 */
		final Logger logger = (Logger) LoggerFactory.getLogger(PropertyListenter.class);
		
		Properties properties = new Properties(); 
  	  
        InputStream in = null;
        try {
            //通过类加载器进行获取properties文件流
            in = PropertiesUtil.class.getClassLoader().getResourceAsStream("kenhome-common.properties");         
            properties.load(in);
            
        } catch (FileNotFoundException e) {
        	logger.error("未找到properties文件");
        } catch (IOException e) {
        	logger.error("发生IOException异常");
        } finally {
            try {
                if(null != in) {
                    in.close();
                }
            } catch (IOException e) {
                logger.error("properties文件流关闭出现异常");
            }
        }
             		
		
		/**
		 * 将properties文件转存到map
		 */
		Map<String, String> pros = new HashMap<String,String>((Map)properties);
		
		/**
		 * 将Map通过ServletContext存储到全局作用域中
		 */
		ServletContext sct=sce.getServletContext();  
		
		sct.setAttribute("pros", pros);

	}
	
	
		
		
		
		
	

}
