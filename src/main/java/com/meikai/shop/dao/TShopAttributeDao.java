package com.meikai.shop.dao;

import java.util.List;

import com.meikai.shop.entity.TShopAttribute;

/**
 * 商品属性
 * @author Administrator
 * @version 2017年9月21日 上午9:49:52
 */

public interface TShopAttributeDao extends BaseDao <TShopAttribute,Long> {
	
	/**
	 * 根据id获得属性及其选项
	 * @param id
	 * @return
	 */
	TShopAttribute getWithOptionsById(Long id);
	
	
}