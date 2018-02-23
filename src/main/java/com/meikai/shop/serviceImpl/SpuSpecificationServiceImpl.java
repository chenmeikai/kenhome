/**
 * 
 */
package com.meikai.shop.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meikai.shop.dao.TShopSpuSpecificationDao;
import com.meikai.shop.entity.TShopSpuSpecification;
import com.meikai.shop.service.SpuSpecificationService;

/**
 * 商品-规格
 * @author meikai
 * @version 2017年9月23日 下午9:58:37
 */

@Service("spuSpecificationServiceImpl")
public class SpuSpecificationServiceImpl extends BaseServiceImpl<TShopSpuSpecification, Long> implements SpuSpecificationService {

	
	@Autowired
	private TShopSpuSpecificationDao spuSpecification;
	
	@Autowired
	public void setBaseDao() {
		super.setBaseDao(spuSpecification);
	}
	
	
}
