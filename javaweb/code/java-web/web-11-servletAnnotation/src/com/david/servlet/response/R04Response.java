package com.david.servlet.response;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author david
 * @create 2019-05-28 21:24
 */
@WebServlet("/r04")
public class R04Response extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("r04.............");
        resp.setContentType("text/html;charset=utf-8");
        ServletOutputStream outputStream = resp.getOutputStream();
        outputStream.write("大家好！".getBytes("UTF-8"));
    }
}
