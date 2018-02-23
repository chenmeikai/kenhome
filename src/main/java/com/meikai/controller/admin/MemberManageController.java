/**
 * 
 */
package com.meikai.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 用户管理
 * @author meikai
 * @version 2017年9月25日 下午11:30:37
 */

@Controller("memberManageController")
@RequestMapping("/admin/member/member")
public class MemberManageController {
	
	/**
	 * 用户管理中心
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("main")
	public String memberList(HttpServletRequest request ,ModelMap model){
		
		return "";
		
	}
	
	@RequestMapping(value="list/{id}",method = RequestMethod.GET)
	public String memberView(HttpServletRequest request ,ModelMap model,@PathVariable Long id){
		
		return "";
		
	}

}
