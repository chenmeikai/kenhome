/**
 * 
 */
package com.meikai.shop.service;

import java.util.List;

import com.meikai.shop.entity.TShopAttribute;

/**
 * 地理
 * @author meikai
 * @version 2017年9月21日 下午11:16:38
 */
public interface AttributeService extends BaseService<TShopAttribute, Long> {
	
	/**
	 * 根据id获得属性及其选项
	 * @param id
	 * @return
	 */
	TShopAttribute getWithOptionsById(Long id);
	
	

}
