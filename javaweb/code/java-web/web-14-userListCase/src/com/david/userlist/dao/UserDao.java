package com.david.userlist.dao;

import com.david.userlist.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @author david
 * @create 2019-06-03 22:01
 */
public interface UserDao {
    public User loginByUsernameAndPssword(String username,String password);
    public List<User> findAllUser();
    public void addUser(User user);
    public void deleteUserById(int id);
    public User findUserById(int id);
    public void updateUser(User user);
    public int findTotalCount(Map<String, String[]> condition);
    public List<User> findUserListByPage(int start, int rows, Map<String, String[]> condition);
}
