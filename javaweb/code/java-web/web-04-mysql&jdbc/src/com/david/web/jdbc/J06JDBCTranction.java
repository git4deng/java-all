package com.david.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author david
 * @create 2019-05-04 22:55
 */
public class J06JDBCTranction {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement pstmt1=null;
        PreparedStatement pstmt2=null;
        ResultSet rs=null;
        try {
            conn = J04JDBCUtils.getConn();
            //开启事务
            conn.setAutoCommit(false);

            //定义sql
            String sql1="update account set balance = balance - ? where name=?";
            pstmt1 = conn.prepareStatement(sql1);
            pstmt1.setInt(1,500);
            pstmt1.setString(2,"张三");
            int i = pstmt1.executeUpdate();
           // int n=1/0;//制造异常
            String sql2="update account set balance = balance + ? where name=?";
            pstmt2 = conn.prepareStatement(sql2);
            pstmt2.setInt(1,500);
            pstmt2.setString(2,"李四");
            i = pstmt2.executeUpdate();
            //提交事务
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            //事务回滚
            if(conn!=null)
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
        }finally {
            try {
                pstmt1.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                pstmt2.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
