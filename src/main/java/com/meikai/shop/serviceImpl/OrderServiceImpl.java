/**
 * 
 */
package com.meikai.shop.serviceImpl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.meikai.pageHleper.EntityPage;
import com.meikai.shop.dao.TShopOrderDao;
import com.meikai.shop.entity.TShopOrder;
import com.meikai.shop.service.OrderService;


/**
 * 订单
 * @author meikai
 * @version 2017年9月23日 下午9:58:37
 */

@Service("orderServiceImpl")
public class OrderServiceImpl extends BaseServiceImpl<TShopOrder, Long> implements OrderService {

	
	@Autowired
	private TShopOrderDao orderDao;
	
	@Autowired
	public void setBaseDao() {
		super.setBaseDao(orderDao);
	}
    
	/**
	 * 根据订单状态和用户ID获得订单
	 */
	@Override
	public EntityPage<TShopOrder> getByStatuAndUserId(Integer orderStatu, Long userId,Integer currentPage,Integer pageSize) {		
		PageHelper.startPage(currentPage, pageSize);
        List<TShopOrder> orders = orderDao.getByStatuAndUserId(orderStatu, userId);
        EntityPage<TShopOrder> pageInfo = new EntityPage<TShopOrder>(orders);
        return pageInfo;
		
	}
	
	
}
