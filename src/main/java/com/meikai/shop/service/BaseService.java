/**
 * 
 */
package com.meikai.shop.service;

import java.util.List;
import java.util.Map;

import com.meikai.pageHleper.EntityPage;


/**
 * @author Administrator
 * @version 2017年9月18日 下午5:41:48
 * 基类实现接口
 * 
 */
public interface BaseService<Entity, PK> {
	
	/**
	 * 保存
	 */
	 Long saveAddEntity(Entity entity);

	/**
	 * 更新
	 */
	 Long updateEntity(Entity entity);

	/**
	 * 删除
	 */
	 Long deleteEntity(Entity entity);
	 
	 /**
  	 * 根据唯一的编码删除记录
  	 * @param code
  	 * @return
  	 */
  	Long deleteByUniqueCode(Long code);
  	
  	/**
  	 * 根据唯一的名字删除记录
  	 * @param name
  	 * @return
  	 */
  	Long deleteByUniqueName(String name);


	/**
	 * 根据主键删除
	 */
	 Long delete(PK pk);

	/**
	 * 删除列表
	 */
	 Long deleteSome(List<Long> ids);

	/**
	 * 查询实体对象数量
	 */
	 Long count();

	/**
	 * 根据条件查询实体对象数量
	 */
	 Long countByparames(Map<String, Object> paramMap);

	/**
	 * 根据主键查询数据
	 */
	 Entity getByID(PK pk);
	 
	 
	 /**
	  * 根据唯一的编码查询数据
	  */
	 Entity getByUniqueCode (String No);
	 
	 
	 /**
	  * 根据唯一的名字查询数据
	  */
     Entity getByUniqueName(String name);
	 
	/**
	 * 查询所有数据
	 */
	 List<Entity> getAll();

	

	/**
	 * 根据属性名和属性值获取实体对象集合.
	 */
	 List<Entity> getByparamList(String propertyName, Object propertyValue);

	 
	/**
	 * 根据条件查询数据
	 */
	 List<Entity> getByparamsList(Map<String, Object> params);

	 /**
	  * 分页查询
	  */
	 public EntityPage<Entity> getByPage(int currentPage, int pageSize);
	 
	 /**
	  * 根据参数分页查询
	  * @param parames
	  * @param currentPage
	  * @param pageSize
	  * @return
	  */
	 public EntityPage<Entity> getByParamesAndPage(Map<String, Object> params,int currentPage, int pageSize);
	 
	 
	 /**
	  * 随机获取num条数据
	  */
	 public List<Entity> getByRandom(Long num);

}
