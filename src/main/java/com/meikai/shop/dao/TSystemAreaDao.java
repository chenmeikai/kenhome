package com.meikai.shop.dao;


import java.util.List;

import com.meikai.shop.entity.TSystemArea;

/**
 * 地理位置
 * @author Administrator
 * @version 2017年9月21日 上午11:28:23
 */

public interface TSystemAreaDao extends BaseDao<TSystemArea,Long> {
	
	/**
	 * 获得省份、直辖市
	 */
	List<TSystemArea> getRoot();
	
	/**
	 * 获得下级地区
	 */
	List<TSystemArea> getSon(Long parentId);
    
}