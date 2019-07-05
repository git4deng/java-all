package com.david.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * filter执行顺序
 * @author david
 * @create 2019-06-07 21:54
 */
//@WebFilter("*.jsp")
public class F02Filter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println(this.getClass().getName()+"=================> is running..........");
        chain.doFilter(req, resp);
        //对response对象的响应消息增强
        System.out.println(this.getClass().getName()+"=================> after charin..........");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
