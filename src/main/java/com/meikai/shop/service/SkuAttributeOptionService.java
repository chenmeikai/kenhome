/**
 * 
 */
package com.meikai.shop.service;

import java.util.List;

import com.meikai.shop.entity.TShopSkuAttributeOption;

/**
 * 单品-属性
 * @author meikai
 * @version 2017年9月21日 下午11:16:38
 */
public interface SkuAttributeOptionService extends BaseService<TShopSkuAttributeOption, Long> {
	
	/**
	 * 根据单品Id获得属性关联
	 */
    List<TShopSkuAttributeOption> getBySkuId(Long skuId);
    
    
    /**
	 * 根据属性值Id获得属性关联
	 */
    List<TShopSkuAttributeOption> getByOptionId(Long optionId);
    
    /**
     * 根据商品Id删除属性值关联
     */
    long deleteBySkuId(Long SkuId);
    
    
}
