package com.david.mybatis.session.defualt;

import com.david.mybatis.cfg.Configuration;
import com.david.mybatis.session.SqlSession;
import com.david.mybatis.session.SqlSessionFactory;

/**
 * @author david
 * @create 2019-06-18 9:51
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private Configuration cfg;
    public DefaultSqlSessionFactory(Configuration cfg) {
        this.cfg=cfg;
    }
    public SqlSession openSession() {
        return new DefualtSqlSession(cfg);
    }
}
