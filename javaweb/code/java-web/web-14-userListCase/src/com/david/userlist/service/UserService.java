package com.david.userlist.service;

import com.david.userlist.domain.PageBean;
import com.david.userlist.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @author david
 * @create 2019-06-03 22:04
 */
public interface UserService {
    public User login(User user);
    public List<User> findAllUsers();
    public void addUser(User user);
    public void deleteUserById(int id);
    public User findUser(int id);
    public void updateUser(User user);
    public void delteUsersByIds(String[] ids);
    public PageBean<User> findUsesByPage(String currentPage, String rows, Map<String, String[]> condition);
}
