/**
 * 
 */
package com.meikai.shop.service;

import java.util.List;

import com.meikai.pageHleper.EntityPage;
import com.meikai.shop.entity.TShopOrder;

/**
 * 订单
 * @author meikai
 * @version 2017年9月21日 下午11:16:38
 */
public interface OrderService extends BaseService<TShopOrder, Long> {
	
	/**
	 * 根据订单状态和用户ID获得订单
	 */
	EntityPage<TShopOrder> getByStatuAndUserId(Integer orderStatu,Long userId,Integer currentPage,Integer pageSize);

}
