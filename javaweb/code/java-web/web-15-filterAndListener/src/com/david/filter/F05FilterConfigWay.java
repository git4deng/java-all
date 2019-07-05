package com.david.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 拦截器拦截方式配置
 * @author david
 * @create 2019-06-08 18:22
 */

//浏览器直接请求index.jsp资源时，该过滤器会被执行,REQUEST只拦截浏览器直接访问的请求，转发重定向的请求不拦截
//@WebFilter(value="/index.jsp",dispatcherTypes = DispatcherType.REQUEST)

//只有转发访问index.jsp时，该过滤器才会被执行
//@WebFilter(value="/index.jsp",dispatcherTypes = DispatcherType.FORWARD)

//浏览器直接请求index.jsp或者转发访问index.jsp。该过滤器才会被执行
@WebFilter(value="/*",dispatcherTypes ={ DispatcherType.FORWARD,DispatcherType.REQUEST})
public class F05FilterConfigWay implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filter 05.....");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
