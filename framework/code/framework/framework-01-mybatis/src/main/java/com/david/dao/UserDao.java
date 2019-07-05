package com.david.dao;

import com.david.domain.QueryVo;
import com.david.domain.User;

import java.util.List;

/**
 * @author david
 * @create 2019-06-26 10:46
 */
public interface UserDao {
    List<User> findAll();

    void saveUser(User user);

    void deleteUser(int i);

    User findUserById(int i);

    void updateUser(User user3);

    List<User> findUsersByName(String s);

    int findTotal();

    List<User> findUsersByVo(QueryVo vo);

    List<User> findUserByCondition(User user);

    List<User> findUserByIds(QueryVo vo);

    List<User> findAllUsersAndAccount();

    List<User> findAllUsersAndRoles();
}
