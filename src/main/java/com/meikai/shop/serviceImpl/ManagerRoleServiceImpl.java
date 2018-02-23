/**
 * 
 */
package com.meikai.shop.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meikai.shop.dao.TSystemManagerRoleDao;
import com.meikai.shop.entity.TSystemManagerRole;
import com.meikai.shop.service.ManagerRoleService;

/**
 * 管理员-角色
 * @author meikai
 * @version 2017年9月23日 下午9:58:37
 */

@Service("managerRoleServiceImpl")
public class ManagerRoleServiceImpl extends BaseServiceImpl<TSystemManagerRole, Long> implements ManagerRoleService {

	
	@Autowired
	private TSystemManagerRoleDao managerRoleDao;
	
	@Autowired
	public void setBaseDao() {
		super.setBaseDao(managerRoleDao);
	}

	
	/**
	 * 根据管理员ID删除关联
	 * @param managerID
	 * @return
	 */
	@Override
	public Long deleteByManagerID(Long managerID) {
		// TODO Auto-generated method stub
		return managerRoleDao.deleteByManagerID(managerID);
	}
    
	/**
	 * 根据角色ID删除关联
	 * @param roelID
	 * @return
	 */
	@Override
	public Long deleteByRoleID(Long roleID) {
		// TODO Auto-generated method stub
		return managerRoleDao.deleteByRoleID(roleID);
	}
	
	
	
	
}
