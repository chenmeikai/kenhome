/**
 * 
 */
package com.meikai.controller.admin.authority;


import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.meikai.shop.entity.TSystemAcl;
import com.meikai.shop.service.AclService;


/**
 * @author meikai
 * @version 2017年10月13日 上午19:59:21
 * 资源
 */

@Controller("resourceController")
@RequestMapping("/admin/authority/resource/")
public class ResourceController {
	
	@Resource
	private AclService aclService;
	
	
	
	/**
	 * 资源中心
	 * @param request
	 * @param currentPage
	 * @return
	 */
	@RequestMapping(value="main",method =RequestMethod.GET)
	public String main(HttpServletRequest request) {
		
        List<TSystemAcl> acls = aclService.getRootandChildrenAcls();
        
        request.setAttribute("acls", acls);
        
        
		return "all/admin/authority/resource/resource-list";
		
	}
	
	

	
	

}
