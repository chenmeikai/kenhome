/**
 * 
 */
package com.meikai.shop.service;



import com.meikai.shop.entity.TShopSpuAttributeOption;

/**
 * 商品-属性值关联
 * @author meikai
 * @version 2017年10月24日 下午10:24:38
 */
public interface SpuAttributeOptionService extends BaseService<TShopSpuAttributeOption, Long> {
	
	/**
	 * 根据SpuId删除关联属性值
	 */
	 Long deleteBySpuId(Long spuId);
	
	
}
