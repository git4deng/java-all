package com.david.servlet.otherWay;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * 继承GenericServlet类，该类实现了servlet接口，并将其余方法实现空方法，仅仅保留service方法
 * @author david
 * @create 2019-05-25 21:52
 */
@WebServlet("/s02")
public class S02GenericServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("GenericServlet!!");
    }
}
