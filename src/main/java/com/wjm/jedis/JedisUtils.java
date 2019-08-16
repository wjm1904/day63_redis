package com.wjm.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtils {
    //jedis连接池
    private static JedisPool jedisPool = null;

    static{
        //连接池配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        //最多连多少个jedis对象
        config.setMaxTotal(500);
        //最多有多少空闲的jedis对象
        config.setMaxIdle(20);
        //最大等待时间
        config.setMaxWaitMillis(5000);
        //检查连接的有效性
        config.setTestOnBorrow(true);

        //第二个参数：redis服务器的IP
        //第三个参数：端口
        //第四个参数：连接服务器的超时时间
        //第五个参数：密码
        jedisPool = new JedisPool(config, "10.8.161.31", 6379, 1000);
    }

    //通过连接池获取jedis对象
    public static Jedis getJedis() {
        Jedis jedis = jedisPool.getResource();
        return jedis;
    }

    //jedis对象放回连接池
    public static void closeJedis(Jedis jedis) {
        jedis.close();
    }
}
