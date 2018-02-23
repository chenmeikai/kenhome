/**
 * 
 */
package com.meikai.shop.serviceImpl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meikai.shop.dao.TShopCartSkuDao;
import com.meikai.shop.entity.TShopCartSku;
import com.meikai.shop.service.CartSkuService;

/**
 * 购物车-单品
 * @author meikai
 * @version 2017年9月23日 下午9:58:37
 */

@Service("cartSkuServiceImpl")
public class CartSkuServiceImpl extends BaseServiceImpl<TShopCartSku, Long> implements CartSkuService {

	
	@Autowired
	private TShopCartSkuDao cartSkuDao;
	
	@Autowired
	public void setBaseDao() {
		super.setBaseDao(cartSkuDao);
	}
    
	/**
	 * 根据用户Id获得所有购物车的商品，包括商品信息
	 */
	@Override
	public List<TShopCartSku> getWithSkuByUserId(Long userId) {
		// TODO Auto-generated method stub
		return cartSkuDao.getWithSkuByUserId(userId);
	}
    
	/**
	 * 根据cartSku Id获得购物车商品,包含商品信息
	 */
	@Override
	public TShopCartSku getWithSkuById(Long id) {
		// TODO Auto-generated method stub
		return cartSkuDao.getWithSkuById(id);
	}
	
	
	
}
