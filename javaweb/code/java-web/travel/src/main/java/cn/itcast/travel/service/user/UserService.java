package cn.itcast.travel.service.user;

import cn.itcast.travel.domain.User;

/**
 * @author david
 * @create 2019-06-13 23:10
 */
public interface UserService {
    /**
     * 注册用户
     * @param user 用户信息
     * @return 布尔值是否注册成功
     */
    public boolean register(User user);

    /**
     * 激活账户
     * @return
     */
    public boolean active(String code);

    /**
     * 用户登陆
     * @param loginUser
     * @return
     */
    User login(User loginUser);
}
