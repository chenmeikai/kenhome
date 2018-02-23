package com.meikai.shop.dao;


import com.meikai.shop.entity.TSystemRoleAcl;

/**
 * 角色-资源关联
 * @author Administrator
 * @version 2017年9月21日 上午11:31:37
 */

public interface TSystemRoleAclDao extends BaseDao<TSystemRoleAcl,Long> {
	
	/**
	 * 根据角色ID删除角色与资源的关联
	 * @param roleID
	 * @return
	 */
	Long deleteByRoleID(Long roleID);
    
}