package cn.itcast.travel.web.servlet.route;

import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.route.RouteService;
import cn.itcast.travel.service.route.impl.RouteServiceImpl;
import cn.itcast.travel.web.servlet.common.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 路线信息
 * @author david
 * @create 2019-06-15 16:17
 */
@WebServlet("/route/*")
public class RouteServlet extends BaseServlet {
   private RouteService routeService=new RouteServiceImpl();
    /**
     * 分页查询路线
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    public void pageList(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        res.setContentType("application/json;charset=utf-8");
        String currentPageStr = req.getParameter("currentPage");
        String pageSizeStr = req.getParameter("pageSize");
        String cidStr = req.getParameter("cid");
        String rname = req.getParameter("rname");
        rname=new String(rname.getBytes("iso-8859-1"),"utf-8");
        int  currentPage=1;//默认第一页
        if (currentPageStr!=null&&!"".equals(currentPageStr)){
            currentPage=Integer.valueOf(currentPageStr);
        }
        int  cid=0;
        if (cidStr!=null&&!"".equals(cidStr)&&!"null".equals(cidStr)){
            cid=Integer.valueOf(cidStr);
        }
        int  pageSize=5;//默认每页显示5条信息
        if (pageSizeStr!=null&&!"".equals(pageSizeStr)){
            pageSize = Integer.valueOf(pageSizeStr);
        }
        //3. 调用service查询PageBean对象
        PageBean<Route> pb = routeService.pageQuery(cid, currentPage, pageSize,rname);

        //4. 将pageBean对象序列化为json，返回
        putJson(res,pb);


    }

    /**
     * 获取路线详情
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    public void routeDetail(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String rid = req.getParameter("rid");
        res.setContentType("application/json;charset=utf-8");
        Route route=routeService.findRouteByRid(rid);
        putJson(res,route);
    }

    /**
     * 判断是否已经收藏
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    public void favorite(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String rid = req.getParameter("rid");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user==null){
            //用户未登录不能点击收藏
            res.getWriter().write("false");
        }else{

          Favorite favorite= routeService.findFavoriteByRidAndUid(user.getUid(),Integer.valueOf(rid));
          if(favorite==null){
              res.getWriter().write("true");
          }else {
              res.getWriter().write("false");
          }
        }
    }

    /**
     * 添加线路收藏
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    public void addFavorite(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String rid = req.getParameter("rid");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user==null){
            //用户未登录不能点击收藏
            res.getWriter().write("false");
            return ;
        }else{
            int i = routeService.addFavorite(Integer.valueOf(rid), user.getUid());
            if(i==1){
                res.getWriter().write("true");
            }else {
                res.getWriter().write("false");
            }
        }
    }
}
