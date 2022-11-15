package com.urain.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

/**
 * @Author: urain
 * @Date: 2022/5/1 11:09
 * @Description:
 * @Version: 1.0
 */

public class JedisTest {


    @Test
    public void testConn() {
        Jedis jedis = new Jedis("192.168.188.202", 6379);
        String ping = jedis.ping();
        System.out.println(ping);

    }


    // 操作key String
    @Test
    public void demo1() {
        Jedis jedis = new Jedis("192.168.188.202", 6379);
        jedis.select(0);
        Set<String> keys = jedis.keys("*");
        keys.forEach(System.out::println);
        // jedis.flushDB();
        // 添加数据
        jedis.set("name", "lucy");

        // 获取数据
        /*System.out.println(jedis.get("name"));
        System.out.println(jedis.ttl("name"));
        System.out.println(jedis.exists("name"));*/

        // 设置多个key-value
        jedis.mset("k1", "v1", "k2", "v2");
        // 获取多个value
        List<String> values = jedis.mget("k1", "k2");
        values.forEach(System.out::println);
        jedis.close();
    }

    // 操作list
    @Test
    public void demo2() {
        Jedis jedis = new Jedis("192.168.188.202", 6379);
        jedis.lpush("key1", "luck", "mary", "jack");

        List<String> values = jedis.lrange("key1", 0, -1);
        System.out.println(values);
        jedis.close();
    }


    // 操作set
    @Test
    public void demo3() {
        Jedis jedis = new Jedis("192.168.188.202", 6379);
        jedis.sadd("names", "lucy", "jack");
        Set<String> names = jedis.smembers("names");
        System.out.println(names);
        jedis.close();
    }

    // 操作hash
    @Test
    public void demo4() {
        Jedis jedis = new Jedis("192.168.188.202", 6379);
        jedis.hset("users", "age", "20");
        String hget = jedis.hget("users", "age");
        System.out.println(hget);
        jedis.close();
    }

    // 操作zset
    @Test
    public void demo5() {
        Jedis jedis = new Jedis("192.168.188.202", 6379);
        jedis.zadd("china", 100d, "shanghai");
        List<String> china = jedis.zrange("china", 0, -1);
        System.out.println(china);
        jedis.close();
    }


}
