/**
 * 
 */
package com.meikai.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meikai.shop.dao.TSystemAreaDao;
import com.meikai.shop.entity.TSystemArea;
import com.meikai.shop.service.AreaService;

/**
 * 地理位置
 * @author meikai
 * @version 2017年9月23日 下午9:58:37
 */

@Service("areaServiceImpl")
public class AreaServiceImpl extends BaseServiceImpl<TSystemArea, Long> implements AreaService {

	
	@Autowired
	private TSystemAreaDao areaDao;
	
	@Autowired
	public void setBaseDao() {
		super.setBaseDao(areaDao);
	}
    
	/**
	 * 获得省份和直辖市
	 */
	@Override
	public List<TSystemArea> getRoot() {
		// TODO Auto-generated method stub
		return areaDao.getRoot();
	}
    /**
     * 获得下级地区
     */
	@Override
	public List<TSystemArea> getSon(Long parentId) {
		// TODO Auto-generated method stub
		return areaDao.getSon(parentId);
	}
	
	
}
