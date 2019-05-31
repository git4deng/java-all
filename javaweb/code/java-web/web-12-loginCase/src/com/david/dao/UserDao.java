package com.david.dao;

import com.david.domain.User;
import com.david.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * UserDao
 * @author david
 * @create 2019-05-26 21:46
 */
public class UserDao {
    //申明JdbcTemplate对象公用
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 登陆方法
     * @param user 只有用户名和密码
     * @return user包含id 用户名和密码
     */
    public User login(User user){

        try {
            String sql="select * from user where username=? and password=? ";
            User u = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),
                    user.getUsername(), user.getPassword());
            return u;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
