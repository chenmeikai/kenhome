package com.meikai.shop.dao;

import java.util.List;
import java.util.Map;

import com.meikai.shop.entity.TShopSpu;

/**
 * 商品
 * @author Administrator
 * @version 2017年9月21日 上午10:04:34
 */

public interface TShopSpuDao extends BaseDao<TShopSpu,Long> {
	
	/**
	 * 根据品牌Id获得所有商品
	 */
     List<TShopSpu> getByBrandId(Long brandId);
     
     /**
      * 增强多参数查询商品，包含品牌名、分类名
      */
     List<TShopSpu> selectPlusByparams(Map<String, Object> params);
     
     /**
      * 根据ID获得商品，包含商品的属性及属性类型，属性的属性值
      * 
      */
     TShopSpu getSpuAttrOptionsById(Long id);
}