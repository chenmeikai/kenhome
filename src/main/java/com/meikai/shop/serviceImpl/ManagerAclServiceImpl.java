/**
 * 
 */
package com.meikai.shop.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meikai.shop.dao.TSystemManagerAclDao;
import com.meikai.shop.entity.TSystemManagerAcl;
import com.meikai.shop.service.ManagerAclService;

/**
 * 管理员-资源
 * @author meikai
 * @version 2017年9月23日 下午9:58:37
 */

@Service("managerAclServiceImpl")
public class ManagerAclServiceImpl extends BaseServiceImpl<TSystemManagerAcl, Long> implements ManagerAclService {

	
	@Autowired
	private TSystemManagerAclDao managerDao;
	
	@Autowired
	public void setBaseDao() {
		super.setBaseDao(managerDao);
	}
	
	
}
