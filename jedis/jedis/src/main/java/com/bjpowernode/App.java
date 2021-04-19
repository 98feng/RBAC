package com.bjpowernode;

import redis.clients.jedis.Jedis;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.flushAll();
        jedis.set("str1", "123");
        jedis.set("str2", "456");
        jedis.set("str3", "789");
        System.out.println(jedis.get("str2"));
        RedisUtils.close();
    }
}
