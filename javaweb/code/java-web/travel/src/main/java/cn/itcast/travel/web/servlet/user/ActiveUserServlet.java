package cn.itcast.travel.web.servlet.user;

import cn.itcast.travel.service.user.UserService;
import cn.itcast.travel.service.user.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户激活servlet
 * @author david
 * @create 2019-06-14 21:45
 */
@WebServlet("/activeUserServlet")
public class ActiveUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //获取激活码
        String code = req.getParameter("code");
        UserService userService=new UserServiceImpl();
        boolean b= userService.active(code);
        //判断标记相应不同信息
        String msg="";
        if(b){
           msg="激活成功！请点击<a href='login.html'>登陆</a>完成登陆";
        }else{
            msg="激活失败！请联系管理员！";
        }
        res.setContentType("text/html;charset=utf-8");
        res.getWriter().write(msg);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        this.doPost(req, res);
    }
}
