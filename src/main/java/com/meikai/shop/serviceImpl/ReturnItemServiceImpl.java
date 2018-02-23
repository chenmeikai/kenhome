/**
 * 
 */
package com.meikai.shop.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meikai.shop.dao.TShopReturnItemDao;
import com.meikai.shop.entity.TShopReturnItem;
import com.meikai.shop.service.ReturnItemService;

/**
 * 退货品项
 * @author meikai
 * @version 2017年9月23日 下午9:58:37
 */

@Service("returnItemServiceImpl")
public class ReturnItemServiceImpl extends BaseServiceImpl<TShopReturnItem, Long> implements ReturnItemService {

	
	@Autowired
	private TShopReturnItemDao returnItemDao;
	
	@Autowired
	public void setBaseDao() {
		super.setBaseDao(returnItemDao);
	}
	
	
}
