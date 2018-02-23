/**
 * 
 */
package com.meikai.shop.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meikai.shop.dao.TShopOrderItemDao;
import com.meikai.shop.entity.TShopOrderItem;
import com.meikai.shop.service.OrderItemService;

/**
 * 订单品项
 * @author meikai
 * @version 2017年9月23日 下午9:58:37
 */

@Service("orderItemServiceImpl")
public class OrderItemServiceImpl extends BaseServiceImpl<TShopOrderItem, Long> implements OrderItemService {

	
	@Autowired
	private TShopOrderItemDao orderItemDao;
	
	@Autowired
	public void setBaseDao() {
		super.setBaseDao(orderItemDao);
	}
    
	/**
	 * 根据订单ID删除相关品项
	 */
	@Override
	public Long deleteByOrderId(Long orderId) {
		// TODO Auto-generated method stub
		return orderItemDao.deleteByOrderId(orderId);
	}
    
	/**
	 * 根据订单ID获得品项集合
	 */
	@Override
	public List<TShopOrderItem> getByOrderId(Long OrderId) {
		// TODO Auto-generated method stub
		return orderItemDao.getByOrderId(OrderId);
	}
	
	
}
