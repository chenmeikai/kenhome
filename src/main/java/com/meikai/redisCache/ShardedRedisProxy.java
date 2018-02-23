package com.meikai.redisCache;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * 本实现为分片Redis缓存服务代理
 * 
 * @author kenny
 * @version 创建时间： 2011-11-10
 */
public class ShardedRedisProxy implements IRedisProxy {

    /**
     * 日志
     */
    protected Log log = LogFactory.getLog(this.getClass());

    /**
     * 缓存连接池
     */
    private ShardedJedisPool shardedJedisPool;

    @Override
    public Long append(String key, String value) {
        ShardedJedis shardedJedis = null;
        Long ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.append(key, value);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public Long decr(String key) {
        ShardedJedis shardedJedis = null;
        Long ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.decr(key);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public Long decrBy(String key, long integer) {
        ShardedJedis shardedJedis = null;
        Long ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.decrBy(key, integer);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public Long del(String key) {
        ShardedJedis shardedJedis = null;
        Long ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.del(key);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public Boolean exists(String key) {
        ShardedJedis shardedJedis = null;
        Boolean ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.exists(key);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public Long expire(String key, int seconds) {
        ShardedJedis shardedJedis = null;
        Long ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.expire(key, seconds);
            return ret;
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public Long expireAt(String key, long unixTime) {
        ShardedJedis shardedJedis = null;
        Long ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.expireAt(key, unixTime);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public String get(String key) {
        ShardedJedis shardedJedis = null;
        String ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.get(key);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public String getSet(String key, String value) {
        ShardedJedis shardedJedis = null;
        String ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.getSet(key, value);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public String getrange(String key, long startOffset, long endOffset) {
        ShardedJedis shardedJedis = null;
        String ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.getrange(key, startOffset, endOffset);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public Long hdel(String key, String field) {
        ShardedJedis shardedJedis = null;
        Long ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.hdel(key, field);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public Boolean hexists(String key, String field) {
        ShardedJedis shardedJedis = null;
        Boolean ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.hexists(key, field);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public String hget(String key, String field) {
        ShardedJedis shardedJedis = null;
        String ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.hget(key, field);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public Map<String, String> hgetAll(String key) {
        ShardedJedis shardedJedis = null;
        Map<String, String> ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.hgetAll(key);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public Long hincrBy(String key, String field, long value) {
        ShardedJedis shardedJedis = null;
        Long ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.hincrBy(key, field, value);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public Set<String> hkeys(String key) {
        ShardedJedis shardedJedis = null;
        Set<String> ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.hkeys(key);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public Long hlen(String key) {
        ShardedJedis shardedJedis = null;
        Long ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.hlen(key);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public List<String> hmget(String key, String... fields) {
        ShardedJedis shardedJedis = null;
        List<String> ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.hmget(key, fields);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public String hmset(String key, Map<String, String> hash) {
        ShardedJedis shardedJedis = null;
        String ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.hmset(key, hash);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public Long hset(String key, String field, String value) {
        ShardedJedis shardedJedis = null;
        Long ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.hset(key, field, value);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public Long hsetnx(String key, String field, String value) {
        ShardedJedis shardedJedis = null;
        Long ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.hsetnx(key, field, value);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public List<String> hvals(String key) {
        ShardedJedis shardedJedis = null;
        List<String> ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.hvals(key);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public Long incr(String key) {
        ShardedJedis shardedJedis = null;
        Long ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.incr(key);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public Long incrBy(String key, long integer) {
        ShardedJedis shardedJedis = null;
        Long ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.incrBy(key, integer);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public String lindex(String key, long index) {
        ShardedJedis shardedJedis = null;
        String ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.lindex(key, index);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public Long llen(String key) {
        ShardedJedis shardedJedis = null;
        Long ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.llen(key);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public String lpop(String key) {
        ShardedJedis shardedJedis = null;
        String ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.lpop(key);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public Long lpush(String key, String string) {
        ShardedJedis shardedJedis = null;
        Long ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.lpush(key, string);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public List<String> lrange(String key, long start, long end) {
        ShardedJedis shardedJedis = null;
        List<String> ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.lrange(key, start, end);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public Long lrem(String key, long count, String value) {
        ShardedJedis shardedJedis = null;
        Long ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.lrem(key, count, value);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public String lset(String key, long index, String value) {
        ShardedJedis shardedJedis = null;
        String ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.lset(key, index, value);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public String ltrim(String key, long start, long end) {
        ShardedJedis shardedJedis = null;
        String ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.ltrim(key, start, end);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public String rpop(String key) {
        ShardedJedis shardedJedis = null;
        String ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.rpop(key);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public Long rpush(String key, String string) {
        ShardedJedis shardedJedis = null;
        Long ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.rpush(key, string);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public Long sadd(String key, String member) {
        ShardedJedis shardedJedis = null;
        Long ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.sadd(key, member);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public Long scard(String key) {
        ShardedJedis shardedJedis = null;
        Long ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.scard(key);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public String set(String key, String value) {
        ShardedJedis shardedJedis = null;
        String ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.set(key, value);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public String setex(String key, int seconds, String value) {
        ShardedJedis shardedJedis = null;
        String ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.setex(key, seconds, value);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public Long setnx(String key, String value) {
        ShardedJedis shardedJedis = null;
        Long ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.setnx(key, value);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public long setrange(String key, long offset, String value) {
        ShardedJedis shardedJedis = null;
        long ret = 0;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.setrange(key, offset, value);
            return ret;
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public Boolean sismember(String key, String member) {
        ShardedJedis shardedJedis = null;
        Boolean ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.sismember(key, member);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public Set<String> smembers(String key) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            Set<String> ret = shardedJedis.smembers(key);
            return ret;
        } catch (Exception e) {
            log.error(this, e);
            return null;
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
    }

    @Override
    public List<String> sort(String key) {
        ShardedJedis shardedJedis = null;
        List<String> ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.sort(key);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public String spop(String key) {
        ShardedJedis shardedJedis = null;
        String ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.spop(key);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public String srandmember(String key) {
        ShardedJedis shardedJedis = null;
        String ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.srandmember(key);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public Long srem(String key, String member) {
        ShardedJedis shardedJedis = null;
        Long ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.srem(key, member);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public String substr(String key, int start, int end) {
        ShardedJedis shardedJedis = null;
        String ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.substr(key, start, end);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public Long ttl(String key) {
        ShardedJedis shardedJedis = null;
        Long ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.ttl(key);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public String type(String key) {
        ShardedJedis shardedJedis = null;
        String ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.type(key);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public Long zadd(String key, double score, String member) {
        ShardedJedis shardedJedis = null;
        Long ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.zadd(key, score, member);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public Long zcard(String key) {
        ShardedJedis shardedJedis = null;
        Long ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.zcard(key);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public Long zcount(String key, double min, double max) {
        ShardedJedis shardedJedis = null;
        Long ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.zcount(key, min, max);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public Double zincrby(String key, double score, String member) {
        ShardedJedis shardedJedis = null;
        Double ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.zincrby(key, score, member);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public Set<String> zrange(String key, int start, int end) {
        ShardedJedis shardedJedis = null;
        Set<String> ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.zrange(key, start, end);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public Set<String> zrangeByScore(String key, double min, double max) {
        ShardedJedis shardedJedis = null;
        Set<String> ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.zrangeByScore(key, min, max);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public Set<String> zrangeByScore(String key, double min, double max, int offset, int count) {
        ShardedJedis shardedJedis = null;
        Set<String> ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.zrangeByScore(key, min, max, offset, count);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public Long zrank(String key, String member) {
        ShardedJedis shardedJedis = null;
        Long ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.zrank(key, member);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public Long zrem(String key, String member) {
        ShardedJedis shardedJedis = null;
        Long ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.zrem(key, member);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public Long zremrangeByRank(String key, int start, int end) {
        ShardedJedis shardedJedis = null;
        Long ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.zremrangeByRank(key, start, end);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public Long zremrangeByScore(String key, double start, double end) {
        ShardedJedis shardedJedis = null;
        Long ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.zremrangeByScore(key, start, end);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public Set<String> zrevrange(String key, int start, int end) {
        ShardedJedis shardedJedis = null;
        Set<String> ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.zrevrange(key, start, end);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public Set<String> zrevrangeByScore(String key, double max, double min) {
        ShardedJedis shardedJedis = null;
        Set<String> ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.zrevrangeByScore(key, max, min);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public Set<String> zrevrangeByScore(String key, double max, double min, int offset, int count) {
        ShardedJedis shardedJedis = null;
        Set<String> ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.zrevrangeByScore(key, max, min, offset, count);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public Long zrevrank(String key, String member) {
        ShardedJedis shardedJedis = null;
        Long ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.zrevrank(key, member);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    @Override
    public Double zscore(String key, String member) {
        ShardedJedis shardedJedis = null;
        Double ret = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            ret = shardedJedis.zscore(key, member);
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }

    /**
     * @return the shardedJedisPool
     */
    public ShardedJedisPool getShardedJedisPool() {
        return shardedJedisPool;
    }

    /**
     * @param shardedJedisPool the shardedJedisPool to set
     */
    public void setShardedJedisPool(ShardedJedisPool shardedJedisPool) {
        this.shardedJedisPool = shardedJedisPool;
    }
    /** 
     * 删除模糊匹配的key 
     * @param likeKey 模糊匹配的key 
     * @return 删除成功的条数 
     */  
    @Override
    public Long delKeysLike(String likeKey) {
        ShardedJedis shardedJedis = null;
        long ret = 0;
        try {
            shardedJedis = shardedJedisPool.getResource();
            Collection<Jedis> jedisC = shardedJedis.getAllShards();  
            Iterator<Jedis> iter = jedisC.iterator();  
            while (iter.hasNext()) {  
                Jedis _jedis = iter.next();  
                Set<String> keys = _jedis.keys(likeKey); 
                if(keys.size()>0){
//                	for (String string : keys) {
//                		System.out.println("stringkey="+string);
//                        System.out.println("匹配删除key.length="+keys.size()+",toarray="+keys.toArray(new String[keys.size()]));
//                       shardedJedis.del(string);
//
//					}
                	ret += _jedis.del(keys.toArray(new String[keys.size()]));  
                }
            }  
        } catch (Exception e) {
            log.error(this, e);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return ret;
    }  
  

}
