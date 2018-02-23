package com.meikai.shop.dao;


import java.util.List;

import com.meikai.shop.entity.TSystemAcl;

/**
 * 资源
 * @author Administrator
 * @version 2017年9月21日 上午11:27:40
 */

public interface TSystemAclDao extends BaseDao<TSystemAcl,Long> {
	
	
	/**
	 * 获得根资源至末级资源
	 */
	List<TSystemAcl>  getRootandChildrenAcls();
	
	
	/**
	 * 获得多级子资源
	 */
	List<TSystemAcl> getChildrenAcls(Long parent_id);
	
	
	/**
	 * 获得某级资源
	 */
	List<TSystemAcl> getGradeAcls(Integer acl_grade);
    
}