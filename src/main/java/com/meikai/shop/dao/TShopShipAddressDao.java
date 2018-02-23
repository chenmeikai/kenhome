package com.meikai.shop.dao;


import java.util.List;

import com.meikai.shop.entity.TShopShipAddress;

/**
 * 送货地址
 * @author Administrator
 * @version 2017年9月21日 上午10:07:41
 */

public interface TShopShipAddressDao extends BaseDao<TShopShipAddress,Long> {
	
	/**
	 * 获得包含地区名的收货地址集合 ,按默认设置排序
	 */
	List<TShopShipAddress> selectWithNameByUserId(Long userId);
	
	/**
	 * 根据Id获得包含地区名的收货地址
	 */
	TShopShipAddress getWithNameById(Long id);
   
}