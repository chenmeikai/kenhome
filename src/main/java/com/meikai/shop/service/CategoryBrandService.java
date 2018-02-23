/**
 * 
 */
package com.meikai.shop.service;

import java.util.List;


import com.meikai.shop.entity.TShopCategoryBrand;

/**
 * 分类-品牌关联
 * @author meikai
 * @version 2017年10月23日 下午22:14:38
 */
public interface CategoryBrandService extends BaseService<TShopCategoryBrand, Long> {
	
	/**
	 * 根据分类Id获得品牌关联，包含品牌名
	 * @param categoryId
	 * @return
	 */
	List<TShopCategoryBrand> getWithNameByCategoryId(Long categoryId);
	

}
