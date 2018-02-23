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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.meikai.pageHleper.EntityPage;
import com.meikai.shop.entity.TSystemManager;
import com.meikai.shop.entity.TSystemManagerRole;
import com.meikai.shop.entity.TSystemRole;
import com.meikai.shop.exportExcel.ExcelManagerRole;
import com.meikai.shop.service.ManagerRoleService;
import com.meikai.shop.service.ManagerService;
import com.meikai.shop.service.RoleService;
import com.meikai.util.ExcelView;
import com.meikai.util.ParameterUtils;

/**
 * @author meikai
 * @version 2017年10月11日 下 午 23:34:21
 * 管理员
 */

@Controller("managerRoleController")
@RequestMapping("/admin/authority/managerRole/")
public class ManagerRoleController {
	
	@Resource
	private ManagerRoleService managerRoleService;
	
	
	@Resource
	private RoleService roleService ;
	
	@Resource
	private ManagerService managerService;
	
	/**
	 * 分配列表
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
		
		
		/**
		 * 分页获取数据
		 */
		Map<String, Object> parames = ParameterUtils.getParametersMap(request);
		
		EntityPage<TSystemManagerRole> pageInfo= managerRoleService.getByParamesAndPage(parames, currentPage, pageSize);
		
		request.setAttribute("pageInfo", pageInfo);
		
		
		/**
		 * 传回表格参数
		 */
		request.setAttribute("parames", parames);
		
		
		/**
		 * 要分配的角色，select下拉框选项
		 */
		List<TSystemRole> roles = roleService.getAll();
		request.setAttribute("selectRoles", roles);
		
		
		return "all/admin/authority/managerRole/managerRole-list";
		
	}
	
	
	
	/**
	 * 根据管理员名模糊查询该管理员
	 * @param response
	 * @param managerName
	 * @return
	 */
	@RequestMapping(value= "getManagerByName",method =RequestMethod.GET)
	public @ResponseBody  List<TSystemManager> getByName(@RequestParam(value="managerName") String managerName){
		
		List<TSystemManager> Selectmanagers = managerService.getSomeManagersByName(managerName);
		
		if(Selectmanagers == null) {
			return null;
		}else	
		return Selectmanagers;
	}
	
	
	

	/**
	 * 新增管理员
	 * @param request
	 * @param response
	 * @param managerName
	 * @param password
	 * @return
	 */
	@RequestMapping(value="saveAdd",method =RequestMethod.POST)
	public @ResponseBody  boolean saveAdd(HttpServletRequest request,Long managerId,Long roleId){
		
		/**
		 * new一个管理员对象
		 */
		TSystemManagerRole newManagerRole = new TSystemManagerRole();
		
		
		/**
		 * 设置管理员ID
		 */
		newManagerRole.setManagerId(managerId);
		
		
		/**
		 * 设置角色ID
		 */
		newManagerRole.setRoleId(roleId);
			
		
		/**
		 * 设置创建时间
		 */
		 Date createDate = new Date();
		 newManagerRole.setCreateDate(createDate);
		 
		 
		
		 Long reply = managerRoleService.saveAddEntity(newManagerRole);
		 if(reply == 1) {
			 return true;
		 }
		 else return false;
		 
	}
	
	

	
	
	
	/**
	 * 删除管理员
	 * @param id
	 * @return
	 */
	@RequestMapping(value="delete",method=RequestMethod.GET)
	public @ResponseBody String deleteByID(Long id){
		
		TSystemManagerRole managerRole  = managerRoleService.getByID(id);
		
		if(managerRole.getIsSystem() == 2) {
			return "system";
		}
		
		Long reply =managerRoleService.delete(id);
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
		
		List<TSystemManagerRole> managerRoles= managerRoleService.getByparamsList(parames);
		
		ExcelManagerRole excelManagerRole = new ExcelManagerRole();
		
		List<ExcelManagerRole> excelManagerRoles = excelManagerRole.build(managerRoles);
		
		
		
		return new ExcelView("角色分配.xls", "角色分配", new String[]{"managerName","roleName","isSystem","createDate"},
				new String[]{"管理员","角色","是否内置","创建时间"},   new Integer[]{5000,5000,5000,5000}, null, excelManagerRoles, null);
		
		
	}
	
	

}
