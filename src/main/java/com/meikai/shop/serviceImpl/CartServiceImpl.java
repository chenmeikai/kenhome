/**
 * 
 */
package com.meikai.shop.serviceImpl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meikai.shop.dao.TShopCartDao;
import com.meikai.shop.entity.TShopCart;
import com.meikai.shop.service.CartService;

/**
 * 购物车
 * @author meikai
 * @version 2017年9月23日 下午9:58:37
 */

@Service("cartServiceImpl")
public class CartServiceImpl extends BaseServiceImpl<TShopCart, Long> implements CartService {

	
	@Autowired
	private TShopCartDao cartDao;
	
	@Autowired
	public void setBaseDao() {
		super.setBaseDao(cartDao);
	}
	
	
}
