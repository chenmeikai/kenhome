/**
 * 
 */
package com.meikai.shop.service;

import java.util.List;

import com.meikai.shop.entity.TShopCartSku;

/**
 * 购物车-单品
 * @author meikai
 * @version 2017年9月21日 下午11:16:38
 */
public interface CartSkuService extends BaseService<TShopCartSku, Long> {
	
	/**
	 * 根据用户Id获得所有购物车商品
	 */
	public List<TShopCartSku> getWithSkuByUserId(Long userId);
	
	/**
	 * 根据cartSku Id获得购物车商品,包含商品信息
	 */
	public TShopCartSku getWithSkuById(Long id);

}
