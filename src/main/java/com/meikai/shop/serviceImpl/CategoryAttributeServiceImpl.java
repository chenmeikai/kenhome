/**
 * 
 */
package com.meikai.shop.serviceImpl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meikai.shop.dao.TShopCategoryAttributeDao;
import com.meikai.shop.entity.TShopCategoryAttribute;
import com.meikai.shop.service.CategoryAttributeService;

/**
 * 分类-属性关联
 * @author meikai
 * @version 2017年10月18日 下午18:31:37
 */

@Service("categoryAttributeImpl")
public class CategoryAttributeServiceImpl extends BaseServiceImpl<TShopCategoryAttribute, Long> implements CategoryAttributeService {

	
	@Autowired
	private TShopCategoryAttributeDao categoryAttributeDao;
	
	@Autowired
	public void setBaseDao() {
		super.setBaseDao(categoryAttributeDao);
	}
    
	/**
	 * 根据分类Id获得属性关联
	 */
	@Override
	public List<TShopCategoryAttribute> getByCategoryId(Long categoryId) {
		// TODO Auto-generated method stub
		return categoryAttributeDao.getByCategoryId(categoryId);
	}
    
	/**
	 * 根据属性Id获得分类关联
	 */
	@Override
	public List<TShopCategoryAttribute> getByAttributeId(Long attributeId) {
		// TODO Auto-generated method stub
		return categoryAttributeDao.getByAttributeId(attributeId);
	}

	
	
}
