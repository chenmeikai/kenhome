package com.meikai.shop.dao;

import java.util.List;

import com.meikai.shop.entity.TShopSkuAttributeOption;

/**
 * 单品属性-单品关联
 * @author Administrator
 * @version 2017年9月21日 上午9:54:57
 */
public interface TShopSkuAttributeOptionDao extends BaseDao<TShopSkuAttributeOption,Long> {
	
	/**
	 * 根据单品Id获得属性值关联
	 */
    List<TShopSkuAttributeOption> getBySkuId(Long skuId);
    
    
    /**
	 * 根据属性值Id获得单品关联
	 */
    List<TShopSkuAttributeOption> getByOptionId(Long optionId);
    
    /**
     * 根据商品Id删除属性值关联
     */
    long deleteBySkuId(Long SkuId);
    
}