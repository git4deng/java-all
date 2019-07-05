package com.david.listCase.test;

import com.david.listCase.dao.UserDao;
import com.david.listCase.dao.impl.UserDaoImpl;
import com.david.listCase.domain.User;
import org.junit.Before;
import org.junit.Test;

/**
 * @author david
 * @create 2019-06-02 11:38
 */
public class UserDaoTest {

    private UserDao userDao;
    @Before
    public void init(){
        userDao=new UserDaoImpl();
    }
    @Test
    public void loginTest(){
        User login = userDao.findUserByUsernameAndPassword("david","123456");
        System.out.println(login);

    }






}
