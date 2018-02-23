/**
 * 
 */
package com.meikai.shop.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meikai.shop.dao.TShopSkuAttributeOptionDao;
import com.meikai.shop.entity.TShopSkuAttributeOption;
import com.meikai.shop.service.SkuAttributeOptionService;

/**
 * 单品-属性-值
 * @author meikai
 * @version 2017年9月23日 下午9:58:37
 */

@Service("skuAttributeOptionServiceImpl")
public class SkuAttributeServiceImpl extends BaseServiceImpl<TShopSkuAttributeOption, Long> implements SkuAttributeOptionService {

	
	@Autowired
	private TShopSkuAttributeOptionDao skuAttributeOptionDao;
	
	
	@Autowired
	public void setBaseDao() {
		super.setBaseDao(skuAttributeOptionDao);
	}
    
    /**
     * 根据单品Id获得属性值关联
     */
	@Override
	public List<TShopSkuAttributeOption> getBySkuId(Long skuId) {
		// TODO Auto-generated method stub
		return skuAttributeOptionDao.getBySkuId(skuId);
	}

    /**
     * 根据属性值Id获得单品关联
     */
	@Override
	public List<TShopSkuAttributeOption> getByOptionId(Long optionId) {
		// TODO Auto-generated method stub
		return skuAttributeOptionDao.getByOptionId(optionId);
	}
    
	/**
     * 根据商品Id删除属性值关联
     */
	@Override
	public long deleteBySkuId(Long SkuId) {
		// TODO Auto-generated method stub
		return skuAttributeOptionDao.deleteBySkuId(SkuId);
	}
	
	
}
