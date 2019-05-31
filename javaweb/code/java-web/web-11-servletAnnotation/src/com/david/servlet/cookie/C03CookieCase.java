package com.david.servlet.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 小案例：
 * 1. 访问一个Servlet，如果是第一次访问，则提示：您好，欢迎您首次访问。
 2. 如果不是第一次访问，则提示：欢迎回来，您上次访问时间为:显示时间字符串
 * @author david
 * @create 2019-05-30 20:40
 */
@WebServlet("/c3")
public class C03CookieCase extends HttpServlet {
    /**
     * 1. 可以采用Cookie来完成
     2. 在服务器中的Servlet判断是否有一个名为lastTime的cookie
        有：不是第一次访问
         响应数据：欢迎回来，您上次访问时间为:2018年6月10日11:50:20
        写回Cookie：lastTime=2018年6月10日11:50:01
       没有：是第一次访问
       响应数据：您好，欢迎您首次访问
       写回Cookie：lastTime=2018年6月10日11:50:01
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String now = sdf.format(date);

        Cookie[] cookies = request.getCookies();
        boolean flag=false;
        if(cookies!=null&&cookies.length>0) {
            for (Cookie c : cookies) {
                String name = c.getName();
                if ("lastTime".equals(name)) {
                    //证明有值
                    String value = c.getValue();
                    String message = "欢迎回来，您上次访问时间为：" + URLDecoder.decode(value,"utf-8");
                    c.setValue(URLEncoder.encode(now,"utf-8"));
                    response.addCookie(c);
                    try {
                        response.getWriter().write(message);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    flag=true;
                    break;
                }
            }
        }
        if (cookies == null || cookies.length == 0 || flag == false) {
            String message = "您好，欢迎您首次访问";
            Cookie cookie = new Cookie("lastTime", URLEncoder.encode(now,"utf-8"));
            //设置cookie存活时间
            cookie.setMaxAge(60 * 60 * 24 * 30);
            response.addCookie(cookie);
            response.getWriter().write(message);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
