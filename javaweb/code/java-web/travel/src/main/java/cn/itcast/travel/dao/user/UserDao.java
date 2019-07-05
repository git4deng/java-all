package cn.itcast.travel.dao.user;

import cn.itcast.travel.domain.User;

/**
 * @author david
 * @create 2019-06-13 23:10
 */
public interface UserDao {
    /**
     * 通过用户名查询用户
     * @param username
     * @return
     */
    public User findUserByUsername(String username);

    /**
     * 保存用户
     * @param user
     */
    public void save(User user);

    /**
     * 通过激活码查询用户信息
     * @param code
     * @return
     */
    public User findUserByCode(String code);

    /**
     * 激活用户账号
     * @param user
     */
    public void updateUserCode(User user);

    /**
     * 通过用户名和密码查询用户
     * @param loginUser
     * @return
     */
    User findUserByUsernameAndPassword(User loginUser);
}
