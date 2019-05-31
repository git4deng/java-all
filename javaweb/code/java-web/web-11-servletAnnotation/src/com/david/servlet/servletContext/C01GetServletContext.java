package com.david.servlet.servletContext;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ??servletContext???
 * @author david
 * @create 2019-05-29 21:28
 */
@WebServlet("/c01")
public class C01GetServletContext extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //????servletcontext??
        ServletContext servletContext = this.getServletContext();
        ServletContext servletContext1 = req.getServletContext();

        System.out.println(servletContext);
        System.out.println(servletContext1);



    }
}
