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
import com.meikai.shop.dao.TShopSkuDao;
import com.meikai.shop.entity.TShopSku;
import com.meikai.shop.service.SkuService;


/**
 * 单品
 * @author meikai
 * @version 2017年9月23日 下午9:58:37
 */

@Service("skuServiceImpl")
public class SkuServiceImpl extends BaseServiceImpl<TShopSku, Long> implements SkuService {

	
	@Autowired
	private TShopSkuDao skuDao;
	
	@Autowired
	public void setBaseDao() {
		super.setBaseDao(skuDao);
	}
    
	/**
	 * 根据Spuid获得系列商品
	 */
	@Override
	public List<TShopSku> getBySpuId(Long spuId) {
		// TODO Auto-generated method stub
		return skuDao.getBySpuId(spuId);
	}
    /**
     * 根据SPuId，获得包含属性集合，属性值集合的系列商品
     */
	@Override
	public List<TShopSku> getplusBySpuId(Long spuId) {
		// TODO Auto-generated method stub
		return skuDao.getplusBySpuId(spuId);
	}
    
	/**
	 * 根据SkuId 获得包含属性集合，属性值集合的系列商品
	 */
	@Override
	public TShopSku getPlusById(Long id) {
		// TODO Auto-generated method stub
		return skuDao.getPlusById(id);
	}

		
	/**
	 * 根据根分类Id随机获取skuNum条数据
	 */
	@Override
	public List<TShopSku> getByrootcategoryIdRandom(Long categoryId, Long skuNum) {
		// TODO Auto-generated method stub
		return skuDao.getByrootcategoryIdRandom(categoryId, skuNum);
	}
	
	/**
	 * 根据spuId和关键属性值获得SKU
	 */
	@Override
	public List<TShopSku> getByspuIdAndoptions(Long[] optionIds, Long spuId) {
		// TODO Auto-generated method stub
		return skuDao.getByspuIdAndoptions(optionIds, spuId);
	}
    
	/**
	  * 根据三级分类及多条件查询商品 
	  */
	@Override
	public EntityPage<TShopSku> getByThird(Map<String, Object> params, int currentPage, int pageSize) {
		PageHelper.startPage(currentPage, pageSize);
        List<TShopSku> skus = skuDao.getByThird(params);
        EntityPage<TShopSku> pageInfo = new EntityPage<TShopSku>(skus);
        return pageInfo;
        
	}
    
	/**
	  * 根据二级分类及多条件查询商品 
	  */
	@Override
	public EntityPage<TShopSku> getBySecond(Map<String, Object> params, int currentPage, int pageSize) {
		PageHelper.startPage(currentPage, pageSize);
        List<TShopSku> skus = skuDao.getBySecond(params);
        EntityPage<TShopSku> pageInfo = new EntityPage<TShopSku>(skus);
        return pageInfo;
	}
    
	/**
	  * 根据三级分类及多条件查询商品 
	  */
	@Override
	public EntityPage<TShopSku> getByFirst(Map<String, Object> params, int currentPage, int pageSize) {
		PageHelper.startPage(currentPage, pageSize);
        List<TShopSku> skus = skuDao.getByFirst(params);
        EntityPage<TShopSku> pageInfo = new EntityPage<TShopSku>(skus);
        return pageInfo;
	}
	
	
}
