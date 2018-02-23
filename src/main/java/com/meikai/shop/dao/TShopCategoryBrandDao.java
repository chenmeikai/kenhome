package com.meikai.shop.dao;


import java.util.List;

import com.meikai.shop.entity.TShopCategoryBrand;

/**
 * 商品分类
 * @author Administrator
 * @version 2017年9月21日 上午9:53:46
 */
public interface TShopCategoryBrandDao extends BaseDao<TShopCategoryBrand,Long> {
	
	/**
	 * 根据分类Id获得品牌关联，内含品牌名
	 * @param categoryId
	 * @return
	 */
	public List<TShopCategoryBrand> getWithNameByCategoryId(Long categoryId);
	
	
    
}