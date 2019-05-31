package com.david.web;

import com.david.dao.UserDao;
import com.david.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 登陆servlet
 * @author david
 * @create 2019-05-26 22:14
 */
@WebServlet("/login")
public class webLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //String username = req.getParameter("username");
       //  String password = req.getParameter("password");

        Map<String, String[]> params = req.getParameterMap();
        User loginUser=new User();
//        loginUser.setUsername(username);
//        loginUser.setPassword(password);
        //此处优化采用BeanUtils来封装参数到对应的user对象
        try {
            BeanUtils.populate(loginUser,params);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        UserDao dao=new UserDao();;
        User login = dao.login(loginUser);
        if(login!=null){
            req.setAttribute("user",login);
            req.getRequestDispatcher("/success").forward(req,resp);
        }else {
            req.getRequestDispatcher("/error").forward(req,resp);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
