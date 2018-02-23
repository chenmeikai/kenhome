package com.meikai.shop.dao;

import java.util.List;

import com.meikai.shop.entity.TShopAttributeOption;

/**
 * 商品属性值
 * @author Administrator
 * @version 2017年9月21日 上午9:50:58
 */

public interface TShopAttributeOptionDao extends BaseDao <TShopAttributeOption,Long> {
	
	/**
	 * 根据属性Id获得属性
	 * @param attributeId
	 * @return
	 */
	List<TShopAttributeOption>getByAttributeId(Long attributeId);
    
}