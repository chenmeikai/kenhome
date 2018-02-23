/**
 * 
 */
package com.meikai.shop.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meikai.shop.dao.TSystemRoleAclDao;
import com.meikai.shop.entity.TSystemRoleAcl;
import com.meikai.shop.service.RoleAclService;

/**
 * 角色-资源
 * @author meikai
 * @version 2017年9月23日 下午9:58:37
 */

@Service("roleAclServiceImpl")
public class RoleAclServiceImpl extends BaseServiceImpl<TSystemRoleAcl, Long> implements RoleAclService {

	
	@Autowired
	private TSystemRoleAclDao roleAclDao;
	
	@Autowired
	public void setBaseDao() {
		super.setBaseDao(roleAclDao);
	}
    
	
	/**
	 * 根据角色ID删除与资源的关联
	 */
	@Override
	public Long deleteByRoleID(Long roleID) {
		// TODO Auto-generated method stub
		return roleAclDao.deleteByRoleID(roleID);
	}
	
	
}
