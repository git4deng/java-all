package com.david.userlist.controller;

import com.david.userlist.domain.User;
import com.david.userlist.service.UserService;
import com.david.userlist.service.impl.UserServiceImpl;
import com.sun.org.apache.xalan.internal.xsltc.cmdline.getopt.GetOpt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author david
 * @create 2019-06-03 23:34
 */
@WebServlet("/userList")
public class UserListServlet extends HttpServlet {
    private UserService userService=new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        List<User> users = userService.findAllUsers();
        req.setAttribute("users",users);
        req.getRequestDispatcher("/list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doGet(req,resp);
    }
}
