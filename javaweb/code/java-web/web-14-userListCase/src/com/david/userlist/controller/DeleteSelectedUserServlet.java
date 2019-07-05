package com.david.userlist.controller;

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
 * @create 2019-06-04 21:42
 */
@WebServlet("/deleteUsers")
public class DeleteSelectedUserServlet extends HttpServlet {
    private UserService userService=new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String[] ids = req.getParameterValues("uid");
        System.out.println("删除的id："+ids);
        if(ids!=null && ids.length>0){
            userService.delteUsersByIds(ids);
        }
        req.getRequestDispatcher(req.getContextPath()+"/userListPage").forward(req,resp);
    }
}
