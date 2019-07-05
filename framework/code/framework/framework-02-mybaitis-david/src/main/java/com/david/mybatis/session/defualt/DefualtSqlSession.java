package com.david.mybatis.session.defualt;

import com.david.dao.UserDao;
import com.david.mybatis.cfg.Configuration;
import com.david.mybatis.session.MapperProxy;
import com.david.mybatis.session.SqlSession;
import com.david.mybatis.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author david
 * @create 2019-06-18 9:54
 */
public class DefualtSqlSession implements SqlSession {

    private Configuration cfg;
    private Connection connection;
    public DefualtSqlSession(Configuration cfg) {
        this.cfg=cfg;
        connection= DataSourceUtil.getConnection(cfg);
    }

    public <T> T getMapper(Class<UserDao> daoInterFaceClass) {
        return (T) Proxy.newProxyInstance(daoInterFaceClass.getClassLoader(),new Class[]{daoInterFaceClass},new MapperProxy(cfg.getMappers(),connection));
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
