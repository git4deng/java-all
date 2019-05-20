package com.david.web.jdbc.dbPool.jdbcTemplate;

import com.david.web.jdbc.dbPool.Druid.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * jdbcTemplate 入门介绍
 * @author david
 * @create 2019-05-13 22:26
 */
public class J01JdbcTemplate {
    public static void main(String[] args) {
        //获取JdbcTemplate对象
        JdbcTemplate jt=new JdbcTemplate(JDBCUtils.getDataSourece());
        String sql="update account set balance=2000 where id=?";
        int n = jt.update(sql, 3);
        System.out.println(n);
        //不需要处理连接资源问题，jt封装了对应释放资源的方法
    }
}
