/**
 * 
 */
package com.meikai.shop.dao;

import java.util.List;
import java.util.Map;



/**
 * @author meikai
 * @version 2017年9月17日 下午10:15:17
 * 通用Dao
 */
public interface BaseDao<Entity,PK> {
	
    
	/**
	 * 统计记录数
	 * @return
	 */
	Long countAll();
	
	/**
	 * 根据多参数统计记录数
	 * @param paramMap
	 * @return
	 */
	Long	countByParams(Map<String, Object> paramMap);
    
    /**
     * 新增实体记录，插入前判断值是否为null，为空不插入，则使用默认值
     * @param entity
     * @return
     */
    Long insertSelective(Entity entity);
    
    /**
     * 根据主键ID删除记录
     * @param pk
     * @return
     */
    Long deleteByPrimaryKey(PK pk);
  	
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
  	 * 删除多条记录
  	 * @param ids
  	 * @return
  	 */
  	Long deleteSome(List<Long> ids);
  	
    /**
     * 更新实体记录，插入前判断值是否为null，为空不更新，则使用原记录
     * @param entity
     * @return
     */
    Long updateByPrimaryKeySelective(Entity entity);
    
    /**
	  * 根据唯一的编码查询数据
	  */
	 Entity getByUniqueCode (String code);
	 
	 
	 /**
	  * 根据唯一的名字查询数据
	  */
    Entity getByUniqueName(String name);
    
    /**
     * 根据主键ID查询
     * @param pk
     * @return
     */
    Entity selectByPrimaryKey(PK pk);
    
    /**
     * 根据参数查询记录
     * @param params
     * @return
     */
    List<Entity> selectByParams(Map<String, Object> params);
    
    /**
     * 查询所有记录
     * @return
     */
    List<Entity> selectAll();
    
    /**
     * 随机获取num条数据
     */
    List<Entity> selectByRandom(Long num);
    

}
