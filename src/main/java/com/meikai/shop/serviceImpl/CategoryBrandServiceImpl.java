/**
 * 
 */
package com.meikai.shop.serviceImpl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meikai.shop.dao.TShopCategoryBrandDao;
import com.meikai.shop.dao.TShopCategoryDao;
import com.meikai.shop.entity.TShopCategory;
import com.meikai.shop.entity.TShopCategoryBrand;
import com.meikai.shop.service.CategoryBrandService;
import com.meikai.shop.service.CategoryService;

/**
 * 分类
 * @author meikai
 * @version 2017年9月23日 下午9:58:37
 */

@Service("categoryBrandServiceImpl")
public class CategoryBrandServiceImpl extends BaseServiceImpl<TShopCategoryBrand, Long> implements CategoryBrandService {

	
	@Autowired
	private TShopCategoryBrandDao categoryBrandDao;
	
	@Autowired
	public void setBaseDao() {
		super.setBaseDao(categoryBrandDao);
	}
    
	/**
	 * 根据分类Id获得品牌关联，内含品牌名
	 */
	@Override
	public List<TShopCategoryBrand> getWithNameByCategoryId(Long categoryId) {
		// TODO Auto-generated method stub
		return categoryBrandDao.getWithNameByCategoryId(categoryId);
	}

	
    
    
	

	
	
}
