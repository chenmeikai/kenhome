package com.meikai.shop.dao;

import java.util.List;

import com.meikai.shop.entity.TShopBrand;

/**
 * 商标
 * @author Administrator
 * @version 2017年9月21日 上午9:51:52
 */

public interface TShopBrandDao extends BaseDao<TShopBrand,Long> {
	
	/**
	 * 根据品牌名模糊查询
	 * @param brandName
	 * @return
	 */
	List<TShopBrand> getByFuzzybrandName(String brandName);
    
}