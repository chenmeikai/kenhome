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
public class ServletTest  extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		         response.setContentType("text/html");
		         PrintWriter out = response.getWriter();
		         out.println("<!DOCTYPE html>");
		         out.println("<HTML>");
		         out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		         out.println("  <BODY>");
		         out.print("    This is ");
		         out.print(this.getClass());
		         out.println(", using the GET method");
		         out.println("  </BODY>");
		         out.println("</HTML>");
		         out.flush();
		         out.close();
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	
	

}
