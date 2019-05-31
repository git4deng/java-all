package com.david.web;

import com.david.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author david
 * @create 2019-05-26 22:23
 */
@WebServlet("/success")
public class SuccessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        User user = (User) req.getAttribute("user");
        res.setContentType("text/html;charset=utf-8");
        res.getWriter().write("登录成功！"+user.getUsername()+",欢迎您");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
