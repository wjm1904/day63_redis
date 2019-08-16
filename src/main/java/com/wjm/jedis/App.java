package com.wjm.jedis;

import redis.clients.jedis.Jedis;

public class App {

    public static void main(String[] args) {

//        //创建jedis对象
//        Jedis jedis = new Jedis("10.8.161.31", 6379);
//        //如果没有在配置文件中设置密码，不用使用该方法
////        jedis.auth("密码");
//
//        //根据key值获取字符串类型内容
////        String name = jedis.get("name");
////        System.out.println(name);
//
////        jedis.set("hobby", "敲代码");
////        System.out.println(jedis.get("hobby"));
//
////        //关闭
//////        jedis.close();

        jedisPoolTest();

    }

    public static void jedisPoolTest(){
        Jedis jedis = JedisUtils.getJedis();
        System.out.println(jedis.get("name"));

        System.out.println("hahahhahaha");
        JedisUtils.closeJedis(jedis);
    }


}
