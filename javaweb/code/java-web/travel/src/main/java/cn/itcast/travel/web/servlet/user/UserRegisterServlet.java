package cn.itcast.travel.web.servlet.user;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.user.UserService;
import cn.itcast.travel.service.user.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author david
 * @create 2019-06-13 23:09
 */
@WebServlet("/userRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //设置响应数据类型
        res.setContentType("application/json;charset=utf-8");
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
            mapper.writeValue(res.getWriter(),info);
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
        UserService userService=new UserServiceImpl();
        boolean b = userService.register(user);

        if(b){
          info.setFlag(b);
        }else{
          info.setFlag(b);
          info.setErrorMsg("注册失败！");
        }
        //将对象序列化后输出到浏览器
        mapper.writeValue(res.getWriter(),info);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        this.doPost(req, res);
    }
}
