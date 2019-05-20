package com.david.web.jdbc;

import java.sql.*;
import java.util.Scanner;

/**
 * @author david
 * @create 2019-05-04 22:18
 */
public class J05Login {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("请输入用户名，以回车键结束：");
        String username = scan.nextLine();
        System.out.println("请输入密码，以回车键结束：");
        String password=scan.nextLine();
        boolean login = login2(username, password);
        if (login){
            System.out.println("登陆成功！");
        }else{
            System.out.println("登陆失败！");
        }
    }

    public static boolean login(String username,String password){
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        try {
            conn=J04JDBCUtils.getConn();
            stmt = conn.createStatement();
            String sql="select * from user where username= '" + username + "' and password= '" + password+"'";
           rs = stmt.executeQuery(sql);
           return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            J04JDBCUtils.close(conn,stmt,rs);
        }
        return false;
    }

    /**
     * PreparedStatement
     * @param username
     * @param password
     * @return
     */
    public static boolean login2(String username,String password){
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
            conn=J04JDBCUtils.getConn();
//            String sql="select * from user where username= ? and password= ? ";
            String sql = "select * from user where username = ? and PASSWORD = ?";
           pstmt = conn.prepareStatement(sql);
           pstmt.setString(1,username);
           pstmt.setString(2,password);
            rs = pstmt.executeQuery();
           return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            J04JDBCUtils.close(conn,pstmt,rs);
        }
        return false;
    }

}
