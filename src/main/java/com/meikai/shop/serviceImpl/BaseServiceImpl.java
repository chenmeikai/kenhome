/**
 * 
 */
package com.meikai.shop.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.meikai.pageHleper.EntityPage;
import com.meikai.shop.dao.BaseDao;
import com.meikai.shop.service.BaseService;

/**
 * 基类
 * @author Administrator
 * @version 2017年9月20日 上午10:21:03
 */
public class BaseServiceImpl<Entity,PK> implements BaseService<Entity, PK> {

	
	@Autowired
	private BaseDao<Entity, PK> baseDao ;
	
	
	
	public void setBaseDao(BaseDao<Entity, PK> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public Long saveAddEntity(Entity entity) {
		// TODO Auto-generated method stub
		return (long) baseDao.insertSelective(entity);
	}

	@Override
	public Long updateEntity(Entity entity) {
		// TODO Auto-generated method stub
		return (long) baseDao.updateByPrimaryKeySelective(entity);
	}

	@Override
	public Long deleteEntity(Entity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public Long delete(PK pk) {
		// TODO Auto-generated method stub
		return (long) baseDao.deleteByPrimaryKey(pk);
	}

	@Override
	public Long deleteSome(List<Long> ids) {
		// TODO Auto-generated method stub
		return (long) baseDao.deleteSome(ids);
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return (long) baseDao.countAll();
	}
	
	
	@Override
	public Long countByparames(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return (long) baseDao.countByParams(paramMap);
	}

	@Override
	public Entity getByID(PK pk) {
		// TODO Auto-generated method stub
		return baseDao.selectByPrimaryKey(pk);
	}

	@Override
	public List<Entity> getAll() {
		// TODO Auto-generated method stub
		return baseDao.selectAll();
	}


	@Override
	public List<Entity> getByparamList(String propertyName, Object propertyValue) {
		// TODO Auto-generated method stub
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put(propertyName, propertyValue);
		return  baseDao.selectByParams(paramMap);
	}

	@Override
	public List<Entity> getByparamsList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return baseDao.selectByParams(params);
	}
    
	/**
	 * 分页
	 */
	@Override
	public EntityPage<Entity> getByPage(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(currentPage, pageSize);
        List<Entity> entitys = baseDao.selectAll();
        EntityPage<Entity> pageInfo = new EntityPage<Entity>(entitys);
        return pageInfo;
	}
    
	
	/**
	 * 根据参数分页
	 */
	@Override
	public EntityPage<Entity> getByParamesAndPage(Map<String, Object> params, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(currentPage, pageSize);
        List<Entity> entitys = baseDao.selectByParams(params);
        EntityPage<Entity> pageInfo = new EntityPage<Entity>(entitys);
        return pageInfo;
	}

	
	/**
	  * 根据唯一的编码查询数据
	  */ 
	@Override
	public Entity getByUniqueCode(String code) {
		// TODO Auto-generated method stub
		return baseDao.getByUniqueCode(code);
	}
    
	/**
	  * 根据唯一的名字查询数据
	  */
	@Override
	public Entity getByUniqueName(String name) {
		// TODO Auto-generated method stub
		return baseDao.getByUniqueName(name);
	}
    
	/**
	  * 根据唯一的编码删除数据
	  */ 
	@Override
	public Long deleteByUniqueCode(Long code) {
		// TODO Auto-generated method stub
		return baseDao.deleteByUniqueCode(code);
	}
    
	/**
	 * 根据唯一的名字删除数据
	 */
	@Override
	public Long deleteByUniqueName(String name) {
		// TODO Auto-generated method stub
		return baseDao.deleteByUniqueName(name);
	}
    
	/**
	  * 随机获取num条数据
	  */
	@Override
	public List<Entity> getByRandom(Long num) {
		// TODO Auto-generated method stub
		return baseDao.selectByRandom(num);
	}

	

	
	

	

}
