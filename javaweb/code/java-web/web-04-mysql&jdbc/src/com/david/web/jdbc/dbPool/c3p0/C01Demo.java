package com.david.web.jdbc.dbPool.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * c3p0的演示
 * @author david
 * @create 2019-05-13 21:35
 */
public class C01Demo {
    public static void main(String[] args) throws SQLException {
        //1.创建数据库连接池对象,默认情况下会从classpath目录下自动加载配置文件 c3p0.properties 或者 c3p0-config.xml
        //注意：ComboPooledDataSource默认使用 default-config标签下的配置，也可以传入 named-config标签name属性的
        //的配置
       // DataSource ds=new ComboPooledDataSource();
        //
        DataSource ds=new ComboPooledDataSource("otherc3p0");
        //2.验证配置参数
        //2.1 验证最大连接数，超过10个(未归还的情况下)会抛出异常(An attempt by a client to checkout a Connection has timed out)
        for (int i = 0; i < 10; i++) {
            //获取连接
            Connection conn = ds.getConnection();
            System.out.println(conn);//输出10个不同的对象
            //归还连接
            if(i%2==0){
                conn.close();
            }
        }

    }
}
