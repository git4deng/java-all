package com.david.redis.servlet;

import com.david.redis.domain.Province;
import com.david.redis.service.ProvinceService;
import com.david.redis.service.impl.ProvinceServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author david
 * @create 2019-06-13 14:56
 */
@WebServlet("/provinceServlet")
public class ProvinceServlet extends HttpServlet {
    private ProvinceService provinceService=new ProvinceServiceImpl();
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        res.setContentType("application/json;charset=utf-8");//返回json数据
//        List<Province> provinces = provinceService.getAllProvinces();
//        if (provinces!=null && provinces.size()>0){
//            ObjectMapper mapper=new ObjectMapper();
//            mapper.writeValue(res.getWriter(),provinces);
//        }
        res.getWriter().write(provinceService.getAllProvinceJsonString());
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        this.doPost(req, res);
    }
}
