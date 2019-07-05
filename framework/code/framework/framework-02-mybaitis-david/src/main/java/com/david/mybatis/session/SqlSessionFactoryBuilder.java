package com.david.mybatis.session;

import com.david.mybatis.cfg.Configuration;
import com.david.mybatis.session.defualt.DefaultSqlSessionFactory;
import com.david.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream; /**
 * @author david
 * @create 2019-06-18 9:32
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(InputStream is) {
        Configuration configuration = XMLConfigBuilder.loadConfiguration(is);

        return new DefaultSqlSessionFactory(configuration);
    }
}
