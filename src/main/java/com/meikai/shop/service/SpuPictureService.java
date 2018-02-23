/**
 * 
 */
package com.meikai.shop.service;

import java.util.List;

import com.meikai.shop.entity.TShopSpuPicture;

/**
 * 商品图片
 * @author meikai
 * @version 2017年9月21日 下午11:16:38
 */
public interface SpuPictureService extends BaseService<TShopSpuPicture, Long> {
	
	/**
	 * 根据SpuId获得管理图片
	 * @param spuId
	 * @return
	 */
	List<TShopSpuPicture> getBySpuId(Long spuId);

}
