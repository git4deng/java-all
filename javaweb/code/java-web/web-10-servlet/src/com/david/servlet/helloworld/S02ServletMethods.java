package com.david.servlet.helloworld;

import javax.servlet.*;
import java.io.IOException;

/**
 * Servlet生命周期方法
 * @author david
 * @create 2019-05-25 15:41
 */
public class S02ServletMethods implements Servlet{

    /**
     * 初始化方法 在servlet创建的时候执行次方法，只会执行一次
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println(this.getClass().getName()+"-------init method executing......");
    }

    /**
     * 获取ServletConfig对象，即servlet的配置方法
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 提供服务的方法 每一次servlet被访问时执行，执行多次
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println(this.getClass().getName()+"-------service method executing......");
    }

    /**
     * 获取servlet信息
     * @return
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 销毁方法，在servlet被销毁的时候执行(服务器正常关闭),执行一次
     */
    @Override
    public void destroy() {
        System.out.println(this.getClass().getName()+"-------destroy method executing......");
    }
}
