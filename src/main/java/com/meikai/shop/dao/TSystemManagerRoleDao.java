package com.meikai.shop.dao;


import com.meikai.shop.entity.TSystemManagerRole;

/**
 * 管理-角色
 * @author Administrator
 * @version 2017年9月21日 上午11:31:06
 */

public interface TSystemManagerRoleDao extends BaseDao<TSystemManagerRole,Long> {
	
	
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
	Long deleteByRoleID(Long roelID);
    
}