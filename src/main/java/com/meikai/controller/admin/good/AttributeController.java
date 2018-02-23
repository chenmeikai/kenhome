/**
 * 
 */
package com.meikai.controller.admin.good;

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
import com.meikai.shop.entity.TShopAttribute;
import com.meikai.shop.entity.TShopAttributeOption;
import com.meikai.shop.entity.TShopSkuAttributeOption;
import com.meikai.shop.entity.TSystemManager;
import com.meikai.shop.service.AttributeOptionService;
import com.meikai.shop.service.AttributeService;
import com.meikai.shop.service.ManagerService;
import com.meikai.shop.service.SkuAttributeOptionService;
import com.meikai.util.ParameterUtils;

/**
 * @author meikai
 * @version 2017年10月17日 下午午20:23:21
 * 管理员
 */

@Controller("attributeController")
@RequestMapping("/admin/spu/attribute/")
public class AttributeController {
	
	@Resource
	private ManagerService managerService;
	
	@Resource
	private AttributeService attributeService;
	
	@Resource
	private AttributeOptionService attributeOptionService;
	
	@Resource
	private SkuAttributeOptionService skuAttrOptionService;
	
	/**
	 * 属性管理
	 * @param request
	 * @param currentPage
	 * @return
	 */
	@RequestMapping(value= "main",method = RequestMethod.GET)
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
		
		EntityPage<TShopAttribute> pageInfo= attributeService.getByParamesAndPage(parames, currentPage, pageSize);
		
		request.setAttribute("pageInfo", pageInfo);
		
		request.setAttribute("parames", parames);
		
		
		return "all/admin/spu/attribute/attribute-list";
		
	}
	
	

	/**
	 * 根据属性名判定有无该属性
	 * 用于新增属性
	 * @param attributeName
	 * @return
	 */
	@RequestMapping(value= "validateAttributeName",method =RequestMethod.GET)
	public @ResponseBody  boolean validateAttributeName(String attributeName){
		
		TShopAttribute attribute = attributeService.getByUniqueName(attributeName);
		
		if(attribute == null) {
			return true;
		}else	
		return false;
	}
	
	
	/**
	 * 根据属性名判定有无该属性
	 * 用于修改属性
	 * @param attributeName
	 * @return
	 */
	@RequestMapping(value= "validateAttributeName2",method =RequestMethod.GET)
	public @ResponseBody  boolean validateAttributeName2(Long id,String attributeName){
		
		TShopAttribute attribute = attributeService.getByUniqueName(attributeName);
		if(attribute == null) {
			return true;
		}
		else if(attribute.getId()==id) {
			return true;
		}
		else
		return false;
	}
	
		
	
	/**
	 * 新增属性
	 * @param request
	 * @param response
	 * @param attributeName
	 * @param attributeDescription
	 * @return
	 */
	@RequestMapping(value= "saveAdd",method =RequestMethod.POST)
	public @ResponseBody  boolean saveAdd(HttpServletRequest request,HttpServletResponse response,String attributeName,String attributeDescription){
		
		/**
		 * new一个属性对象
		 */
		TShopAttribute newAttribute  = new TShopAttribute();
		
        
		/**
		 * 设置属性名
		 */
		newAttribute.setAttributeName(attributeName);
		
		/**
		  * 设置创建人
		  */
		 TSystemManager creator = (TSystemManager) request.getAttribute("manager");
		 if (creator != null) newAttribute.setCreater(creator.getManagerName());
			
		
		/**
		 * 设置管理员创建时间
		 */
		 Date createDate = new Date();
		 newAttribute.setCreateDate(createDate);
		 
		 
		 /**
		  * 设置属性描述
		  */
		 newAttribute.setAttributeDescription(attributeDescription);
		
		 
		 
		 Long reply = attributeService.saveAddEntity(newAttribute);
		 if(reply == 1) {
			 
			 /**
			  * 设置属性编码与序号
			  */
			 TShopAttribute updateAttribute =attributeService.getByparamList("attributeName", attributeName).get(0);
			 Long id = updateAttribute.getId();
			 updateAttribute.setAttributeCode(String.valueOf(id+10000));
			 updateAttribute.setAttributeSort(id.intValue());
			 attributeService.updateEntity(updateAttribute);
			 return true;
		 }
		 else return false;
		 
	}
	
	

	/**
	 * 删除属性
	 * @param id
	 * @return
	 */
	@RequestMapping(value="deleteAttribute",method= RequestMethod.GET)
	public @ResponseBody String delete(Long id){
		
		List<TShopAttributeOption> options = attributeOptionService.getByAttributeId(id);
		
		if(options.size() != 0) return "options";
			
			
		/**
		 * 删除属性
		 */
		Long reply =attributeService.delete(id);
		if(reply ==1) {
			return "true";
		}
		else return "false";
		
	}
	
	/**
	 * 编辑属性页面
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value= "editAttribute",method=RequestMethod.GET)
	public String  viewEdit(HttpServletRequest request,Long id) {
		
		TShopAttribute editAttribute = attributeService.getWithOptionsById(id);
		
		request.setAttribute("editAttribute", editAttribute);
		
		return "all/admin/spu/attribute/attribute-edit";
	}
	
	
	
	
	/**
	 * 修改属性
	 * @param request
	 * @param response
	 * @param id
	 * @param attributeName
	 * @param attributeDescription
	 * @param attributeSort
	 * @return
	 */
	@RequestMapping(value= "saveUpdate",method =RequestMethod.POST)
	public @ResponseBody  boolean saveEdit(HttpServletRequest request,HttpServletResponse response,Long id,String attributeName,String attributeDescription,Integer attributeSort){
		
		/**
		 * 要修改的属性对象
		 */
		TShopAttribute updateAttribute = attributeService.getByID(id);
		
		
		/**
		 * 设置更新时间
		 */
		 Date updateDate = new Date();
		 updateAttribute.setUpdateDate(updateDate);
			
		
		/**
		 * 设置修改人
		 */	 
		 TSystemManager updater = (TSystemManager) request.getAttribute("manager");
		 if (updater != null) updateAttribute.setUpdater(updater.getManagerName());
		 
		 
		 /**
		  * 设置属性名
		  */
		 updateAttribute.setAttributeName(attributeName);
		 
		 /**
		  * 设置属性描述
		  */
		 updateAttribute.setAttributeDescription(attributeDescription);
		 
		 
		 /**
		  * 设置属性序号
		  */
		 updateAttribute.setAttributeSort(attributeSort);
		 
		 
		 /**
		  * 修改属性
		  */
		 Long reply = attributeService.updateEntity(updateAttribute);
		 
		 
		 if(reply == 1) {
			 return true;
		 }
		 else return false;
		 
	}
	
	
	
    /**
     * 新增属性值
     * @param request
     * @param optionName
     * @param attributeId       
     * @param optionSort
     * @return
     */
	@RequestMapping(value="saveAddOption",method = RequestMethod.POST)
	public @ResponseBody  boolean saveAddOption(HttpServletRequest request,Long attributeId,String optionName,Integer optionSort){
		
		/**
		 * new一个属性值对象
		 */
		TShopAttributeOption newOption  = new TShopAttributeOption();
		
        
		/**
		 * 设置属性名
		 */
		newOption.setOptionName(optionName);
		
	    
		/**
		 * 设置序号
		 */
		newOption.setOptionSort(optionSort);
		
		
		/**
		 * 设置关联属性Id
		 */
		 newOption.setAttributeId(attributeId);
		
		/**
		  * 设置创建人
		  */
		 TSystemManager creator = (TSystemManager) request.getAttribute("manager");
		 if (creator != null) newOption.setCreater(creator.getManagerName());
			
		
		/**
		 * 设置创建时间
		 */
		 Date createDate = new Date();
		 newOption.setCreateDate(createDate);
		 
		 /**
		  * 新增属性值		 
		  */
		 Long reply = attributeOptionService.saveAddEntity(newOption);
		 if(reply == 1) {

			 return true;
		 }
		 else return false;
		 
	}
	
	
	
	/**
	 * 根据属性值判定有无该属性值
	 * @param attributeName
	 * @return
	 */
	@RequestMapping(value= "validateOptionName",method = RequestMethod.GET)
	public @ResponseBody  boolean validateOptionName(Long attributeId,String optionName){
		
		TShopAttributeOption option = attributeOptionService.getByUniqueName(optionName);
		if(option == null) {
			return true;
		}
		else if(option.getAttributeId() != attributeId) {
			return true ;
		}
		else
		return false;
	}
	
	
	/**
	 * 修改属性值
	 * 
	 */
	@RequestMapping(value= "saveUpdateOption",method =RequestMethod.POST)
	public @ResponseBody  boolean saveUpdateOption(HttpServletRequest request,HttpServletResponse response,Long id,String optionName,Integer optionSort){
		
		/**
		 * 要修改的属性值对象
		 */
		TShopAttributeOption updateOption = attributeOptionService.getByID(id);
				 
		 
		 /**
		  * 设置属性名
		  */
		updateOption.setOptionName(optionName);
		 
			 
		 /**
		  * 设置属性序号
		  */
		updateOption.setOptionSort(optionSort);
		 
		 
		 /**
		  * 修改属性
		  */
		 Long reply = attributeOptionService.updateEntity(updateOption);
		 
		 
		 if(reply == 1) {
			 return true;
		 }
		 else return false;
		 
	}
	
	
	
	
	
	/**
	 * 删除属性值
	 * @param id
	 * @return
	 */
	@RequestMapping(value="deleteOption",method= {RequestMethod.GET})
	public @ResponseBody String remove(Long id){
		
		/**
		 * 判定是否已有单品关联，有则不可删除
		 */
		List<TShopSkuAttributeOption> skuOptions = skuAttrOptionService.getByOptionId(id);	
		if(skuOptions.size() != 0) return "attributeOption";
			
			
		/**
		 * 删除属性值
		 */
		Long reply =attributeOptionService.delete(id);
		if(reply ==1) {
			return "true";
		}
		else return "false";
		
	}
	
	
	

	

}
