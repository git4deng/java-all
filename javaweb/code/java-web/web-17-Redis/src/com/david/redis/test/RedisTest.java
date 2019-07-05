package com.david.redis.test;

import com.david.redis.utils.JedisPoolUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * jedis测试类
 * @author david
 * @create 2019-06-13 11:16
 */
public class RedisTest {
    private Jedis jedis;
    @Before
    public void initJedis(){
        //构造器如果不传参数，默认情况下host是local host 端口是6379
        jedis=new Jedis("localhost",6379);
    }
    @After
    public void destory(){
        jedis.close();
    }
    /**
     * jedis 快速入门
     */
    @Test
    public void quickStartTest(){
        //存储数据
        jedis.set("username","david");
    }

    /**
     * 数据结构之字符串的测试
     */
    @Test
    public void stringTest(){
        //存储
        jedis.set("name","张三");
        //获取
        String name = jedis.get("name");
        System.out.println(name);
        //setex方法 设置存储过期时间的操作,超过过期时间将自动删除该键值对
        jedis.setex("checkCode",20,"3125");
    }
    /**
     * 数据结构之Hash的测试
     */
    @Test
    public void hashTest(){
        jedis.hset("myhash","name","david");
        jedis.hset("myhash","age","22");
        jedis.hset("myhash","gender","male");
        String name = jedis.hget("myhash", "name");
        System.out.println(name);
        //获取hashd的所有map中的数据
        Map<String, String> myhash = jedis.hgetAll("myhash");
        System.out.println(myhash);
    }
    /**
     * 数据结构之List的测试
     */
    @Test
    public void listTest(){
        //存储
        jedis.lpush("numbers","1","2","3","4");//从左边存
        jedis.rpush("numbers","1","2","3","4");//从右边存
        //范围获取,-1代表获取所有
        List<String> numbers = jedis.lrange("numbers", 0, -1);

        System.out.println(numbers);//[4, 3, 2, 1, 1, 2, 3, 4]

        //弹出 分lpop和rpop 左边弹出和右边弹出
        String n1 = jedis.lpop("numbers");
        System.out.println(n1);
        System.out.println(numbers);
    }

    /**
     * 数据结构之set的测试
     *
     */
    @Test
    public void setTest(){
        //存储
        jedis.sadd("myset","1","2","3","4");
        Set<String> myset = jedis.smembers("myset");
        System.out.println(myset);
    }
    /**
     * 数据结构之SortedSet的测试
     *
     */
    @Test
    public void sortedSetTest(){
        jedis.zadd("sortedSet", 20, "20");
        jedis.zadd("sortedSet", 10, "10");
        jedis.zadd("sortedSet", 30, "30");

        Set<String> sortedSet = jedis.zrange("sortedSet", 0, -1);
        System.out.println(sortedSet);
    }

    /**
     * Jedis连接池，采用默认配置的方式
     */
    @Test
    public void jedisPoolTest(){
        //创建连接池对象
        JedisPool jp=new JedisPool();
        //获取连接
        Jedis jd = jp.getResource();
        String username = jd.get("username");
        System.out.println(username);
        //不再是关闭连接了，而是归还连接
        jd.close();
    }
    /**
     * Jedis连接池，使用配置类的方式
     */
    @Test
    public void jedisPoolTest2(){
        //创建一个配置对象
        JedisPoolConfig config=new JedisPoolConfig();
        config.setMaxTotal(50);//最大连接数
        config.setMaxIdle(10);//最大空闲连接
        //创建连接池对象
        JedisPool jp=new JedisPool(config,"localhost",6379);
        //获取连接
        Jedis jd = jp.getResource();
        String username = jd.get("username");
        System.out.println(username);
        //不再是关闭连接了，而是归还连接
        jd.close();
    }

    /**
     * jedis连接池工具类测试
     */
    @Test
    public void testPoolUtils(){
        Jedis jedis = JedisPoolUtils.getJedis();
        String username = jedis.get("username");
        System.out.println(username);
        jedis.close();
    }


}
