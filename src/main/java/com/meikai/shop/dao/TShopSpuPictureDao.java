package com.meikai.shop.dao;

import java.util.List;

import com.meikai.shop.entity.TShopSpuPicture;

/**
 * 商品图片
 * @author Administrator
 * @version 2017年9月21日 上午10:05:11
 */

public interface TShopSpuPictureDao extends BaseDao<TShopSpuPicture,Long> {
	
	/**
	 * 根据SpuId获得管理图片
	 * @param spuId
	 * @return
	 */
	List<TShopSpuPicture> getBySpuId(Long spuId);
    
}