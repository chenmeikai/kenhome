/**
 * 
 */
package com.meikai.shop.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meikai.shop.dao.TShopLogisticDao;
import com.meikai.shop.entity.TShopLogistic;
import com.meikai.shop.service.LogisticService;

/**
 * 物流
 * @author meikai
 * @version 2017年9月23日 下午9:58:37
 */

@Service("logisticServiceImpl")
public class LogisticServiceImpl extends BaseServiceImpl<TShopLogistic, Long> implements LogisticService {

	
	@Autowired
	private TShopLogisticDao logisticDao;
	
	@Autowired
	public void setBaseDao() {
		super.setBaseDao(logisticDao);
	}
	
	
}
