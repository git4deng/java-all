package com.david.servlet.servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * ?????????
 * @author david
 * @create 2019-05-29 22:19
 */
@WebServlet("/c04")
public class C04ServletContextGetRealPath extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = request.getServletContext();
        String realPath = context.getRealPath("/a.txt");
        System.out.println("realPath:"+realPath);
        File file=new File(realPath);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
