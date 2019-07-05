package cn.itcast.travel.web.servlet.user;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.user.UserService;
import cn.itcast.travel.service.user.impl.UserServiceImpl;
import cn.itcast.travel.web.servlet.common.BaseServlet;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author david
 * @create 2019-06-15 11:14
 */
@WebServlet("/user/*")
public class UserServlet extends BaseServlet {

    private UserService userService=new UserServiceImpl();
    /**
     * 注册
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应数据类型
        resp.setContentType("application/json;charset=utf-8");
        //封装结果bean
        ResultInfo info=new ResultInfo();
        ObjectMapper mapper=new ObjectMapper();
        //判断验证码
        String check = req.getParameter("check");//CHECKCODE_SERVER
        HttpSession session = req.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        //防止多次提交验证码未改变
        session.removeAttribute("CHECKCODE_SERVER");
        if(checkcode_server==null || !checkcode_server.equalsIgnoreCase(check)){
            info.setFlag(false);
            info.setErrorMsg("验证码不正确！");
            putJson(resp,info);
            return;
        }
        //获取参数并封装成对象
        Map<String, String[]> parameterMap = req.getParameterMap();
        User user=new User();
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //注册
        boolean b = userService.register(user);

        if(b){
            info.setFlag(b);
        }else{
            info.setFlag(b);
            info.setErrorMsg("注册失败！");
        }
        //将对象序列化后输出到浏览器
       // mapper.writeValue(resp.getWriter(),info);
        putJson(resp,info);
    }

    /**
     * 登陆
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    public void login(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        res.setContentType("application/json;charset=utf-8");
        ResultInfo info=new ResultInfo();
        HttpSession session = req.getSession();
        String check = req.getParameter("check");
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");
        if(checkcode_server==null || !checkcode_server.equalsIgnoreCase(check)){
            info.setFlag(false);
            info.setErrorMsg("验证码不正确！请点击图片刷新");
            putJson(res,info);
            return;
        }
        Map<String, String[]> parameterMap = req.getParameterMap();
        User loginUser=new User();
        try {
            BeanUtils.populate(loginUser,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        User user=userService.login(loginUser);
        if(user!=null){
            if(!"Y".equals(user.getStatus())){
                info.setFlag(false);
                info.setErrorMsg("用户未激活！");
                putJson(res,info);
                return ;
            }
            //登陆成功，保存用户在session
            session.setAttribute("user",user);

            info.setFlag(true);
            info.setData(user);
            putJson(res,info);
            return;
        }else{
            info.setFlag(false);
            info.setErrorMsg("用户名或者密码错误！");
            putJson(res,info);
            return ;
        }
    }

    /**
     * 获取session保存的用户信息
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    public void findOne(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("application/json;charset=utf-8");
        User user = (User) req.getSession().getAttribute("user");
        if(user!=null){
            //new ObjectMapper().writeValue(res.getWriter(),user);
            putJson(res,user);
        }
    }

    /**
     * 退出登陆
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    public void logout(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getSession().invalidate();
        res.sendRedirect(req.getContextPath()+"/login.html");
    }

    /**
     * 激活用户
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    public void active(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //获取激活码
        String code = req.getParameter("code");

        boolean b= userService.active(code);
        //判断标记相应不同信息
        String msg="";
        if(b){
            msg="激活成功！请点击<a href='login.html'>登陆</a>完成登陆";
        }else{
            msg="激活失败！请联系管理员！";
        }
        res.setContentType("text/html;charset=utf-8");
       // res.getWriter().write(msg);
        putJson(res,msg);
    }
}
