/**
 * 
 */
package com.meikai.shop.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meikai.shop.dao.TShopBrandDao;
import com.meikai.shop.entity.TShopBrand;
import com.meikai.shop.service.BrandService;

/**
 * 商标
 * @author meikai
 * @version 2017年9月23日 下午9:58:37
 */

@Service("brankServiceImpl")
public class BrandServiceImpl extends BaseServiceImpl<TShopBrand, Long> implements BrandService {

	
	@Autowired
	private TShopBrandDao brankDao;
	
	@Autowired
	public void setBaseDao() {
		super.setBaseDao(brankDao);
	}
    
	/**
	 * 根据品牌名模糊查询
	 */
	@Override
	public List<TShopBrand> getByFuzzybrandName(String brandName) {
		// TODO Auto-generated method stub
		return brankDao.getByFuzzybrandName(brandName);
	}
	
	
}
