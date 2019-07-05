package com.david.test;

import com.david.dao.UserDao;
import com.david.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * mybatis入门，主要基于配置文件和注解的方式来实现
 * @author david
 * @create 2019-06-17 23:11
 */
public class Mybatis01Test {
    public static void main(String[] args) throws IOException {
        //1.读取配置文件
        InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
        //2.创建sqlsessionFactory对象
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = builder.build(is);
        //3.使用工厂创建SqlSession对象
        SqlSession session = sessionFactory.openSession();
        //4.使用SqlSession对象创建Dao接口的代理对象
        UserDao userDao = session.getMapper(UserDao.class);
        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        //6.释放资源
        session.close();
        is.close();
    }
}
