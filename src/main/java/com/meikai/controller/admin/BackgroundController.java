/**
 * 
 */
package com.meikai.controller.admin;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 后台信息
 * @author meikai
 * @version 2017年9月29日 下午10:25:47
 */
@Controller("backgroundController")
@RequestMapping("/admin/background/")
public class BackgroundController {
	
	@RequestMapping("info")
	public String info(HttpServletRequest request ,ModelMap model) {
		
		return "/all/admin/background/info";
		
	}

	

}
