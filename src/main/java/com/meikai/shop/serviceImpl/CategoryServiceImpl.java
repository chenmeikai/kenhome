/**
 * 
 */
package com.meikai.shop.serviceImpl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meikai.shop.dao.TShopCategoryDao;
import com.meikai.shop.entity.TShopCategory;
import com.meikai.shop.service.CategoryService;

/**
 * 分类
 * @author meikai
 * @version 2017年9月23日 下午9:58:37
 */

@Service("categoryServiceImpl")
public class CategoryServiceImpl extends BaseServiceImpl<TShopCategory, Long> implements CategoryService {

	
	@Autowired
	private TShopCategoryDao categoryDao;
	
	@Autowired
	public void setBaseDao() {
		super.setBaseDao(categoryDao);
	}

	
    /**
     * 获得根分类及其子孙分类
     */
	@Override
	public List<TShopCategory> getRootWithChildrenCategorys() {
		// TODO Auto-generated method stub
		return categoryDao.getRootWithChildrenCategorys();
	}
    
	

    /**
     * 获得子分类及其子孙分类
     */
	@Override
	public List<TShopCategory> getChildrenCategorys(Long parentId) {
		// TODO Auto-generated method stub
		return categoryDao.getChildrenCategorys(parentId);
	}

	
    /**
     * 获得分类及其子孙分类
     */
	@Override
	public TShopCategory getBaseWithChildrenCategorys(Long id) {
		// TODO Auto-generated method stub
		return categoryDao.getBaseWithChildrenCategorys(id);
	}

	/**
	 * 获得分类，包含属性集合，属性用途类型，属性包含选项集合
	 * @param id
	 * @return 获得分类，包含属性集合，属性包含选项集合 
	 */
	@Override
	public TShopCategory getBaseWithAttrsWithOptions(Long id) {
		// TODO Auto-generated method stub
		return categoryDao.getBaseWithAttrsWithOptions(id);
	}

    /**
     * 根据ID获取分类ID，名字，父分类ID及父分类对象
     */
	@Override
	public TShopCategory getWithParentById(Long id) {
		// TODO Auto-generated method stub
		return categoryDao.getWithParentById(id);
	}
	
	
	
	
}
