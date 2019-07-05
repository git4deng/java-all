package cn.itcast.travel.service.user.impl;

import cn.itcast.travel.dao.user.UserDao;
import cn.itcast.travel.dao.user.impl.UserDaoImpl;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.user.UserService;
import cn.itcast.travel.util.MailUtils;
import cn.itcast.travel.util.UuidUtil;

/**
 * @author david
 * @create 2019-06-13 23:10
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao=new UserDaoImpl();
    /**
     * 注册用户
     * @param user 用户信息
     * @return 布尔值是否注册成功
     */
    @Override
    public boolean register(User user) {
        User u = userDao.findUserByUsername(user.getUsername());
        if(u!=null){
            return false;
        }else{
            user.setCode(UuidUtil.getUuid());
            user.setStatus("N");
            userDao.save(user);
            //发送激活邮件
            String content="<a href='http://localhost/travel/user/active?code="+user.getCode()+"'>点击激活【黑马旅游网】</a>" +
                    "<br>" +
                    "<span>如果无法跳转，请复制如下链接到浏览器访问完成激活</span></br>" +
                    "<span>http://localhost/travel/activeUserServlet?code="+user.getCode()+"</span>";
            MailUtils.sendMail(user.getEmail(),content,"账号激活");
            return true;
        }
    }
    /**
     * 激活账户
     * @return
     */
    @Override
    public boolean active(String code) {
        //根据用户激活码查询用户对象
        User user = userDao.findUserByCode(code);
        if(user!=null){
            //激活用户账号
            user.setCode(code);
            userDao.updateUserCode(user);
            return true;
        }
        return false;
    }

    /**
     * 用户登陆
     * @param loginUser
     * @return
     */
    @Override
    public User login(User loginUser) {
        return userDao.findUserByUsernameAndPassword(loginUser);
    }
}
