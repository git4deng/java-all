package com.david.servlet.response;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 输出验证码
 * @author david
 * @create 2019-05-28 23:05
 */
@WebServlet("/r05")
public class R05CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.生成图片
        int width=100;
        int height=50;
        BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        //2.美化图片
        //2.1 填充背景色
        Graphics g = image.getGraphics();//画笔对象
        g.setColor(Color.PINK);//设置画笔的颜色
        g.fillRect(0,0,width,height);//填充

        //2.2画边框
        g.setColor(Color.BLUE);
        g.drawRect(0,0,width-1,height-1);//-1是因为边框本身有一个像素
        //2.3验证码
        String code="1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random=new Random();

        StringBuffer sb=new StringBuffer();
        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(code.length());
            char ch=code.charAt(index);
            int x =(i+1)*20;
            g.drawString(ch+"",x,25);
            sb.append(ch);
        }
        //将生成的验证码存入session中
        req.getSession().setAttribute("checkCode",sb.toString());

        //2.4 画干扰线
        g.setColor(Color.GREEN);
        for (int i = 0; i < 10; i++) {
            //随机生成坐标
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            g.drawLine(x1,y1,x2,y2);
        }
        //3.输出图片
        ImageIO.write(image,"jpg",resp.getOutputStream());
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
