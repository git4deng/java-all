package com.david.web.jdbc;


import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author david
 * @create 2019-05-04 21:29
 */
public class J04JDBCUtils {
    private static String url;
    private static String username;
    private static String password;
    private static String className;

    /**
     * 静态块加载配置文件的数据，并加载驱动
     */
    static {
        ClassLoader loader = J04JDBCUtils.class.getClassLoader();
        URL res = loader.getResource("db.properties");
        String path = res.getPath();
        Properties pro=new Properties();
        try {
            pro.load(new FileReader(path));
            url=pro.getProperty("url");
            username=pro.getProperty("username");
            password=pro.getProperty("password");
            className=pro.getProperty("className");
            Class.forName(className);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接对象
     * @return
     * @throws SQLException
     */
    public static Connection getConn() throws SQLException {

        return DriverManager.getConnection(url,username,password);
    }

    /**
     * 释放资源等操作
     * @param conn
     * @param stmt
     */
    public static void close(Connection conn, Statement stmt){
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close(Connection conn, Statement stmt, ResultSet rs){
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试方法
     * @param args
     */
    public static void main(String[] args) {
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        try {
            conn = J04JDBCUtils.getConn();
            stmt = conn.createStatement();
            String sql="select * from emp ";
            rs = stmt.executeQuery(sql);
            List<Employee> emps=new ArrayList<>();
            Employee emp=null;
            while (rs.next()){
                emp=new Employee();
                emp.setId(rs.getInt("id"));
                emp.setEname(rs.getString("ename"));
                emp.setJob_id(rs.getInt("job_id"));
                emp.setMgr(rs.getInt("mgr"));
                emp.setJoindate(rs.getDate("joindate"));
                emp.setSalary(rs.getDouble("salary"));
                emp.setBonus(rs.getDouble("bonus"));
                emp.setDept_id(rs.getInt("dept_id"));
                emps.add(emp);
            }
            System.out.println(emps);
            emps.stream().forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            J04JDBCUtils.close(conn,stmt,rs);
        }
    }

}
