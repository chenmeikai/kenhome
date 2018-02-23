package com.meikai.shop.dao;



import com.meikai.shop.entity.TShopSpuAttributeOption;

/**
 * 商品-属性值关联
 * @author Administrator
 * @version 2017年10月24日 上午10:24:34
 */

public interface TShopSpuAttributeOptionDao extends BaseDao<TShopSpuAttributeOption,Long> {
	
	/**
	 * 根据SpuId删除关联属性值
	 */
	 Long deleteBySpuId(Long spuId);
    
}