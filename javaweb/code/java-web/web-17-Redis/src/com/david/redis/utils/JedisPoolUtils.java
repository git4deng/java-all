package com.david.redis.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * jedis pool工具包
 * @author david
 * @create 2019-06-13 12:44
 */
public class JedisPoolUtils {
    private static JedisPool jedisPool;

    static {
        InputStream is = JedisPoolUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
        Properties prop=new Properties();
        try {
            prop.load(is);
            String host = prop.getProperty("host");
            String port = prop.getProperty("port");
            String maxTotal = prop.getProperty("maxTotal");
            String maxIdle = prop.getProperty("maxIdle");
            JedisPoolConfig config=new JedisPoolConfig();
            config.setMaxTotal(Integer.valueOf(maxTotal));
            config.setMaxIdle(Integer.valueOf(maxIdle));
            jedisPool=new JedisPool(config,host,Integer.valueOf(port));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取Jedis连接对象
     * @return
     */
    public static Jedis getJedis(){
        return jedisPool.getResource();
    }
}
