package com.david.listCase.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 使用druid连接池技术
 * @author david
 * @create 2019-05-26 21:49
 */
public class JDBCUtils {
    private static DataSource ds;
    static {
        //1.加载数据库配置文件
        Properties p=new Properties();
        try {
            p.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //2.初始连接池对象
        try {
            ds=DruidDataSourceFactory.createDataSource(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource(){
        return ds;
    }
    /**
     * 获取连接对象
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }


}
