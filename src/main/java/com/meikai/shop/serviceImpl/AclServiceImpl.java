/**
 * 
 */
package com.meikai.shop.serviceImpl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meikai.shop.dao.TSystemAclDao;
import com.meikai.shop.entity.TSystemAcl;
import com.meikai.shop.service.AclService;

/**
 * 资源
 * @author meikai
 * @version 2017年9月23日 下午9:58:37
 */

@Service("aclServiceImpl")
public class AclServiceImpl extends BaseServiceImpl<TSystemAcl, Long> implements AclService {

	
	@Autowired
	private TSystemAclDao aclDao;
	
	@Autowired
	public void setBaseDao() {
		super.setBaseDao(aclDao);
	}

	
	/**
	 * 获得子资源
	 */
	@Override
	public List<TSystemAcl> getChildrenAcls(Long parent_id) {
		// TODO Auto-generated method stub
		return aclDao.getChildrenAcls(parent_id);
	}
	

	/**
	 * 获得某级资源
	 */
	@Override
	public List<TSystemAcl> getGradeAcls(Integer acl_grade) {
		// TODO Auto-generated method stub
		return aclDao.getGradeAcls(acl_grade);
	}

    
	/**
	 * 获得根资源至末级资源
	 */
	@Override
	public List<TSystemAcl> getRootandChildrenAcls() {
		// TODO Auto-generated method stub
		return aclDao.getRootandChildrenAcls();
	}
	
	
}
