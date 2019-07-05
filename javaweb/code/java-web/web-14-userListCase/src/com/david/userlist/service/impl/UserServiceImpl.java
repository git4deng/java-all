package com.david.userlist.service.impl;

import com.david.userlist.dao.UserDao;
import com.david.userlist.dao.impl.UserDaoImpl;
import com.david.userlist.domain.PageBean;
import com.david.userlist.domain.User;
import com.david.userlist.service.UserService;

import java.util.List;
import java.util.Map;

/**
 * @author david
 * @create 2019-06-03 22:05
 */
public class UserServiceImpl implements UserService {
        UserDao userDao=new UserDaoImpl();
    @Override
    public User login(User user) {
        return userDao.loginByUsernameAndPssword(user.getUsername(),user.getPassword());
    }

    @Override
    public List<User> findAllUsers() {
        return userDao.findAllUser();
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void deleteUserById(int id) {
        userDao.deleteUserById(id);
    }

    @Override
    public User findUser(int id) {
        return userDao.findUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void delteUsersByIds(String[] ids) {
        for (int i = 0; i < ids.length; i++) {
            if(ids[i]!=null&& !"".equals(ids[i])){
                userDao.deleteUserById(Integer.valueOf(ids[i]));
            }
        }
    }

    @Override
    public PageBean<User> findUsesByPage(String _currentPage, String _rows, Map<String, String[]> condition) {

        PageBean<User> pb=new PageBean<User>();
        Integer currentPage = Integer.valueOf(_currentPage);
        Integer rows = Integer.valueOf(_rows);
        int totalCount = userDao.findTotalCount(condition);
        pb.setTotalCount(totalCount);
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        List<User> userList = userDao.findUserListByPage((currentPage - 1) * rows, rows,condition);
        pb.setList(userList);
        //总页数
        int n= totalCount%rows==0 ? totalCount/rows:(totalCount/rows)+1;
        pb.setTotalPage(n);
        return pb;
    }
}
