package com.david.userlist.test;

import com.david.userlist.dao.UserDao;
import com.david.userlist.dao.impl.UserDaoImpl;
import com.david.userlist.domain.User;
import com.david.userlist.utils.JdbcUtils;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author david
 * @create 2019-06-03 22:12
 */
public class UserDaoTest {
    private UserDao userDao;
    @Before
    public void init(){
        userDao=new UserDaoImpl();
    }
    @Test
    public void testDao(){
        try {
            Connection connection = JdbcUtils.getConnection();
            System.out.println(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testLoginByUsernameAndPssword(){
        User user = userDao.loginByUsernameAndPssword("david", "123456");
        System.out.println(user);
    }



}
