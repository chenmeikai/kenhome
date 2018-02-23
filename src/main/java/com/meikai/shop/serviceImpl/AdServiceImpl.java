/**
 * 
 */
package com.meikai.shop.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.meikai.shop.dao.TShopAdDao;
import com.meikai.shop.entity.TShopAd;
import com.meikai.shop.service.AdService;

/**
 * 广告
 * @author meikai
 * @version 2017年9月23日 下午9:58:37
 */

@Service("adServiceImpl")
public class AdServiceImpl extends BaseServiceImpl<TShopAd, Long> implements AdService {

	
	@Autowired
	private TShopAdDao adDao;
	
	@Autowired
	public void setBaseDao() {
		super.setBaseDao(adDao);
	}
	
	
}
