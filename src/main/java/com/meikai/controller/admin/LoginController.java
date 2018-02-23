/**
 * 
 */
package com.meikai.controller.admin;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.meikai.shop.entity.TSystemManager;
import com.meikai.shop.service.ManagerService;
import com.meikai.util.IpUtils;
import com.meikai.util.MD5;

/**
 * @author meikai
 *  登录
 */

@Controller("loginController")
@RequestMapping("/admin/common")
public class LoginController {
	
	@Resource
	private ManagerService managerService ;
	
	/**
	 * 管理员登录界面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/loginPage",method=RequestMethod.GET)
	public String loginPage(HttpServletRequest request){
		
		return "all/admin/authority/manager/manager-login";
		
	}
	
	
	/**
	 * 登录
	 * @param request
	 * @param managerName
	 * @param password
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> testLogined(HttpServletRequest request,HttpServletResponse response, String managerName,String password){
		
		Map<String,Object> result =new HashMap<String,Object>();
		
		
		
		//对字符串加密
		MD5 md5=new MD5();
		String passwordCode=md5.start(password);
		UsernamePasswordToken token=new UsernamePasswordToken(managerName,passwordCode);
		
		org.apache.shiro.subject.Subject subject=SecurityUtils.getSubject();
		
		
		
		/**
		 * 捕捉的错误
		 * UnknownAccountException （账号错误）
		 * IncorrectCredentialsException （密码错误）
		 * DisabledAccountException（帐号被禁用）
		 * LockedAccountException（帐号被锁定）
		 * ExcessiveAttemptsException（登录失败次数过多）
		 * 
		 */
		try {  
			
			subject.login(token);
						
		} catch (UnknownAccountException ex) {  
			result.put("valid", "false");
			return result;
		} catch (IncorrectCredentialsException ex) {  
			result.put("valid", "false"); 
			return result;
		} 
		
		
		
				
		
		TSystemManager manager = new TSystemManager();
		
		manager = managerService.getRolesAndAclsByName(managerName);
		
		/**
		 * 如果账号不启用状态
		 */
		if(manager.getIsEnable()==1) {
			result.put("valid", "disabled");
			return result;
		}
		
		
		//设置登录的IP地址
		manager.setLoginIp(IpUtils.getIpAddr(request));
		//设置登录时间
		manager.setLoginTime(new Date());
		/**
		 * 更新到数据库
		 */
		managerService.updateEntity(manager);
		
		
		Session session = subject.getSession(); 
		
		session.setAttribute("manager", manager);
		//返回正确判断
		result.put("valid", "true");
		
		//上一个浏览的非Ajax的地址，在登录后，取得地址，如果不为null，那么就跳转过去。
		String redirectUrl =null;
		if(WebUtils.getSavedRequest(request) !=null)
	    redirectUrl =WebUtils.getSavedRequest(request).getRequestUrl();
				
		if(redirectUrl!=null) {
			result.put("target", redirectUrl);
			return result;
		}
		
		result.put("target", request.getContextPath()+"/admin/common/main");	
		
		return result;
		
	}
	

	
	
	@RequestMapping("/unauthorized")
	public String unauthorized(){
		return "/all/error/unauthorized";
	}
	
	
	/**
	 * 退出登录
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		
		org.apache.shiro.subject.Subject subject=SecurityUtils.getSubject();
		subject.logout();
		
		try {
			 request.getSession();
			response.sendRedirect(request.getContextPath()+"/admin/common/loginPage");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
