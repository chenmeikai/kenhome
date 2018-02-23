/**
 * 
 */
package com.meikai.controller.admin.good;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.meikai.shop.entity.TShopAttribute;
import com.meikai.shop.entity.TShopAttributeOption;
import com.meikai.shop.entity.TShopBrand;
import com.meikai.shop.entity.TShopCategory;
import com.meikai.shop.entity.TShopCategoryAttribute;
import com.meikai.shop.entity.TShopCategoryBrand;
import com.meikai.shop.entity.TShopSkuAttributeOption;
import com.meikai.shop.entity.TSystemManager;
import com.meikai.shop.service.AttributeService;
import com.meikai.shop.service.BrandService;
import com.meikai.shop.service.CategoryAttributeService;
import com.meikai.shop.service.CategoryBrandService;
import com.meikai.shop.service.CategoryService;

/**
 * @author meikai
 * @version 2017年10月17日 上午17:17:19
 * 分类管理
 */

@Controller("categoryController")
@RequestMapping("/admin/spu/category/")
public class CategoryController {
	
	@Resource
	private CategoryService categoryService;
	
	@Resource
	private CategoryAttributeService categoryAttributeService;
	
	@Resource
	private AttributeService attributeService;
	
	@Resource
	private CategoryBrandService categoryBrandService;
	
	@Resource
	private BrandService brandService;
	
	/**
	 * 分类管理
	 * @param request
	 * @return
	 */
	@RequestMapping(value="main",method =RequestMethod.GET)
	public String main(HttpServletRequest request) {
		
		
        List<TShopCategory> categorys =categoryService.getRootWithChildrenCategorys();
		
        request.setAttribute("categorys", categorys);
        
		return "all/admin/spu/category/category-list";
		
	}
	
	
	/**
	 * 查看要编辑的分类
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value="viewEditCatagory",method =RequestMethod.GET)
	public  String viewEditCatagory(HttpServletRequest request,Long id) {
		
		/**
		 * 分类
		 */
		TShopCategory btcCategorys =categoryService.getBaseWithChildrenCategorys(id);
		
		/**
		 * 关联的属性
		 */
		List<TShopCategoryAttribute> editCategoryAttrs =categoryAttributeService.getByCategoryId(id); 
		
		/**
		 * 属性集合
		 */
		List<TShopAttribute> attributes = attributeService.getAll();
		
		/**
		 * 关联品牌
		 */
		List<TShopCategoryBrand> categoryBrands = categoryBrandService.getWithNameByCategoryId(id);	
		
		/**
		 * 品牌集合
		 */
		List<TShopBrand> brands = brandService.getAll();
		
				
		request.setAttribute("editCategoryAttrs", editCategoryAttrs);
		
		request.setAttribute("btcCategorys", btcCategorys);
		
		request.setAttribute("attributes", attributes);
		
		request.setAttribute("categoryBrands", categoryBrands);
		
		request.setAttribute("brands", brands);
			
		return "all/admin/spu/category/category-edit";
		
	}
	

	/**
	 * 新增子分类
	 * @param request
	 * @param response
	 * @param parentId
	 * @param categoryName
	 * @param context
	 * @return
	 */
	@RequestMapping(value="saveAdd",method =RequestMethod.POST)
	public @ResponseBody  boolean saveAdd(HttpServletRequest request,HttpServletResponse response,Long parentId,String categoryName,String context){
		
		/**
		 * new一个分类对象
		 */
		TShopCategory newCategory = new TShopCategory();
		

		/**
		 * 设置分类名字
		 */
		 newCategory.setCategoryName(categoryName);
			
		
		 /**
		  * 设置分类描述
		  */
		 newCategory.setContext(context);
		 
		 
		 /**
		  * 设置创建人
		  */
		 TSystemManager creator = (TSystemManager) request.getAttribute("manager");
		 if (creator != null) newCategory.setCreater(creator.getManagerName());
			 
		 
		/**
		 * 设置分类创建时间
		 */
		 Date createDate = new Date();
		 newCategory.setCreateDate(createDate);
		 
		 
		 /**
		  * 设置父类
		  */
		 newCategory.setParentId(parentId);	 
		 
		 
		 Long reply = categoryService.saveAddEntity(newCategory);
		 if(reply == 1) {
			 
			 return true;
		 }
		 else return false;
		 
	}
	
	
	/**
	 * 修改分类
	 * @param request
	 * @param response
	 * @param id
	 * @param categoryName
	 * @param context
	 * @return
	 */
	@RequestMapping(value="saveUpdate",method =RequestMethod.POST)
	public @ResponseBody  boolean saveEdit(HttpServletRequest request,HttpServletResponse response,Long id,String categoryName,String context){
		
		/**
		 * 要修改的分类对象
		 */
		TShopCategory updateCategory = categoryService.getByID(id);

		/**
		 * 创建时间
		 */
		 Date updateDate = new Date();
		
		
		/**
		 * 设置更新时间
		 */
		 updateCategory.setUpdateDate(updateDate);
			
		
		/**
		 * 设置更新人
		 */
		 TSystemManager updater = (TSystemManager) request.getAttribute("manager");
		 if (updater != null) updateCategory.setUpdater(updater.getManagerName());
		 
		 
		 /**
		  * 设置名称
		  */
		 updateCategory.setCategoryName(categoryName);
		 
		 /**
		  * 设置描述
		  */
		 updateCategory.setContext(context);
		 
		 
		 /**
		  * 更新分类
		  */
		 Long reply = categoryService.updateEntity(updateCategory);
		 
		 if(reply == 1) {
			 return true;
		 }
		 else return false;
		 
	}
	
		
	
	/**
	 * 删除分类，删除某分类时，需校验该分类及其各级子分类下是否有关联商品，若有，则不可删除；若无，则可以删除。
	 * @param id
	 * @return
	 */
	@RequestMapping(value="delete",method=RequestMethod.GET)
	public @ResponseBody String deleteByID(Long id){
		
		/**
		 * 判定有无子分类，有则不删除
		 */
		TShopCategory deleteCategory = categoryService.getBaseWithChildrenCategorys(id);
		if(deleteCategory.getChildrenCategorys().size() > 0)
			return "childCategory";
		
		/**
		 * 判定有无属性关联，有则不删除
		 */
		List<TShopCategoryAttribute> categoryAttributes = categoryAttributeService.getByCategoryId(id);
		if(!categoryAttributes.isEmpty())
			return "haveAttributes";
		
		/**
		 * 删除分类
		 */
		Long reply =categoryService.delete(id);
		if(reply ==1) {
			return "true";
		}
		else return "false";
		
	}
	
	
	/**
	 * 添加属性关联
	 * @param request
	 * @param id
	 * @param attributeIds
	 * @return
	 */
	@RequestMapping(value="saveAddcategoryAttr",method =RequestMethod.POST)
	public @ResponseBody  boolean saveAddcategoryAttr(HttpServletRequest request,Long id,Long[] attributeIds){

		
		/**
		 * 判定该分类是否属性关联为零，判定添加的属性关联是否重复
		 */
		List<TShopCategoryAttribute> existCategoryAttrs =categoryAttributeService.getByCategoryId(id);
		//如果分类已经存在属性，判定添加的属性是否重复，再添加属性
		if(!existCategoryAttrs.isEmpty()) {			
			HashSet<Long> existAttributeIds = new HashSet<Long>();
			for(TShopCategoryAttribute existCategoryAttr :existCategoryAttrs ) {
				Long existAttributeId = existCategoryAttr.getAttributeId();
				existAttributeIds.add(existAttributeId);
			}
			for(Long attributeId :attributeIds) {
				if(!existAttributeIds.contains(attributeId)) {
					TShopCategoryAttribute newCategoryAttr = new TShopCategoryAttribute();
					newCategoryAttr.setCreateDate(new Date());
					newCategoryAttr.setCategoryId(id);
					newCategoryAttr.setAttributeId(attributeId);
					Long reply =categoryAttributeService.saveAddEntity(newCategoryAttr);
					if(reply <1) return false ;
				}
			}			
		}
		else
		//如分类未有属性
		for(Long attributeId :attributeIds) {			
				TShopCategoryAttribute newCategoryAttr = new TShopCategoryAttribute();
				newCategoryAttr.setCreateDate(new Date());
				newCategoryAttr.setCategoryId(id);
				newCategoryAttr.setAttributeId(attributeId);
				Long reply =categoryAttributeService.saveAddEntity(newCategoryAttr);
				if(reply <1) return false ;
		}
		return true;		 
	}
	
	
	/**
	 * 修改关联属性 
	 * @param request
	 * @param id
	 * @param sort
	 * @return
	 */
	@RequestMapping(value= "saveUpdatecategoryAttr",method =RequestMethod.POST)
	public @ResponseBody  boolean saveUpdatecategoryAttr(HttpServletRequest request,Long id,Integer baseType,Integer priceType,Integer guideType){
		
		/**
		 * 要修改的属性值对象
		 */
		TShopCategoryAttribute updateCategoryAttr = categoryAttributeService.getByID(id);
				 
		 
			 
		 /**
		  * 设置属性关联为基本属性
		  */
		if(baseType ==null) baseType =1 ;
		updateCategoryAttr.setBaseType(baseType);
		
		 /**
		  * 设置属性关联为价格属性
		  */
		if(priceType ==null) priceType =1 ;
		updateCategoryAttr.setPriceType(priceType);
		
		 /**
		  * 设置属性关联为导购属性
		  */
		if(guideType ==null) guideType =1 ;
		updateCategoryAttr.setGuideType(guideType);
		
		
	    /**
	     * 设置更新时间	
	     */
		updateCategoryAttr.setUpdateDate(new Date()); 
		
		
		 /**
		  * 修改属性
		  */
		 Long reply = categoryAttributeService.updateEntity(updateCategoryAttr);
		 
		 
		 if(reply == 1) {
			 return true;
		 }
		 else return false;
		 
	 }
	
	
	
	/**
	 * 去除属性关联
	 * @param id
	 * @return
	 */
	@RequestMapping(value="deletecategoryAttr",method= {RequestMethod.GET})
	public @ResponseBody String remove(Long id){
			
			
		/**
		 * 删除属性值
		 */
		Long reply =categoryAttributeService.delete(id);
		if(reply ==1) {
			return "true";
		}
		else return "false";
		
	}
	
	
	
	
	/**
	 *  添加品牌关联
	 * @param request
	 * @param id
	 * @param brandIds
	 * @return
	 */
	@RequestMapping(value="saveAddcategoryBrand",method =RequestMethod.POST)
	public @ResponseBody  boolean saveAddcategoryBrand(HttpServletRequest request,Long id,Long[] brandIds){

		
		/**
		 * 判定该分类是否品牌关联为零，判定添加的品牌关联是否重复
		 */
		List<TShopCategoryBrand> existCategoryBrands =categoryBrandService.getWithNameByCategoryId(id);
		//如果分类已经存在品牌，判定添加的品牌是否重复，再添加品牌
		if(!existCategoryBrands.isEmpty()) {			
			HashSet<Long> existBrandIds = new HashSet<Long>();
			for(TShopCategoryBrand existCategoryBrand :existCategoryBrands ) {
				Long existBrandId = existCategoryBrand.getBrandId();
				existBrandIds.add(existBrandId);
			}
			for(Long brandId :brandIds) {
				if(!existBrandIds.contains(brandId)) {
					TShopCategoryBrand newCategoryBrand = new TShopCategoryBrand();
					newCategoryBrand.setCategoryId(id);
					newCategoryBrand.setBrandId(brandId);;
					Long reply =categoryBrandService.saveAddEntity(newCategoryBrand);
					if(reply <1) return false ;
				}
			}			
		}
		else
		//如分类未有品牌
		for(Long brandId :brandIds) {			
				TShopCategoryBrand newCategoryBrand = new TShopCategoryBrand();
				newCategoryBrand.setCategoryId(id);
				newCategoryBrand.setBrandId(brandId);
				Long reply =categoryBrandService.saveAddEntity(newCategoryBrand);
				if(reply <1) return false ;
		}
		return true;		 
	}
	
	
	
	
	/**
	 * 修改关联品牌
	 * @param request
	 * @param id
	 * @param sort
	 * @return
	 */
	@RequestMapping(value= "saveUpdateCategoryBrand",method =RequestMethod.POST)
	public @ResponseBody  boolean saveUpdateCategoryBrand(HttpServletRequest request,Long id,Integer sort){
		
		/**
		 * 要修改的品牌对象
		 */
		TShopCategoryBrand updateCategoryBrand = categoryBrandService.getByID(id);
		/**
		 * 设置序号		 
		 */
		updateCategoryBrand.setSort(sort);
				
		 /**
		  * 修改品牌
		  */
		 Long reply = categoryBrandService.updateEntity(updateCategoryBrand);
		 
		 
		 if(reply == 1) {
			 return true;
		 }
		 else return false;
		 
	 }
	

	/**
	 * 去除品牌关联
	 * @param id
	 * @return
	 */
	@RequestMapping(value="deletecategoryBrand",method= {RequestMethod.GET})
	public @ResponseBody String deletecategoryBrand(Long id){
			
			
		/**
		 * 删除品牌
		 */
		Long reply =categoryBrandService.delete(id);
		if(reply ==1) {
			return "true";
		}
		else return "false";
		
	}
	

}
