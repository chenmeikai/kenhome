package com.meikai.shop.dao;


import java.util.List;

import com.meikai.shop.entity.TShopCategoryAttribute;

/**
 * 分类-属性关联
 * @author meikai
 * @version 2017年10月18日 下午6:23:05
 */
public interface TShopCategoryAttributeDao extends BaseDao <TShopCategoryAttribute,Long> {
	
	/**
	 * 根据分类Id获得属性关联
	 */
    List<TShopCategoryAttribute> getByCategoryId(Long categoryId);
	
	
	/**
	 * 根据属性Id获得分类关联
	 */
    List<TShopCategoryAttribute> getByAttributeId(Long attributeId);
}