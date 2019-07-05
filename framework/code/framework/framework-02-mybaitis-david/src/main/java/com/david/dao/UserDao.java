package com.david.dao;

import com.david.domain.User;
import com.david.mybatis.annotations.Select;
//import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户的持久层接口
 * @author david
 * @create 2019-06-17 22:48
 */
public interface UserDao {
    /**
     * 查询所有操作
     * @return
     */
    @Select("select * from user")//使用注解的方式
    List<User> findAll();
}
