/**
 * 
 */
package com.meikai.controller.admin.authority;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.meikai.pageHleper.EntityPage;
import com.meikai.shop.entity.TSystemAcl;
import com.meikai.shop.entity.TSystemManager;
import com.meikai.shop.entity.TSystemRole;
import com.meikai.shop.entity.TSystemRoleAcl;
import com.meikai.shop.service.AclService;
import com.meikai.shop.service.RoleAclService;
import com.meikai.shop.service.RoleService;
import com.meikai.util.ParameterUtils;

/**
 * @author meikai
 * @version 2017年10月14日 上午23:12:21
 * 权限分配
 */

@Controller("roleAclController")
@RequestMapping("/admin/authority/roleAcl/")
public class RoleAclController {
	
	@Resource
	private RoleService roleService;
	
	@Resource
	private AclService aclService;
	
	@Resource
	private RoleAclService roleAclService;
	
	/**
	 * 权限分配中心
	 * @param request
	 * @param currentPage
	 * @return
	 */
	@RequestMapping(value="main",method =RequestMethod.GET)
	public String main(HttpServletRequest request,Integer currentPage) {
		
		/**
		 * 一页展示数量
		 */
		int pageSize=10;
		
		/**
		 *  确保当前页不为null
		 */
		if(currentPage == null) {
			currentPage = 1 ;
		}
		
		Map<String, Object> parames = ParameterUtils.getParametersMap(request);
		
		EntityPage<TSystemRole> pageInfo= roleService.getByParamesAndPage(parames, currentPage, pageSize);
		
		request.setAttribute("pageInfo", pageInfo);
		
		request.setAttribute("parames", parames);
		
		
		return "all/admin/authority/roleAcl/roleAcl-list";
		
	}
	
	
	/**
	 * 加载更多
	 * @param request
	 * @param currentPage
	 * @return
	 */
	@RequestMapping(value="loadMore",method =RequestMethod.GET)
	@ResponseBody
	public EntityPage<TSystemRole> loadMore(HttpServletRequest request,Integer currentPage) {
		
		/**
		 * 一页展示数量
		 */
		int pageSize=10;
		
		/**
		 *  确保当前页不为null
		 */
		if(currentPage == null) {
			currentPage = 1 ;
		}
		
		Map<String, Object> parames = ParameterUtils.getParametersMap(request);
		
		EntityPage<TSystemRole> pageInfo= roleService.getByParamesAndPage(parames, currentPage, pageSize);	
		return pageInfo;
		
	}
	
	
	
	
	
	
	
	/**
	 * 根据角色ID查看权限资源
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value= "viewAcl",method =RequestMethod.GET)
	public  String viewAclByRoleId(HttpServletRequest request,Long roleId) {
		
		System.out.println("获得的角色Id是："+roleId);
		
		/**
		 * request 角色名
		 */
		TSystemRole viewRole = roleService.getByID(roleId);
		String roleName="不存在角色";
		if (viewRole != null) {
			 roleName = viewRole.getRoleName();
		}	
		request.setAttribute("roleName", roleName);
		
		
		/**
		 * request 角色的资源Id
		 */
		if(roleId != null) {	
			List<TSystemRoleAcl> roleAcls =  roleAclService.getByparamList("roleId", roleId);
			// 将角色的资源ID装进Set集合
			HashSet<Long> aclIds = new HashSet<Long>();
			if(roleAcls != null) {
				for(TSystemRoleAcl roleAcl :roleAcls) {
					aclIds.add(roleAcl.getAclId());
				}			
			}
			request.setAttribute("aclIds", aclIds);
			
			
			
			/**
			 * request 资源树
			 */
	        List<TSystemAcl> acls = aclService.getRootandChildrenAcls();       
	        request.setAttribute("acls", acls);
		}
        
        
		return "all/admin/authority/roleAcl/view-resource";
		
	}
	
	
	
	/**
	 * 根据角色ID查看编辑权限资源
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value= "viewEditAcl",method =RequestMethod.GET)
	public  String viewEditAcl(HttpServletRequest request,Long roleId) {
		
		
		/**
		 * request 角色名
		 */
		TSystemRole  authorizeRole = roleService.getByID(roleId);

		request.setAttribute("authorizeRole", authorizeRole);
		
		
		/**
		 * request 角色的资源Id
		 */
		if(roleId != null) {	
			List<TSystemRoleAcl> roleAcls =  roleAclService.getByparamList("roleId", roleId);
			// 将角色的资源ID装进Set集合
			HashSet<Long> aclIds = new HashSet<Long>();
			if(roleAcls != null) {
				for(TSystemRoleAcl roleAcl :roleAcls) {
					aclIds.add(roleAcl.getAclId());
				}			
			}
			request.setAttribute("aclIds", aclIds);
		}
		
		
		/**
		 * request 资源树
		 */
        List<TSystemAcl> acls = aclService.getRootandChildrenAcls();       
        request.setAttribute("acls", acls);  
		return "all/admin/authority/roleAcl/edit-resource";
		
	}
	
	
	
	
	
	/**
	 * 角色-资源关联
	 * @param request
	 * @param response
	 * @param managerName
	 * @param password
	 * @return
	 */
	@RequestMapping(value="saveAuthorize",method =RequestMethod.POST)
	public @ResponseBody  boolean saveAdd(HttpServletRequest request,HttpServletResponse response){
		
		/**
		 * 获得角色Id
		 */
		Long roleId =Long.valueOf(request.getParameter("roleId"));
		if (roleId == null) {
			return false;
		}else {
			TSystemRole role = roleService.getByID(roleId);
			if(role == null || role.getIsSystem().equals(2))
			     return false;	
		}
		
		
		
		/**
		 * 获得资源Id集合
		 */
		String[] aclIds = request.getParameterValues("aclId");
		if (aclIds.length == 0)  return false;
			
		
		/**
		 * 获得创建者名字
		 */
		String creator = null ;
		TSystemManager manager =(TSystemManager) request.getSession().getAttribute("manager");
		if(manager != null)
			creator = manager.getManagerName();
			
		
		
		/**
		 * 获得创建时间
		 */
		 Date createDate = new Date();
		
		 
		 
		/**
		 * 先删除该角色以前的资源关联
		 */
		 roleAclService.deleteByRoleID(roleId);
		 
		 		 
		/**
		 * 重新资源关联
		 */
		 for(String aclId : aclIds) {
			 
			 TSystemRoleAcl newroleAcl = new TSystemRoleAcl();
			 newroleAcl.setCreateDate(createDate);
			 newroleAcl.setCreater(creator);
			 newroleAcl.setRoleId(roleId);
			 newroleAcl.setAclId(Long.valueOf(aclId));
			 roleAclService.saveAddEntity(newroleAcl);
		 }
		 return true;
		 
	}
	
	

	/**
	 * 去除角色与资源的关联
	 * @param id
	 * @return
	 */
	@RequestMapping(value="delete",method=RequestMethod.GET)
	public @ResponseBody String deleteByRoleId(Long roleId){
		
		/**
		 * 判断是否内置,内置则返回
		 */
		TSystemRole role = roleService.getByID(roleId);
		if(role == null || role.getIsSystem().equals(2)) return "systemRoleAcl";	
		     
	    
		/**
		 * 根据角色ID删除与资源的关联
		 */
		Long reply =roleAclService.deleteByRoleID(roleId);
		if(reply ==1) {
			return "true";
		}
		else return "false";
		
	}
	
	
	


}
