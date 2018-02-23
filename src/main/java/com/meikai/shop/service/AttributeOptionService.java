/**
 * 
 */
package com.meikai.shop.service;

import java.util.List;

import com.meikai.shop.entity.TShopAttributeOption;

/**
 * 地理
 * @author meikai
 * @version 2017年9月21日 下午11:16:38
 */
public interface AttributeOptionService extends BaseService<TShopAttributeOption, Long> {
	
	/**
	 * 根据属性Id获得属性
	 * @param attributeId
	 * @return
	 */
	List<TShopAttributeOption>getByAttributeId(Long attributeId);

}
