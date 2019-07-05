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
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author david
 * @create 2019-06-14 23:06
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
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
            putJson(res.getWriter(),info);
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
        UserService userService=new UserServiceImpl();
        User user=userService.login(loginUser);

        if(user!=null){
            if(!"Y".equals(user.getStatus())){
                info.setFlag(false);
                info.setErrorMsg("用户未激活！");
                putJson(res.getWriter(),info);
                return ;
            }
            //登陆成功，保存用户在session
            session.setAttribute("user",user);

            info.setFlag(true);
            info.setData(user);
            putJson(res.getWriter(),info);
            return;
        }else{
            info.setFlag(false);
            info.setErrorMsg("用户名或者密码错误！");
            putJson(res.getWriter(),info);
            return ;
        }
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        this.doPost(req, res);
    }

    private void putJson(PrintWriter writer, ResultInfo info){
        ObjectMapper mapper=new ObjectMapper();
        try {
            mapper.writeValue(writer,info);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
