package com.david.servlet.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 转发，以及数据共享
 * @author david
 * @create 2019-05-26 21:04
 */
@WebServlet("/s07")
public class S07RequestDispatcher extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("s7......");
        //储存数据到request域对象中
        request.setAttribute("name","David");
        //转发到s08
        request.getRequestDispatcher("/s08").forward(request,response);
    }
}
