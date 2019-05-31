package com.david.test;

import com.david.dao.UserDao;
import com.david.domain.User;
import org.junit.Before;
import org.junit.Test;

/**
 * @author david
 * @create 2019-05-26 22:05
 */
public class UserDaoTest {
    private UserDao dao;

    @Before
    public void init(){
        dao=new UserDao();
    }

    @Test
    public void testLogin(){
        User loginUser=new User();
        loginUser.setUsername("david");
        loginUser.setPassword("123456");

        User user = dao.login(loginUser);
        System.out.println(user);
    }
}
