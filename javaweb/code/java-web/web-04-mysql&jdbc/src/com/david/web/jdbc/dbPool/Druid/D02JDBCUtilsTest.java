package com.david.web.jdbc.dbPool.Druid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Druid连接池的工具类演示
 * @author david
 * @create 2019-05-13 22:05
 */
public class D02JDBCUtilsTest {
    public static void main(String[] args) {
        PreparedStatement pstmt=null;
        Connection conn=null;
        try {
            conn = JDBCUtils.getConnection();
            String sql="insert into account values(null,?,?) ";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,"ZHANGSAN");
            pstmt.setDouble(2,1000);
            int i = pstmt.executeUpdate();
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt,conn);
        }
    }
}
