package com.david.servlet.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重定向 状态码302
 * @author david
 * @create 2019-05-28 21:24
 */
@WebServlet("/r01")
public class R01Response extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("r01............");
        //方法一：设置响应头的方式
//        resp.setStatus(302);
//        resp.setHeader("location","/r02");

        //方法二：直接调用重定向方法
        resp.sendRedirect("/r02");

    }
}
