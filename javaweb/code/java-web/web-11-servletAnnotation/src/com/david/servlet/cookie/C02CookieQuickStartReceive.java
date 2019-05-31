package com.david.servlet.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Arrays;

/**
 * Cookie??????
 * @author david
 * @create 2019-05-29 23:33
 */
@WebServlet("/c2")
public class C02CookieQuickStartReceive extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        Arrays.stream(cookies).forEach(cookie ->{
            if("CN".equals(cookie.getName())){
                System.out.println(cookie.getName()+":"+ URLDecoder.decode(cookie.getValue()));
            }else{
                System.out.println(cookie.getName()+":"+cookie.getValue());
            }

        });
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
