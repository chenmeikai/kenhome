/**
 * 
 */
package com.meikai.shop.service;

import java.util.List;

import com.meikai.shop.entity.TSystemManager;

/**
 * 管理员
 * @author meikai
 * @version 2017年9月23日 下午11:45:37
 */
public interface ManagerService extends BaseService<TSystemManager, Long> {
	
	/**
	 * 根据ID获得管理员（内含角色名和资源权限）
	 * @return
	 */
	TSystemManager getRolesAndAclsByID(Long id);
	
	
	
	/**
	 * 根据管理员名获得管理员（附加角色名和权限）
	 * @param managerName
	 * @return
	 */
	TSystemManager getRolesAndAclsByName(String managerName);
	
	
	/**
	 * 根据名字迷糊查询出管理员
	 * @return
	 */
	List<TSystemManager> getSomeManagersByName(String managerName);

}
