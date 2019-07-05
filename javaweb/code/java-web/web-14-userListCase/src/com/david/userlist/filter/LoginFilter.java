package com.david.userlist.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登陆验证的过滤器
 * @author david
 * @create 2019-06-08 20:36
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req= (HttpServletRequest) servletRequest;
        HttpServletResponse res= (HttpServletResponse) servletResponse;

        String uri = req.getRequestURI();

        if(uri.contains("login.jsp")||uri.contains("/login")||uri.contains("login.jsp")||uri.contains("/checkCode")||uri.contains("/css/")|uri.contains("/js/")||uri.contains("/fonts/")){
            //放行
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            Object user = req.getSession().getAttribute("user");
            if(user!=null){
                filterChain.doFilter(servletRequest,servletResponse);
            }else{
                req.setAttribute("login_error","请未登陆请先登陆！");
                req.getRequestDispatcher("/login.jsp").forward(req,res);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
