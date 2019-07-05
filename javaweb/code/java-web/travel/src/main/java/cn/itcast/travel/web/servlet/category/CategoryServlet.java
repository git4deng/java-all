package cn.itcast.travel.web.servlet.category;

import cn.itcast.travel.domain.Category;
import cn.itcast.travel.service.category.CategoryService;
import cn.itcast.travel.service.category.impl.CategoryServiceImpl;
import cn.itcast.travel.web.servlet.common.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author david
 * @create 2019-06-15 12:46
 */
@WebServlet("/category/*")
public class CategoryServlet extends BaseServlet {
    private CategoryService categoryService=new CategoryServiceImpl();

    /**
     * 查询所有
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    public  void categoryList(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("application/json;charset=utf-8");
        List<Category> categories = categoryService.findAll();
        putJson(res,categories);
    }
}
