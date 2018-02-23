package com.meikai.shop.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.meikai.shop.entity.TShopSku;

/**
 * 单品
 * @author Administrator
 * @version 2017年9月21日 上午9:56:13
 */

public interface TShopSkuDao extends BaseDao<TShopSku,Long> {
	
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
	List<TShopSku> getByrootcategoryIdRandom(@Param("rootCategoryId")Long rootCategoryId,@Param("num")Long skuNum);
			
	/**
	 * 根据spuId和关键属性值获得SKU
	 */
	 List<TShopSku> getByspuIdAndoptions(@Param("optionIds")Long[] optionIds,@Param("spuId")Long spuId);
	 
	 
	/**
	 * 根据三级分类及多条件查询商品 
	 */
	 List<TShopSku> getByThird(Map<String, Object> params);
	 
	 /**
	  * 根据二级分类及多条件查询商品 
	  */
	 List<TShopSku> getBySecond(Map<String, Object> params);	
	 
	 /**
	  * 根据一级分类及多条件查询商品 
	  */
	 List<TShopSku> getByFirst(Map<String, Object> params);
}