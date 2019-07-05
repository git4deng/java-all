package cn.itcast.travel.dao.user.impl;

import cn.itcast.travel.dao.user.UserDao;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author david
 * @create 2019-06-13 23:10
 */
public class UserDaoImpl implements UserDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public User findUserByUsername(String username) {
        User user = null;
        try {
            String sql="select * from tab_user where username=? ";
            //注意这个方法如果没有查找到对应的数据，不会返回null而是直接抛出异常
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);
        } catch (Exception e) {
            System.out.println(this.getClass().getName()+"========>没有找到对应用户！");
        }
        return user;
    }

    @Override
    public void save(User user) {
        String sql=" insert into tab_user (username,password,name,birthday,sex,telephone,email,status,code) " +
                   " values (?,?,?,?,?,?,?,?,?) ";
        template.update(sql,user.getUsername(), user.getPassword(), user.getName(), user.getBirthday(),
                user.getSex(), user.getTelephone(), user.getEmail(),user.getStatus(),user.getCode());
    }

    /**
     * 通过激活码查询用户信息
     * @param code
     * @return
     */
    @Override
    public User findUserByCode(String code) {
        User user = null;
        try {
            String sql="select * from tab_user where code=? ";
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), code);
        } catch (Exception e) {
            System.out.println(this.getClass().getName()+"========>没有找到对应激活码的用户信息！");
        }
        return user;
    }

    /**
     * 激活用户账号
     * @param user
     */
    @Override
    public void updateUserCode(User user) {
        String sql="update tab_user set status='Y' where code= ? ";
        template.update(sql,user.getCode());
    }

    @Override
    public User findUserByUsernameAndPassword(User loginUser) {
        User user = null;
        try {
            String sql="select * from tab_user where username=? and password=? ";
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), loginUser.getUsername(),loginUser.getPassword());
        } catch (Exception e) {
            System.out.println(this.getClass().getName()+"========>没有找到对应账户和密码的用户信息！");
        }
        return user;
    }
}
