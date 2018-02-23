/**
 * 
 */
package com.meikai.shop.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meikai.shop.dao.TShopShipAddressDao;
import com.meikai.shop.entity.TShopShipAddress;
import com.meikai.shop.service.ShipAddressService;

/**
 * 送货地址
 * @author meikai
 * @version 2017年9月23日 下午9:58:37
 */

@Service("shipAddressServiceImpl")
public class ShipAddressServiceImpl extends BaseServiceImpl<TShopShipAddress, Long> implements ShipAddressService {

	
	@Autowired
	private TShopShipAddressDao shipAddressDao;
	
	@Autowired
	public void setBaseDao() {
		super.setBaseDao(shipAddressDao);
	}
    
	/**
	 * 获得包含地区名的收货地址集合 ,按默认设置排序
	 */
	@Override
	public List<TShopShipAddress> getWithNameByUserId(Long userId) {
		// TODO Auto-generated method stub
		return shipAddressDao.selectWithNameByUserId(userId);
	}
    
	/**
	 * 根据Id获得包含地区名的收货地址
	 */
	@Override
	public TShopShipAddress getWithNameById(Long id) {
		// TODO Auto-generated method stub
		return shipAddressDao.getWithNameById(id);
	}
	
	
}
