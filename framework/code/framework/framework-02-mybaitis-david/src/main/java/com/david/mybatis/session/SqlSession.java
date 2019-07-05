package com.david.mybatis.session;

import com.david.dao.UserDao; /**
 * @author david
 * @create 2019-06-18 9:35
 */
public interface SqlSession {
    <T> T getMapper(Class<UserDao> userDaoClass);
    void close();
}
