/**
 * 
 */
package com.meikai.shop.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.meikai.pageHleper.EntityPage;
import com.meikai.shop.entity.TShopSku;

/**
 * 单品
 * @author meikai
 * @version 2017年9月21日 下午11:16:38
 */
public interface SkuService extends BaseService<TShopSku, Long> {
	
	/**
	 * 根据Spuid获得系列商品
	 * @return
	 */
	List<TShopSku> getBySpuId(Long spuId);
	
	/**
	 * 根据SPuId，获得包含属性集合，属性值集合的系列商品
	 */
	List<TShopSku> getplusBySpuId(Long spuId);
	
	/**
	 * 根据SkuId 获得包含属性集合，属性值集合的系列商品
	 * @param id
	 * @return
	 */
	 TShopSku getPlusById(Long id);
	
	/**
	 * 根据根分类Id随机获取skuNum条数据
	 */
	 List<TShopSku> getByrootcategoryIdRandom(Long categoryId,Long skuNum);
	
	/**
	 * 根据spuId和关键属性值获得SKU
	 */
	 List<TShopSku> getByspuIdAndoptions(Long[] optionIds,Long spuId);
	 
	 /**
	  * 根据三级分类及多条件查询商品 
	  */
	 EntityPage<TShopSku> getByThird(Map<String, Object> params,int currentPage, int pageSize);
	 
	 /**
	  * 根据二级分类及多条件查询商品 
	  */
	 EntityPage<TShopSku> getBySecond(Map<String, Object> params,int currentPage, int pageSize);
	 
	 /**
	  * 根据一级分类及多条件查询商品 
	  */
	 EntityPage<TShopSku> getByFirst(Map<String, Object> params,int currentPage, int pageSize);

}
