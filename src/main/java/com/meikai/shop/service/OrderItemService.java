/**
 * 
 */
package com.meikai.shop.service;

import java.util.List;

import com.meikai.shop.entity.TShopOrderItem;

/**
 * 订单品项
 * @author meikai
 * @version 2017年9月21日 下午11:16:38
 */
public interface OrderItemService extends BaseService<TShopOrderItem, Long> {
	
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
