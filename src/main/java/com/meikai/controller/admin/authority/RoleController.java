/**
 * 
 */
package com.meikai.controller.admin.authority;

import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.meikai.pageHleper.EntityPage;
import com.meikai.shop.entity.TSystemManager;
import com.meikai.shop.entity.TSystemRole;
import com.meikai.shop.exportExcel.ExcelRole;
import com.meikai.shop.service.ManagerRoleService;
import com.meikai.shop.service.RoleAclService;
import com.meikai.shop.service.RoleService;
import com.meikai.util.ExcelView;
import com.meikai.util.ParameterUtils;


/**
 * @author meikai
 * @version 2017年10月11日 下午18:32:21
 * 角色
 */

@Controller("roleController")
@RequestMapping("/admin/authority/role/")
public class RoleController {
	
	@Resource
	private RoleService roleService;
	
	@Resource
	private RoleAclService roleAclServcie;
	
	@Resource
	private ManagerRoleService managerRoleService;
	
	
	/**
	 * 角色中心
	 * @param request
	 * @param currentPage
	 * @return
	 */
	@RequestMapping(value= "main",method =RequestMethod.GET)
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
		
		
		return "all/admin/authority/role/role-list";
		
	}
	
	
	/**
	 * 根据ID获得角色
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value="view",method =RequestMethod.GET)
	@ResponseBody
	public  TSystemRole view(HttpServletRequest request,Long id) {
		
		TSystemRole viewRole = roleService.getByID(id);
			
		return viewRole;
		
	}
	
	

	/**
	 * 根据角色名判定有无该角色
	 * @param roleName
	 * @return
	 */
	@RequestMapping(value="validateName",method =RequestMethod.GET)
	public @ResponseBody  boolean validateName(String roleName){
		
		TSystemRole manager = roleService.getByUniqueName(roleName);
		
		if(manager == null) {
			return true;
		}else	
		return false;
	}
	
	
	
	/**
	 * 新增角色
	 * @param request
	 * @param roleName
	 * @param description
	 * @return
	 */
	@RequestMapping(value="saveAdd",method =RequestMethod.POST)
	public @ResponseBody  boolean saveAdd(HttpServletRequest request,String roleName,String description){
		
		/**
		 * new一个角色对象
		 */
		TSystemRole newRole = new TSystemRole();
		

		/**
		 * 设置角色名字
		 */
		 newRole.setRoleName(roleName);
		
		 
		 /**
		  * 设置创建者
		  */
		 TSystemManager manager =(TSystemManager) request.getSession().getAttribute("manager");
		 if(manager != null) {
			 String creater = manager.getManagerName(); 
			 newRole.setCreater(creater);
		 }
		 
		 		
		
		 /**
		  * 设置创建时间
		  */
		 Date createDate = new Date();
		 newRole.setCreateDate(createDate);
		 
		 
		/**
		 * 设置角色描述	
		 */
		 newRole.setDescription(description);
		
		 
		 /**
		  * 新增角色
		  */
		 Long reply = roleService.saveAddEntity(newRole);
		 if(reply == 1) {
			 return true;
		 }
		 else return false;
		 
	}
	
	/**
	 * 更新角色
	 * @param request
	 * @param id
	 * @param roleName
	 * @param description
	 * @return
	 */
	@RequestMapping(value="saveEdit",method =RequestMethod.POST)
	public @ResponseBody  boolean saveEdit(HttpServletRequest request,Long id,String roleName,String description){
		
		/**
		 * 要修改的角色对象
		 */
		TSystemRole updateRole = roleService.getByID(id);

		
		
		/**
		 * 设置修改时间
		 */
		 Date updateDate = new Date();
		 updateRole.setUpdateDate(updateDate);
			
		 
		/**
		 * 设置角色名
		 */
		 updateRole.setRoleName(roleName);
		 
		 
		 /**
		  * 设置角色描述
		  */
		 updateRole.setDescription(description);
		 
		 
		 /**
		  * 设置修改者
		  */
		 TSystemManager manager =(TSystemManager) request.getSession().getAttribute("manager");
		 if(manager != null) {
			 String updater = manager.getManagerName(); 
			 updateRole.setUpdater(updater);
		 }
		 
		 
		 /**
		  * 修改角色
		  */
		 Long reply = roleService.updateEntity(updateRole);
		 
		 if(reply == 1) {
			 return true;
		 }
		 else return false;
		 
	}
	

	
	/**
	 * 删除角色
	 * @param id
	 * @return
	 */
	@RequestMapping(value="delete",method=RequestMethod.GET)
	public @ResponseBody String deleteByID(Long id){
		
		/**
		 * 获得要删除的角色
		 */
		TSystemRole role = roleService.getByID(id);
		
		
		/**
		 * 判断角色是否内置，内置则返回system信息
		 */
		if(role.getIsSystem() == 2) {
			return "system";
		}
		
		
		/**
		 * 删除与该角色的资源关联
		 */
		roleAclServcie.deleteByRoleID(id);
		
		
		/**
		 * 删除与该角色的管理员关联
		 */
		managerRoleService.deleteByRoleID(id);
		
		
		/**
		 * 删除角色
		 */
		Long reply =roleService.delete(id);
		if(reply ==1) {
			return "true";
		}
		else return "false";
		
	}
	
	
	
	/**
	 * 导出excel表
	 * @param request
	 * @return
	 */
	@RequestMapping(value="export",method =RequestMethod.GET)
	public ExcelView export(HttpServletRequest request) {
		
		
		
		Map<String, Object> parames = ParameterUtils.getParametersMap(request);
		
		List<TSystemRole> roles= roleService.getByparamsList(parames);
		
		ExcelRole excelRole = new ExcelRole();
		
		List<ExcelRole> excelRoles = excelRole.build(roles);
		
		
		
		return new ExcelView("角色.xls", "角色", new String[]{"roleName","description","isSystem","creater","updater","createDate","updateDate"},
				new String[]{""
						+ "角色","描述","是否内置","创建者","修改者","创建时间","修改时间"},   new Integer[]{5000,10000,5000,5000,5000,5000,5000}, null, excelRoles, null);
		
		
	}
	
	

}
