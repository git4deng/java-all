package com.david.servlet.otherWay;

import com.sun.org.apache.xpath.internal.SourceTree;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * url可以配置多个访问路径
 * @author david
 * @create 2019-05-25 22:05
 */
@WebServlet(urlPatterns = {"/s4","/s44","/s444"})
public class S04HttpServletUrlpattern extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("................");
    }
}
