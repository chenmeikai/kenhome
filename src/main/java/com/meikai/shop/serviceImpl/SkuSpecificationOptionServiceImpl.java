/**
 * 
 */
package com.meikai.shop.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meikai.shop.dao.TShopSkuSpecificationOptionDao;
import com.meikai.shop.entity.TShopSkuSpecificationOption;
import com.meikai.shop.service.SkuSpecificationOptionService;

/**
 * 商品-规格-值
 * @author meikai
 * @version 2017年9月23日 下午9:58:37
 */

@Service("skuSpecificationOptionServiceImpl")
public class SkuSpecificationOptionServiceImpl extends BaseServiceImpl<TShopSkuSpecificationOption, Long> implements SkuSpecificationOptionService {

	
	@Autowired
	private TShopSkuSpecificationOptionDao skuSpecificationOptionDao;
	
	@Autowired
	public void setBaseDao() {
		super.setBaseDao(skuSpecificationOptionDao);
	}
	
	
}
