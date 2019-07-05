package com.david.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 基于注解形式和xml配置的方式的过滤器， /* 表示过滤所有请求
 * @author david
 * @create 2019-06-06 22:30
 */
//@WebFilter("/*")
public class F01QuickStartFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println(this.getClass().getName()+" is running.....");

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
