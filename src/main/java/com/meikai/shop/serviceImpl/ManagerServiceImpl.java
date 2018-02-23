/**
 * 
 */
package com.meikai.shop.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meikai.shop.dao.TSystemManagerDao;
import com.meikai.shop.entity.TSystemManager;
import com.meikai.shop.service.ManagerService;

/**
 * 管理员
 * @author meikai
 * @version 2017年9月23日 下午9:58:37
 */

@Service("managerServiceImpl")
public class ManagerServiceImpl extends BaseServiceImpl<TSystemManager, Long> implements ManagerService {

	
	@Autowired
	private TSystemManagerDao managerDao;
	
	@Autowired
	public void setBaseDao() {
		super.setBaseDao(managerDao);
	}
    
	
	
	/**
	 * 根据ID获得管理员（附加角色名和权限）
	 */
	@Override
	public TSystemManager getRolesAndAclsByID(Long id) {
		// TODO Auto-generated method stub
		return managerDao.getRolesAndAclsByID(id);
	}
	
	
	@Override
	/**
	 * 根据管理员名获得管理员（附加角色名和权限）
	 */
	public TSystemManager getRolesAndAclsByName(String managerName) {
		
		return managerDao.getRolesAndAclsByName(managerName);
	}


    /**
     * 根据管理员名模糊查询出管理员
     */
	@Override
	public List<TSystemManager> getSomeManagersByName(String managerName) {
		// TODO Auto-generated method stub
		return managerDao.getSomeManagersByName(managerName);
	}

    
	
	

	
	
	
}
