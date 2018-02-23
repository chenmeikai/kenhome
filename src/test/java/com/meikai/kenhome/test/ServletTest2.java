/**
 * 
 */
package com.meikai.kenhome.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrator
 *  Servlet测试类
 */
public class ServletTest2  extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		         response.sendRedirect("html/test2.html");
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	
	

}
