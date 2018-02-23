/**
 * 
 */
package com.meikai.shop.service;

import com.meikai.shop.entity.TSystemRoleAcl;

/**
 * 角色-资源
 * @author meikai
 * @version 2017年9月21日 下午11:16:38
 */
public interface RoleAclService extends BaseService<TSystemRoleAcl, Long> {
	
	/**
	 * 根据角色ID删除角色与资源的关联
	 * @param roleID
	 * @return
	 */
	Long deleteByRoleID(Long roleID);

}
