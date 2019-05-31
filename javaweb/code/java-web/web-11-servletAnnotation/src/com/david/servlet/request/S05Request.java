package com.david.servlet.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 演示request对象获取请求行数据
 * @author david
 * @create 2019-05-26 14:55
 */
@WebServlet("/s05")
public class S05Request extends HttpServlet {
    /**
        1. 获取请求方式 ：GET
            * String getMethod()
        2. (*)获取虚拟目录：/day14
            * String getContextPath()
        3. 获取Servlet路径: /requestDemo1
            * String getServletPath()
        4. 获取get方式请求参数：name=zhangsan
            * String getQueryString()
        5. (*)获取请求URI：/day14/demo1
            * String getRequestURI():		/day14/requestDemo1
            * StringBuffer getRequestURL()  :http://localhost/day14/requestDemo1
        6. 获取协议及版本：HTTP/1.1
            * String getProtocol()

        7. 获取客户机的IP地址：
            * String getRemoteAddr()
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-------------------获取请求行----------------------");
        String method = req.getMethod();
        System.out.println("请求方式："+method);
        String contextPath = req.getContextPath();
        System.out.println("虚拟目录："+contextPath);
        String servletPath = req.getServletPath();
        System.out.println("servlet路径："+servletPath);
        String queryString = req.getQueryString();
        System.out.println("GET请求参数："+queryString);//仅仅只有get方法才有
        String requestURI = req.getRequestURI();
        System.out.println("uri:"+requestURI);
        StringBuffer requestURL = req.getRequestURL();
        System.out.println("url:"+requestURL);
        String protocol = req.getProtocol();
        System.out.println("协议和版本："+protocol);
        String remoteAddr = req.getRemoteAddr();
        System.out.println("客户机地址："+remoteAddr);
        System.out.println("-------------------获取请求头----------------------");
        Enumeration<String> names = req.getHeaderNames();
        while (names.hasMoreElements()){
            String name = names.nextElement();
            String header = req.getHeader(name);
            System.out.println(name+"---->"+header);
        }
    }

    /**
     * 请求体只有post请求方法种才有
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-------------------获取请求行----------------------");
        String method = req.getMethod();
        System.out.println("请求方式："+method);
        String contextPath = req.getContextPath();
        System.out.println("虚拟目录："+contextPath);
        String servletPath = req.getServletPath();
        System.out.println("servlet路径："+servletPath);
        String queryString = req.getQueryString();
        System.out.println("请求参数："+queryString);
        String requestURI = req.getRequestURI();
        System.out.println("uri:"+requestURI);
        StringBuffer requestURL = req.getRequestURL();
        System.out.println("url:"+requestURL);
        String protocol = req.getProtocol();
        System.out.println("协议和版本："+protocol);
        String remoteAddr = req.getRemoteAddr();
        System.out.println("客户机地址："+remoteAddr);
        System.out.println("-------------------获取请求头----------------------");
        Enumeration<String> names = req.getHeaderNames();
        while (names.hasMoreElements()){
            String name = names.nextElement();
            String header = req.getHeader(name);
            System.out.println(name+"---->"+header);
        }
        System.out.println("-------------------获取请求体----------------------");
        BufferedReader br = req.getReader();
        String line=null;
        while((line=br.readLine())!=null){
            System.out.println(line);
        }

    }
}
