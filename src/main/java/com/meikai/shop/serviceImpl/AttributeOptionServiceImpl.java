/**
 * 
 */
package com.meikai.shop.serviceImpl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meikai.shop.dao.TShopAttributeOptionDao;
import com.meikai.shop.entity.TShopAttributeOption;
import com.meikai.shop.service.AttributeOptionService;

/**
 * 属性-值
 * @author meikai
 * @version 2017年9月23日 下午9:58:37
 */

@Service("attributeOptionServiceImpl")
public class AttributeOptionServiceImpl extends BaseServiceImpl<TShopAttributeOption, Long> implements AttributeOptionService {

	
	@Autowired
	private TShopAttributeOptionDao attributeOptionDao;
	
	@Autowired
	public void setBaseDao() {
		super.setBaseDao(attributeOptionDao);
	}
    
	/**
	 * 根据属性Id获得属性值
	 */
	@Override
	public List<TShopAttributeOption> getByAttributeId(Long attributeId) {
		// TODO Auto-generated method stub
		return attributeOptionDao.getByAttributeId(attributeId);
	}
	
	
}
