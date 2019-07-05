package com.david.userlist.controller;

import com.david.userlist.domain.PageBean;
import com.david.userlist.domain.User;
import com.david.userlist.service.UserService;
import com.david.userlist.service.impl.UserServiceImpl;

import javax.crypto.interfaces.PBEKey;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * @author david
 * @create 2019-06-04 23:48
 */
@WebServlet("/userListPage")
public class FindUserListByPageServlet extends HttpServlet {
    private UserService userService=new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String currentPage = req.getParameter("currentPage");
        String rows = req.getParameter("rows");
        //默认显示第一页
        if(currentPage==null||"".equals(currentPage)){
            currentPage="1";
        }
        //默认每页显示5条数据
        if(rows==null||"".equals(rows)){
            rows="5";
        }
        //条件查询参数
        Map<String, String[]> condition = req.getParameterMap();

        PageBean<User> pageBean = userService.findUsesByPage(currentPage, rows,condition);
        req.setAttribute("pb",pageBean);
        System.out.println(pageBean);
        req.setAttribute("condition",condition);
        req.getRequestDispatcher("/list.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
