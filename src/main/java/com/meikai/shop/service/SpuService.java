/**
 * 
 */
package com.meikai.shop.service;

import java.util.List;
import java.util.Map;

import com.meikai.pageHleper.EntityPage;
import com.meikai.shop.entity.TShopSpu;

/**
 * 商品
 * @author meikai
 * @version 2017年9月21日 下午11:16:38
 */
public interface SpuService extends BaseService<TShopSpu, Long> {
	
	/**
	 * 根据品牌Id获得所有商品
	 */
     List<TShopSpu> getByBrandId(Long brandId);
     
     /**
      * 增强多参数查询
      */
     List<TShopSpu> selectPlusByparams(Map<String, Object> params);
     
     /**
      * 增强多参数查询分页
      */
     EntityPage<TShopSpu> selectPlusByparamsAndPage(Map<String, Object> params,int currentPage, int pageSize);
     
     /**
      * 根据ID获得商品，包含商品的属性及属性类型，属性的属性值
      * 
      */
     TShopSpu getSpuAttrOptionsById(Long id);
}
