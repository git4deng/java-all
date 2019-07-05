package com.david.mybatis.session;

/**
 * @author david
 * @create 2019-06-18 9:34
 */
public interface SqlSessionFactory {
    SqlSession openSession();
}
