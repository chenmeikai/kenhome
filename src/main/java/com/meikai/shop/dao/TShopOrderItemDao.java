package com.meikai.shop.dao;


import java.util.List;

import com.meikai.shop.entity.TShopOrderItem;

/**
 * 订单项目
 * @author Administrator
 * @version 2017年9月21日 上午10:03:32
 */

public interface TShopOrderItemDao extends BaseDao<TShopOrderItem,Long> {
	
	/**
	 * 根据订单ID删除相关品项
	 * 
	 */
	Long deleteByOrderId(Long orderId);
	
	/**
	 * 根据订单ID获得品项集合
	 */
	List<TShopOrderItem> getByOrderId(Long OrderId);
    
}