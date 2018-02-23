/**
 * 
 */
package com.meikai.shop.intercepter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meikai.shop.entity.TShopMember;

/**
 * 登录拦截器
 * @author meikai
 * @version 2017年11月15日 下午4:02:53
 */
public class LoginIntercepter1 implements HandlerInterceptor {

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		System.out.println("已进入拦截器");
		TShopMember user = (TShopMember) request.getSession().getAttribute("user");
		if(user != null) return true ;
				
		String loginType ="common_intercepter";
		request.getSession().setAttribute("loginType",loginType);
		
		//请求前页面
		String target_url = request.getHeader("Referer");
	   	request.getSession().setAttribute("target_url", target_url);
	   	
	   	/**
		 * 判断是否是ajax请求 ,如果是ajax请求响应头会有x-requested-with
		 */
		if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){   
			System.out.println("拦截了ajax的请求");
			//返回的结果
			Map<String,Object> result =new HashMap<String,Object>();
            result.put("valid", "noUser");
            result.put("target", request.getContextPath()+"/shop/user/login");
            //将Map转换为json
            ObjectMapper mapper = new ObjectMapper();
            String resultJson =mapper.writeValueAsString(result);
            //将json返回给前端
            response.setCharacterEncoding("UTF-8");  
            response.setContentType("application/json; charset=utf-8");  
            PrintWriter out = null;  
            try {  
                out = response.getWriter();  
                out.append(resultJson);  
            } catch (IOException e) {  
                e.printStackTrace();  
            } finally {  
                if (out != null) {  
                    out.close();  
                }  
            }  
            return false;
        }
	   	
	   	request.getRequestDispatcher("/shop/user/login").forward(request,response);  		
		return false;
	}

}
