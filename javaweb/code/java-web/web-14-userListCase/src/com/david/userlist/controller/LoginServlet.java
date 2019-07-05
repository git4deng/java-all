package com.david.userlist.controller;

import com.david.userlist.domain.User;
import com.david.userlist.service.UserService;
import com.david.userlist.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author david
 * @create 2019-06-03 22:23
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserService userService=new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String verifycode = req.getParameter("verifycode");
        if("".equals(verifycode)&&verifycode==null) throw new ServletException("输入的验证码不能为空！");
        HttpSession session = req.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        //防止重复使用验证码，保证验证码只能使用一次
        session.removeAttribute("CHECKCODE_SERVER");
        if(!"".equals(checkcode_server) && checkcode_server!=null && checkcode_server.equalsIgnoreCase(verifycode)){
            //验证码正确
            User user=new User();
            Map<String, String[]> parameterMap = req.getParameterMap();
            try {
                BeanUtils.populate(user,parameterMap);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            User loginUser = userService.login(user);
            if(loginUser!=null){
               //登陆成功
                session.setAttribute("user",loginUser);
                resp.sendRedirect(req.getContextPath()+"/userListPage");//重定向到用户列表查询servlet
            }else{
                //登陆失败，跳转登陆页面
                req.setAttribute("login_error","用户名或者密码错误！");
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
            }
        }else{
            //验证码不正确,跳转登陆页面
            req.setAttribute("login_error","验证码错误！");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }
}
