/**
 * 
 */
package com.meikai.shop.service;

import java.util.List;

import com.meikai.shop.entity.TSystemArea;

/**
 * 地理
 * @author meikai
 * @version 2017年9月21日 下午11:16:38
 */
public interface AreaService extends BaseService<TSystemArea, Long> {
	
	/**
	 * 获得省份、直辖市
	 */
	List<TSystemArea> getRoot();
	
	/**
	 * 获得下级地区
	 */
	List<TSystemArea> getSon(Long parentId);

}
