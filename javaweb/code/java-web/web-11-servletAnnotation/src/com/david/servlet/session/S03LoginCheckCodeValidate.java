package com.david.servlet.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 通过session验证验证码
 * @author david
 * @create 2019-05-31 21:23
 */
@WebServlet("/login")
public class S03LoginCheckCodeValidate extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String checkCode = (String)session.getAttribute("checkCode");
        String code = req.getParameter("checkCode");
        //此处保证session中的验证码只有效一次，防止浏览器回退后继续访问，验证码不生效
        session.removeAttribute("checkCode");

        if(null!=checkCode && !"".equals(checkCode)&& checkCode.equalsIgnoreCase(code)){
            //验证码正确
            String username = req.getParameter("username");
            String pwd = req.getParameter("pwd");
            if("david".equalsIgnoreCase(username)&&"123456".equalsIgnoreCase(pwd)){
                //密码验证通过，跳转至新的登陆成功页面
                session.setAttribute("username",username);
                res.sendRedirect(req.getContextPath()+"/success.jsp");
            }else{
                //验证不通过返回登陆页面
                req.setAttribute("login_error","密码不正确");
                req.getRequestDispatcher("/login.jsp").forward(req,res);
            }
        }else{
            //验证码不对,转发至error页面
            req.setAttribute("code_error","验证码不正确");
            req.getRequestDispatcher("/login.jsp").forward(req,res);
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        this.doPost(req, res);
    }
}
