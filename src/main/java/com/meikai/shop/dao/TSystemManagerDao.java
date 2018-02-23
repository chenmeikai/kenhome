package com.meikai.shop.dao;


import java.util.List;

import com.meikai.shop.entity.TSystemManager;

/**
 * 管理员
 * @author Administrator
 * @version 2017年9月21日 上午11:30:42
 */

public interface TSystemManagerDao extends BaseDao<TSystemManager,Long> {
	
	
	/**
	 * 根据ID获得管理员（内含角色名和资源权限）
	 * @return
	 */
	TSystemManager getRolesAndAclsByID(Long id);
	
	
	/**
	 * 根据用户名获得管理员（内含角色名和资源权限）
	 * @return
	 */
	TSystemManager getRolesAndAclsByName(String managerName);
	
	
	/**
	 * 根据管理员名获得管理员
	 * @param managerName
	 * @return
	 */
	TSystemManager getByName(String managerName);
	
	
	/**
	 * 根据用户名模糊查询出管理员
	 * @return
	 */
	List<TSystemManager> getSomeManagersByName(String managerName);
    
}