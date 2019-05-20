package com.david.web.jdbc.dbPool.Druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

/**
 * 数据库连接池实现技术，由阿里巴巴提供的
 * @author david
 * @create 2019-05-13 21:53
 */
public class D01Demo {
    public static void main(String[] args) throws Exception {
        //加载属性文件
        Properties pro=new Properties();
        pro.load(D01Demo.class.getClassLoader().getResourceAsStream("druid.properties"));
        //获取连接池
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        //获取连接池
        Connection conn = ds.getConnection();
        System.out.println(conn);
    }
}
