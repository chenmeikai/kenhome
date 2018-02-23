/**
 * 
 */
package com.meikai.redisCache;

/**
 * Mybatis二级缓存实现
 * @author meikai
 * @version 2017年11月26日 下午9:23:54
 */
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.meikai.util.SerializeUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
 
public class MybatisRedisCache implements Cache {
	
    private static Logger logger = LoggerFactory.getLogger(MybatisRedisCache.class);
 
    private Jedis redisClient = createReids();
 
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
 
    private String id;
 
    public MybatisRedisCache(final String id) {
        if (id == null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>MybatisRedisCache:id=" + id);
        this.id = id;
    }
 
    @Override
    public String getId() {
        return this.id;
    }
 
    @Override
    public int getSize() {
 
        return Integer.valueOf(redisClient.dbSize().toString());
    }
 
    @Override
    public void putObject(Object key, Object value) {
        logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>putObject:" + key + "=" + value);
        redisClient.set(SerializeUtil.serialize(key.toString()), SerializeUtil.serialize(value));
    }
 
    @Override
    public Object getObject(Object key) {
        Object value = SerializeUtil.unserialize(redisClient.get(SerializeUtil.serialize(key.toString())));
        logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>getObject:" + key + "=" + value);
        return value;
    }
 
    @Override
    public Object removeObject(Object key) {
        return redisClient.expire(SerializeUtil.serialize(key.toString()), 0);
    }
 
    @Override
    public void clear() {
        redisClient.flushDB();
    }
 
    @Override
    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }
 
    protected static Jedis createReids() {
        JedisPool pool = new JedisPool("127.0.0.1", 6379);
        return pool.getResource();
    }
}   
