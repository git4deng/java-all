package com.david.servlet.servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * servletContext????
 * @author david
 * @create 2019-05-29 21:28
 */
@WebServlet("/c02")
public class C02ServletContextApi extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        //1.??MIME??
        String mimeType = context.getMimeType("a.jpg");
        System.out.println(mimeType);//image/jpeg

        //2.????????
        context.setAttribute("hehe","haha");

    }
}
