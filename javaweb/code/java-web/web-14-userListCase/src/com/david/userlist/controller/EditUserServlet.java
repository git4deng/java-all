package com.david.userlist.controller;

import com.david.userlist.domain.User;
import com.david.userlist.service.UserService;
import com.david.userlist.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author david
 * @create 2019-06-04 22:02
 */
@WebServlet("/editUser")
public class EditUserServlet extends HttpServlet{
    private UserService userService=new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String id = req.getParameter("id");
        if(id!=null && !"".equals(id)){
            User user = userService.findUser(Integer.valueOf(id));
            if(user!=null) req.setAttribute("user",user);
        }
        req.getRequestDispatcher("/update.jsp").forward(req,resp);
    }
}
