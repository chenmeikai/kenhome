/**
 * 
 */
package com.meikai.shop.service;

import java.util.List;

import com.meikai.shop.entity.TShopShipAddress;

/**
 * 送货地址
 * @author meikai
 * @version 2017年9月21日 下午11:16:38
 */
public interface ShipAddressService extends BaseService<TShopShipAddress, Long> {
	
	/**
	 * 获得包含地区名的收货地址集合 ,按默认设置排序
	 */
	List<TShopShipAddress> getWithNameByUserId(Long userId);
	
	/**
	 * 根据Id获得包含地区名的收货地址
	 */
	TShopShipAddress getWithNameById(Long id);

}
