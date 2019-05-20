package com.david.web.jdbc;

import java.sql.*;

/**
 * @author david
 * @create 2019-05-04 19:08
 */
public class J02HandleMySql {
    public static void main(String[] args) {
        Connection conn=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2?useUnicode=true&characterEncoding=UTF-8", "root", "root");
            //插入操作
//            insertHandle(conn);
            //修改操作
//            updateHandle(conn);
            //删除操作
            //deleteHandle(conn);

            //查询操作
            selectHandle(conn);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void selectHandle(Connection conn) {
        String sql="select * from dept ";
        Statement stmt=null;
        ResultSet rs=null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String loc = rs.getString(3);
                System.out.println("id======"+id+",name====="+name+",loc====="+loc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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
        }
    }

    /**
     * 删除操作
     * @param conn
     */
    private static void deleteHandle(Connection conn) {
        String sql=" delete from dept where id=50 ";
       Statement stmt=null;
        try {
            stmt= conn.createStatement();
            int i = stmt.executeUpdate(sql);
            System.out.println(i>0?"删除成功！":"删除失败！");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void updateHandle(Connection conn) {
        String sql ="update dept set loc='陕西' where id=50";
        Statement stmt=null;
        try {
            stmt = conn.createStatement();
            int i = stmt.executeUpdate(sql);
            System.out.println(i>0?"修改成功！":"修改失败！");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 插入数据
     * @param conn
     */
    private static void insertHandle(Connection conn) {
        String sql="insert into dept (id,dname,loc) values (50,'后勤部','重庆') ";
        Statement stmt=null;
        try {
            stmt = conn.createStatement();
            int i = stmt.executeUpdate(sql);
            System.out.println("成功插入"+i+"条数据");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
