/**
 * 
 */
package com.meikai.controller.shop;

import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.meikai.activemq.QueueSender;
import com.meikai.redisCache.IRedisProxy;
import com.meikai.shop.entity.TShopBrand;
import com.meikai.shop.entity.TShopCategory;
import com.meikai.shop.entity.TShopCategoryBrand;
import com.meikai.shop.entity.TShopSku;
import com.meikai.shop.service.BrandService;
import com.meikai.shop.service.CategoryBrandService;
import com.meikai.shop.service.CategoryService;
import com.meikai.shop.service.SkuService;

/**
 * 商城首页
 * @author meikai
 * @version 2017年11月3日 下午2:29:38
 */
@Controller("shopIndexController")
@RequestMapping("/shop/")
public class IndexController {
	
	@Resource
	private CategoryService categoryService;
	@Resource
	private BrandService brandService;
	@Resource
	private CategoryBrandService categoryBrandService;
	@Resource
	private SkuService skuService;
	@Resource
	private IRedisProxy iredisProxy;
	@Resource
	private  QueueSender qs ;
	
	
	/**
	 * 商城首页
	 */
	@RequestMapping(value="index",method=RequestMethod.GET)
    public String index(HttpServletRequest request) {
		
		
		/**
		 * 分类查看
		 */
		List<TShopCategory> rootCategorys = categoryService.getByparamList("parentId", 0);
		request.setAttribute("rootCategorys", rootCategorys);
		
		/**
		 * 品牌查看
		 */
		Long branNum = (long) 30;
		List<TShopBrand> brands =brandService.getByRandom(branNum);
		request.setAttribute("brands", brands);
		
		/**
		 * 服饰
		 */
		Long skuNum=(long)18;
		Long clothsrootCategoryId =(long) 1;
		List<TShopSku> clothsSkus = skuService.getByrootcategoryIdRandom(clothsrootCategoryId, skuNum);
		request.setAttribute("clothsSkus", clothsSkus);
		
		/**
		 * 手机-家电
		 */
		Long phoneNum=(long)18;
		Long phonerootCategoryId =(long) 202;
		List<TShopSku> phoneSkus = skuService.getByrootcategoryIdRandom(phonerootCategoryId, phoneNum);
		request.setAttribute("phoneSkus", phoneSkus);
		
		return "/all/shop/index/index";
	}
	
	
	
	/**
	 * 分类详情
	 */
	@RequestMapping(value="categoryView",method=RequestMethod.GET)
    public String categoryView(HttpServletRequest request,Long rootCategoryId) {
		
	   List<TShopCategory> categorys = categoryService.getChildrenCategorys(rootCategoryId);
	   	   
	   request.setAttribute("categorys", categorys);
	   
	    /**
		 * 随机取某分类，获得其品牌集合
		 */
	    
	    int max =categorys.size();
	   
	    Random random = new Random();
        int middleNum = random.nextInt(max);
        
        TShopCategory ChildCategory = categorys.get(middleNum);
        
        max=ChildCategory.getChildrenCategorys().size();
      
        int targetNum =random.nextInt(max);
        Long targetId =ChildCategory.getChildrenCategorys().get(targetNum).getId();
        
	    List<TShopCategoryBrand>  categoryBrands = categoryBrandService.getWithNameByCategoryId(targetId);       
	    request.setAttribute("categoryBrands", categoryBrands);
		
		return "/all/shop/index/category-view";
	}
}
