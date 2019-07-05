package com.david.mybatis.io;

import java.io.InputStream;

/**
 * 获取输入流工具
 * @author david
 * @create 2019-06-18 9:29
 */
public class Resources {
    public static InputStream getResourceAsStream(String path) {
        return Resources.class.getClassLoader().getResourceAsStream(path);
    }
}
