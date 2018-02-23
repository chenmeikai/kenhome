/**
 * 
 */
package com.meikai.shop.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meikai.shop.dao.TSystemRoleDao;
import com.meikai.shop.entity.TSystemRole;
import com.meikai.shop.service.RoleService;

/**
 * 角色
 * @author meikai
 * @version 2017年9月23日 下午9:58:37
 */

@Service("roleServiceImpl")
public class RoleServiceImpl extends BaseServiceImpl<TSystemRole, Long> implements RoleService {

	
	@Autowired
	private TSystemRoleDao roleDao;
	
	@Autowired
	public void setBaseDao() {
		super.setBaseDao(roleDao);
	}
	
	
}
