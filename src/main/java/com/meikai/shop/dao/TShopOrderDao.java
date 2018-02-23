package com.meikai.shop.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.meikai.shop.entity.TShopOrder;

/**
 * 订单
 * @author Administrator
 * @version 2017年9月21日 上午10:03:01
 */

public interface TShopOrderDao extends BaseDao<TShopOrder,Long> {
	
	/**
	 * 根据订单状态和用户ID获得订单
	 */
	List<TShopOrder> getByStatuAndUserId(@Param("orderStatu")Integer orderStatu,@Param("userId")Long  userId);
	
	
    
}