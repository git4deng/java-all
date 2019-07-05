package com.david.test;

import com.david.dao.UserDao;
import com.david.domain.User;
//import org.apache.ibatis.io.Resources;
import com.david.mybatis.io.Resources;
import com.david.mybatis.session.SqlSession;
import com.david.mybatis.session.SqlSessionFactory;
import com.david.mybatis.session.SqlSessionFactoryBuilder;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * mybatis原理之手动实现mybatis简单代码
 * @author david
 * @create 2019-06-17 23:11
 */
public class Mybatis01Test {
    public static void main(String[] args) throws IOException {
        //1.读取配置文件,使用类加载器获取输入流
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //2.创建sqlsessionFactory对象
        SqlSessionFactoryBuilder bd=new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = bd.build(inputStream);
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
        inputStream.close();
    }
}
