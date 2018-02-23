/**
 * 
 */
package com.meikai.controller.admin.authority;

import java.util.Date;
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
import com.meikai.shop.entity.TSystemManager;
import com.meikai.shop.exportExcel.ExcelManager;
import com.meikai.shop.service.ManagerRoleService;
import com.meikai.shop.service.ManagerService;
import com.meikai.util.ExcelView;
import com.meikai.util.MD5;
import com.meikai.util.ParameterUtils;

/**
 * @author meikai
 * @version 2017年10月6日 上午10:38:21
 * 管理员
 */

@Controller("managerController")
@RequestMapping("/admin/authority/manager/")
public class ManagerController {
	
	@Resource
	private ManagerService managerService;
	
	@Resource
	private ManagerRoleService managerRoleService;
	
	/**
	 * 管理员中心
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
		
		Map<String, Object> params = ParameterUtils.getParametersMap(request);
		
		EntityPage<TSystemManager> pageInfo= managerService.getByParamesAndPage(params, currentPage, pageSize);
		
		request.setAttribute("pageInfo", pageInfo);
		
		request.setAttribute("params", params);
		
		
		return "all/admin/authority/manager/manager-list";
		
	}
	
	
	/**
	 * 根据ID获得管理员
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value="view",method =RequestMethod.GET)
	@ResponseBody
	public  TSystemManager view(HttpServletRequest request,Long id) {
		
		TSystemManager viewManager = managerService.getRolesAndAclsByID(id);
		
		viewManager.setPassword(null);
			
		return viewManager;
		
	}
	
	

	/**
	 * 根据管理员名判定有无该管理员
	 * @param response
	 * @param managerName
	 * @return
	 */
	@RequestMapping(value="validateName",method =RequestMethod.GET)
	public @ResponseBody  boolean validateName(String managerName){
		
		TSystemManager manager = managerService.getByUniqueName(managerName);
		
		if(manager == null) {
			return true;
		}else	
		return false;
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
	public @ResponseBody  boolean saveAdd(HttpServletRequest request,HttpServletResponse response,String managerName,String password){
		
		/**
		 * new一个管理员对象
		 */
		TSystemManager newManager = new TSystemManager();
		

		/**
		 * 创建时间
		 */
		 Date createDate = new Date();
		
		
		/**
		 * 设置管理员名字
		 */
		 newManager.setManagerName(managerName);
			
		
		/**
		 * 设置管理员创建时间
		 */
		 newManager.setCreateDate(createDate);
		 
		 
		/**
		 * 密码加密	
		 */
		 String secretPassword=MD5.getIntance().start(password);
		 newManager.setPassword(secretPassword);
		
		 Long reply = managerService.saveAddEntity(newManager);
		 if(reply == 1) {
			 return true;
		 }
		 else return false;
		 
	}
	
	/**
	 * 编辑管理员
	 * @param request
	 * @param response
	 * @param id
	 * @param isEnable
	 * @return
	 */
	@RequestMapping(value="saveEdit",method = RequestMethod.POST)
	public @ResponseBody  boolean saveEdit(HttpServletRequest request,HttpServletResponse response,Long id,Integer isEnable){
		
		/**
		 * 要修改的管理员对象
		 */
		TSystemManager updateManager = managerService.getByID(id);
		
		if(updateManager.getIsForver()==2)
			return false;


		/**
		 * 创建时间
		 */
		 Date updateDate = new Date();
		 
		
		
		/**
		 * 设置更新时间
		 */
		 updateManager.setUpdateDate(updateDate);
			
		
		/**
		 * 设置启用状态
		 */
		 updateManager.setIsEnable(isEnable);
		 
		 
		 
		 /**
		  * 修改管理员
		  */
		 Long reply = managerService.updateEntity(updateManager);
		 
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
	@RequestMapping(value="delete",method= RequestMethod.GET)
	public @ResponseBody String deleteByID(Long id){
		
		TSystemManager manager = managerService.getByID(id);
		
		if(manager.getIsForver() == 2) {
			return "system";
		}
		
		
		/**
		 * 根据管理员ID删除与角色的关联
		 */
		managerRoleService.deleteByManagerID(id);
		
		
		
		/**
		 * 删除管理员
		 */
		Long reply =managerService.delete(id);
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
	@RequestMapping(value="export",method = RequestMethod.GET)
	public ExcelView export(HttpServletRequest request) {
		
		
		
		Map<String, Object> parames = ParameterUtils.getParametersMap(request);
		
		List<TSystemManager> managers= managerService.getByparamsList(parames);
		
		ExcelManager excelManager = new ExcelManager();
		
		List<ExcelManager> excelManagers = excelManager.build(managers);
		
		
		
		return new ExcelView("管理员.xls", "管理员", new String[]{"managerName","nickname","email","loginIp","isEnable","isLocked","isForver","loginTime","createDate","updateDate"},
				new String[]{"名字","昵称","邮箱","登录IP","启用","锁定","内置","登录时间","创建时间","更新时间"},   new Integer[]{5000,5000,5000,5000,5000,5000,5000,5000,5000,5000}, null, excelManagers, null);
				
	}
	
	

}
