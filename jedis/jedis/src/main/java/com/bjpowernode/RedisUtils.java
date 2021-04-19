package com.bjpowernode;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author feng
 * @date 2021/4/17
 * @Description
 */
public class RedisUtils {
    private static JedisPool jedisPool = null;

    public static JedisPool open(String ip, int port) {
        if (jedisPool == null) {

            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            jedisPoolConfig.setMaxTotal(10);
            jedisPoolConfig.setMaxIdle(3);

            jedisPoolConfig.setTestOnBorrow(true);

            jedisPool = new JedisPool(jedisPoolConfig,ip,port);
        }
        return jedisPool;
    }

    public static void close(){
        if (jedisPool != null) {
            jedisPool.close();
        }
    }
}
