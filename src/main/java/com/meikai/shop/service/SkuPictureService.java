/**
 * 
 */
package com.meikai.shop.service;

import java.util.List;

import com.meikai.shop.entity.TShopSkuPicture;

/**
 * 单品-图片关联
 * @author meikai
 * @version 2017年9月21日 下午11:16:38
 */
public interface SkuPictureService extends BaseService<TShopSkuPicture, Long> {
	
	/**
	 * 根据商品Id获得管理图片
	 * @param skuId
	 * @return
	 */
	List<TShopSkuPicture> getBySkuId(Long skuId);

}
