package com.meikai.shop.dao;



import java.util.List;

import com.meikai.shop.entity.TShopSkuPicture;

/**
 * 单品-图片关联
 * @author Administrator
 * @version 2017年9月21日 上午9:56:13
 */

public interface TShopSkuPictureDao extends BaseDao<TShopSkuPicture,Long> {
	
	/**
	 * 根据商品Id获得管理图片
	 * @param skuId
	 * @return
	 */
	List<TShopSkuPicture> getBySkuId(Long skuId);
   
}