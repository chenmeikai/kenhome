/**
 * 
 */
package com.meikai.shop.service;

import com.meikai.shop.entity.TSystemManagerRole;

/**
 * 管理员-角色
 * @author meikai
 * @version 2017年9月21日 下午11:16:38
 */
public interface ManagerRoleService extends BaseService<TSystemManagerRole, Long> {
	
	/**
	 * 根据管理员ID删除关联
	 * @param managerID
	 * @return
	 */
	Long deleteByManagerID(Long managerID);
	
	
	/**
	 * 根据角色ID删除关联
	 * @param roelID
	 * @return
	 */
	Long deleteByRoleID(Long roleID);

}
