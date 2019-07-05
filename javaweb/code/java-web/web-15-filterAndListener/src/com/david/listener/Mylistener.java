package com.david.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author david
 * @create 2019-06-09 20:53
 */
//@WebListener //也可以使用注解的方式配置
public class Mylistener implements ServletContextListener{
    /**
     * 监听servletContext对象创建，ServletContext对象服务器启动后自动创建,在服务器启动后自动被调用
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println(this.getClass().getName()+"对象被创建了......");
        //一般这个方法用来加载资源，并放在servletcontext对象中

        ServletContext servletContext = servletContextEvent.getServletContext();
        //获取servletContext初始化配置文件
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");
        //获取真实路径
        String realPath = servletContext.getRealPath(contextConfigLocation);
        System.out.println(realPath);
        //加载配置文件进内存
        FileInputStream fis=null;
        try {
            fis=new FileInputStream(realPath);
            System.out.println(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
          if(fis!=null){
              try {
                  fis.close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
        }
    }

    /**
     * 服务器正常关闭，ServletContext对象被销毁，该方法自动被调用
     * @param servletContextEvent
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println(this.getClass().getName()+"对象被销毁了......");
    }
}
