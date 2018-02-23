/**
 * 
 */
package com.meikai.shop.service;

import java.util.List;

import com.meikai.shop.entity.TShopCategory;

/**
 * 分类
 * @author meikai
 * @version 2017年9月21日 下午11:16:38
 */
public interface CategoryService extends BaseService<TShopCategory, Long> {
	
	
	/**
	 * 获得根分类及其子孙分类
	 * @return
	 */
	List<TShopCategory> getRootWithChildrenCategorys();
	
	
	/**
	 * 获得子分类及其子孙分类
	 * @return
	 */
	List<TShopCategory> getChildrenCategorys(Long parentId);
	
	/**
	 * 获得分类及其子分类
	 * @param id
	 * @return
	 */
	TShopCategory getBaseWithChildrenCategorys(Long id);
	
	/**
	 * 获得分类，包含属性集合，属性用途类型，属性包含选项集合
	 * @param id
	 * @return 获得分类，包含属性集合，属性包含选项集合 
	 */
	TShopCategory getBaseWithAttrsWithOptions(Long id);
	
	/**
	 * 根据ID获取分类ID，名字，父分类ID及父分类对象
	 * 
	 */
	TShopCategory getWithParentById(Long id);

}
