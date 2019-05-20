package com.david.web.reflect;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author david
 * @create 2019-04-29 21:58
 */
public class R02ReflectTest {
    public static void main(String[] args) throws Exception{
        //
        ClassLoader classLoader = R02ReflectTest.class.getClassLoader();

        InputStream is = classLoader.getResourceAsStream("property.properties");
        System.out.println(is==null);
        Properties p=new Properties();
        p.load(is);

        String className = p.getProperty("className");
        String methodName = p.getProperty("methodName");

        Class cls = Class.forName(className);
        Object obj = cls.newInstance();

        Method method = cls.getMethod(methodName);
        method.invoke(obj);

    }
}
class F{
    public void method(){
        System.out.println("f method is running......");
    }
}
class G{
    public void method(){
        System.out.println("g method is running......");
    }
}