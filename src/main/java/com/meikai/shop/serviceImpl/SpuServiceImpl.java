/**
 * 
 */
package com.meikai.shop.serviceImpl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.meikai.pageHleper.EntityPage;
import com.meikai.shop.dao.TShopSpuDao;
import com.meikai.shop.entity.TShopSpu;
import com.meikai.shop.service.SpuService;

/**
 * 商品
 * @author meikai
 * @version 2017年9月23日 下午9:58:37
 */

@Service("spuServiceImpl")
public class SpuServiceImpl extends BaseServiceImpl<TShopSpu, Long> implements SpuService {

	
	@Autowired
	private TShopSpuDao spuDao;
	
	@Autowired
	public void setBaseDao() {
		super.setBaseDao(spuDao);
	}
    
	/**
	 * 根据品牌ID获得所有商品
	 */
	@Override
	public List<TShopSpu> getByBrandId(Long brandId) {
		// TODO Auto-generated method stub
		return spuDao.getByBrandId(brandId);
	}
	
	
	/**
     * 增强多参数查询
     */
	@Override
	public List<TShopSpu> selectPlusByparams(Map<String, Object> params) {
        List<TShopSpu> spus = spuDao.selectPlusByparams(params); 
        return spus;
	}
	
    /**
     * 增强多参数查询分页
     */
	@Override
	public EntityPage<TShopSpu> selectPlusByparamsAndPage(Map<String, Object> params, int currentPage, int pageSize) {
		PageHelper.startPage(currentPage, pageSize);
        List<TShopSpu> spus = spuDao.selectPlusByparams(params);
        EntityPage<TShopSpu> pageInfo = new EntityPage<TShopSpu>(spus);
        return pageInfo;
	}
	
	/**
     * 根据ID获得商品，包含商品的属性及属性类型，属性的属性值
     * 
     */
	@Override
	public TShopSpu getSpuAttrOptionsById(Long id) {
		// TODO Auto-generated method stub
		return spuDao.getSpuAttrOptionsById(id);
	}
	
	
	
}
