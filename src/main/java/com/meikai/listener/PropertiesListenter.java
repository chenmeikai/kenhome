/**
 * 
 */
package com.meikai.listener;

import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import com.meikai.util.PropertiesUtil;

/**
 * 设值全局变量
 * @author meikai
 * @version 2017年10月23日 下午2:15:19
 */
public class PropertiesListenter implements ServletContextListener {

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
		 * 将properties文件存入map中
		 */
		Map<String, String> pros =PropertiesUtil.getMap("kenhome-common.properties");
		
		
		ServletContext sct=sce.getServletContext();  
		
		sct.setAttribute("pros", pros);

	}
	
	
		
		
		
		
	

}
