package com.meikai.shop.dao;


import java.util.List;

import com.meikai.shop.entity.TShopCartSku;

/**
 * 购物车-商品
 * @author Administrator
 * @version 2017年9月21日 上午9:53:09
 */

public interface TShopCartSkuDao extends BaseDao<TShopCartSku,Long> {
	
	/**
	 * 根据用户Id获得所有购物车商品
	 */
	public List<TShopCartSku> getWithSkuByUserId(Long userId);
	
	/**
	 * 根据cartSku Id获得购物车商品,包含商品信息
	 */
	public TShopCartSku getWithSkuById(Long id);
	

    
}