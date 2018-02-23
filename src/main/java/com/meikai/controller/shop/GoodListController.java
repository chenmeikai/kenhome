/**
 * 
 */
package com.meikai.controller.shop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.meikai.pageHleper.EntityPage;
import com.meikai.shop.entity.TShopBrand;
import com.meikai.shop.entity.TShopCategory;
import com.meikai.shop.entity.TShopCategoryBrand;
import com.meikai.shop.entity.TShopSku;
import com.meikai.shop.entity.TShopSkuPicture;
import com.meikai.shop.entity.TShopSpu;
import com.meikai.shop.entity.TShopSpuPicture;
import com.meikai.shop.service.BrandService;
import com.meikai.shop.service.CategoryBrandService;
import com.meikai.shop.service.CategoryService;
import com.meikai.shop.service.SkuPictureService;
import com.meikai.shop.service.SkuService;
import com.meikai.shop.service.SpuPictureService;
import com.meikai.shop.service.SpuService;
import com.meikai.util.ParameterUtils;

/**
 * 商品管理器
 * @author meikai
 * @version 2017年11月7日 下午3:09:00
 */
@Controller("goodListController")
@RequestMapping("/shop/good/")
public class GoodListController {
	
	@Resource
	private CategoryService categoryService;
	
    @Resource
    private SkuService skuService;
    @Resource
    private SkuPictureService skuPictureService;
    @Resource
    private SpuService spuService;
    @Resource
    private SpuPictureService spuPictureService;
    @Resource
    private CategoryBrandService categoryBrandService;
   
    
    /**
     * 三级分类
     * @param request
     * @param categoryId
     * @return
     */
	@RequestMapping(value="listThird",method=RequestMethod.GET)
	public String list(HttpServletRequest request,Long categoryId,Long brandId, Long[] optionIds,Long[] option2Ids,
			BigDecimal startSalePrice,BigDecimal endSalePrice,Integer sort, Integer currentPage) {
		
		/**
		 * 分类是否有父级和子级
		 */
		boolean haveParent =false;		
		boolean haveSon =false;
		
		
		/**
		 * 将导购属性数组转化为List
		 */
		List<Long> opIds =new ArrayList<Long>();
		if(optionIds !=null && optionIds.length>0) {
			for(Long optionId :optionIds) {
				opIds.add(optionId);
			}
		}
		
		/**
		 * 将价格关键属性数组转化为List
		 */
		List<Long> op2Ids =new ArrayList<Long>();
		if(option2Ids !=null && option2Ids.length>0) {
			for(Long option2Id :option2Ids) {
				op2Ids.add(option2Id);
			}
		}
		
		
		/**
		 * 分类查看
		 */
		List<TShopCategory> rootCategorys = categoryService.getByparamList("parentId", 0);
		request.setAttribute("rootCategorys", rootCategorys);
		
		/**
		 * 分类品牌
		 */
		List<TShopCategoryBrand> viewCategoryBrands =categoryBrandService.getWithNameByCategoryId(categoryId);
		request.setAttribute("viewCategoryBrands", viewCategoryBrands);
		
		/**
		 * 分类包含其父祖分类
		 */
		TShopCategory targetCategory =categoryService.getWithParentById(categoryId);
		//判断有无父分类
		if(targetCategory.getParentCategory() !=null) {
			haveParent =true;
		}
				
		/**
		 * 其子分类
		 */  
		TShopCategory haveSonCategory =categoryService.getBaseWithChildrenCategorys(categoryId);
		if(haveSonCategory !=null) {
			List<TShopCategory> sonCategorys =haveSonCategory.getChildrenCategorys();
			//将子分类装进目标分类
			targetCategory.setChildrenCategorys(sonCategorys);
			
			//判断有无子分类
			if(!sonCategorys.isEmpty()) {
				haveSon =true;
			}
		}
		
		request.setAttribute("targetCategory", targetCategory);
		
		/**
		 * 分类属性包含属性用途类型及属性集合
		 */
		TShopCategory viewCategory =categoryService.getBaseWithAttrsWithOptions(categoryId);
		request.setAttribute("viewCategory", viewCategory);
		
		/**
		 * 分类商品集
		 */
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("categoryId", categoryId);
		params.put("brandId", brandId);
		params.put("optionIds", opIds);
		params.put("option2Ids", op2Ids);
		params.put("startSalePrice", startSalePrice);
		params.put("endSalePrice", endSalePrice);
		params.put("sort", sort);
		
		//要跳转的当前页
		if(currentPage==null ||currentPage<=0) {
			currentPage =1;
		}
		//面值 
		int pageSize =20;
		
		//建立包含分页信息集合
		EntityPage<TShopSku> pageInfo =new EntityPage<TShopSku>();
		
		/**
		 * 判断分类Id属于哪个层级，根据不同层级做相关的查询
		 */		
				
		/**
		 * 如果是第三级(末级)
		 */
		if(haveSon ==false) {
		   pageInfo =skuService.getByThird(params,currentPage, pageSize);
		}
		
		
		/**
		 * 如果是第二级（中间级）
		 */
		if(haveSon ==true && haveParent ==true) {
			   pageInfo =skuService.getBySecond(params,currentPage, pageSize);
		}
		
		/**
		 * 如果是第一级（首级）
		 */
		if(haveSon ==true && haveParent ==false) {
			   pageInfo =skuService.getByFirst(params,currentPage, pageSize);
		}
		
		
		
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("params", params);		
		return "/all/shop/good/good-list";
	}

}
