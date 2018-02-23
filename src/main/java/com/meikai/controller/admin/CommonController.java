/**
 * 
 */
package com.meikai.controller.admin;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.meikai.shop.entity.TSystemAcl;
import com.meikai.shop.service.AclService;

/**
 * 控制台
 * @author meikai
 * @version 2017年9月24日 下午10:01:28
 */
@Controller("conmmon")
@RequestMapping("/admin/common/")
public class CommonController {
	
	@Resource
	private AclService aclService ;
	
	/**
	 * 控制台首页
	 */
     @RequestMapping("main")
     public String main(HttpServletRequest request ,ModelMap model) {
    	 
    	 /**
    	  * 首级菜单
    	  */
    	 List<TSystemAcl> firstGradeAcls = aclService.getGradeAcls(1);
    	 
    	 /**
    	  * 二级菜单
    	  */
    	 
    	 List<TSystemAcl> secondGradeAcls = aclService.getGradeAcls(2);
    	 
    	 request.setAttribute("firstGradeAcls", firstGradeAcls);
    	 
    	 request.setAttribute("secondGradeAcls", secondGradeAcls);
    	 
    	 return "/all/admin/common/main";
    	 
     }
     
     /**
 	 * 控制台首页
 	 */
      @RequestMapping("main2")
      public String main2(HttpServletRequest request ,ModelMap model) {
     	 
     	 /**
     	  * 首级菜单
     	  */
     	 List<TSystemAcl> firstGradeAcls = aclService.getGradeAcls(1);
     	 
     	 /**
     	  * 二级菜单
     	  */
     	 
     	 List<TSystemAcl> secondGradeAcls = aclService.getGradeAcls(2);
     	 
     	 request.setAttribute("firstGradeAcls", firstGradeAcls);
     	 
     	 request.setAttribute("secondGradeAcls", secondGradeAcls);
     	 
     	 return "/all/admin/common/main2";
     	 
      }
     
    
     

     
     
     
}     