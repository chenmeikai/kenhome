/**
 * 
 */
package com.meikai.shop.service;

import java.util.List;

import com.meikai.shop.entity.TShopBrand;

/**
 * 商标
 * @author meikai
 * @version 2017年9月21日 下午11:16:38
 */
public interface BrandService extends BaseService<TShopBrand, Long> {
	
	/**
	 * 根据品牌名模糊查询
	 * @param brandName
	 * @return
	 */
	List<TShopBrand> getByFuzzybrandName(String brandName);

}
