/**
 * 
 */
package com.meikai.shop.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meikai.shop.dao.TShopOrderReturnDao;
import com.meikai.shop.entity.TShopOrderReturn;
import com.meikai.shop.service.OrderReturnService;

/**
 * 退单
 * @author meikai
 * @version 2017年9月23日 下午9:58:37
 */

@Service("orderReturnServiceImpl")
public class OrderReturnServiceImpl extends BaseServiceImpl<TShopOrderReturn, Long> implements OrderReturnService {

	
	@Autowired
	private TShopOrderReturnDao orderReturnDao;
	
	@Autowired
	public void setBaseDao() {
		super.setBaseDao(orderReturnDao);
	}
	
	
}
