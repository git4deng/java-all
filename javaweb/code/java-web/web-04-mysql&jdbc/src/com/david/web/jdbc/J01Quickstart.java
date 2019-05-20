package com.david.web.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * JDBC快速入门
 * @author david
 * @create 2019-05-04 16:49
 */
public class J01Quickstart {
    public static void main(String[] args) throws Exception {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2获取链接对象(注意指定编码格式，防止中文乱码）
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2?useUnicode=true&characterEncoding=UTF-8", "root", "root");
        //3.定义SQL语句
        String sql="update dept set loc='成都' where id=40 ";
        //4 获取执行sql的对象 statement
        Statement stmt = conn.createStatement();
        //6.执行sql语句
        int i = stmt.executeUpdate(sql);
        System.out.println("更新成功！受影响行数："+i+"行");
        //7释放资源
        stmt.close();
        conn.close();
    }
}
