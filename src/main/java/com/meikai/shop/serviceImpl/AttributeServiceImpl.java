/**
 * 
 */
package com.meikai.shop.serviceImpl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meikai.shop.dao.TShopAttributeDao;
import com.meikai.shop.entity.TShopAttribute;
import com.meikai.shop.service.AttributeService;

/**
 * 属性
 * @author meikai
 * @version 2017年9月23日 下午9:58:37
 */

@Service("attributeServiceImpl")
public class AttributeServiceImpl extends BaseServiceImpl<TShopAttribute, Long> implements AttributeService {

	
	@Autowired
	private TShopAttributeDao attributeDao;
	
	@Autowired
	public void setBaseDao() {
		super.setBaseDao(attributeDao);
	}
    
	/**
	 * 根据Id获得属性及其选项
	 */
	@Override
	public TShopAttribute getWithOptionsById(Long id) {
		// TODO Auto-generated method stub
		return attributeDao.getWithOptionsById(id);
	}
    
	
}
