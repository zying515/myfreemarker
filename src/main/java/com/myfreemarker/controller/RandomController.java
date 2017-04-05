package com.myfreemarker.controller;

import com.myfreemarker.util.WebSecurityConfig;
import com.sun.deploy.net.HttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Created by Administrator on 2017/4/1.
 */
@Controller
@RequestMapping("/Random")
public class RandomController {
    private static final long serialVersionUID = -6316706844836398723L;
    String rcode="";
    String sname="";

    /**
     * 验证码
     * @param flag 标识符
     * @param response  请求返回
     * @param session 将验证码放到session里面
     * @return
     */
    @RequestMapping("/kaptcha.jpg")
    public ModelAndView getRandomCode(@RequestParam(value = "flag")String flag, HttpServletResponse response, HttpSession session){
        ServletOutputStream responseOutputStream =null;
        try {
            String iflag=flag;
            System.out.println("flag="+flag);
            this.sname= WebSecurityConfig.CHECK_CODE;
            BufferedImage image=this.proceRandomCode();
            response.setDateHeader("Expires", 0);
            // Set to expire far in the past.
             response.setDateHeader("Expires", 0);
           // Set standard HTTP/1.1 no-cache headers.
           response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
            // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
           response.addHeader("Cache-Control", "post-check=0, pre-check=0");
          // Set standard HTTP/1.0 no-cache header.
            response.setHeader("Pragma", "no-cache");
            // return a jpeg
            response.setContentType("image/jpeg");
            responseOutputStream = response.getOutputStream();
            ImageIO.write(image, "JPEG", responseOutputStream);
            responseOutputStream.flush();
        } catch (Exception e) {
            System.out.println("验证码处理异常"+e);
        }finally{
            try {
                if(responseOutputStream !=null){
                    responseOutputStream.flush();
                    responseOutputStream.close();
                }
                System.out.println("存Session name:"+this.sname+"  this.rcode:"+this.rcode);
                session.setAttribute(this.sname, this.rcode);
            } catch (Exception e) {
                System.out.println("验证码处理 关闭数据流 异常"+ e);
            }
        }
        return null;
    }

    /**
     *
     */
    public BufferedImage proceRandomCode()throws Exception{
        this.rcode="";
        int width = 60, height = 20;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        Random random = new Random();
        g.setColor(getRandColor(200, 250));
        g.fillRect(0, 0, width, height);
        g.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        g.setColor(getRandColor(160, 200));
        for (int i = 0; i < 155; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x, y, x + xl, y + yl);
        }
        for (int i = 0; i < 4; i++) {
            String rand = String.valueOf(random.nextInt(10));
            this.rcode += rand;
            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));// 调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
            g.drawString(rand, 13 * i + 6, 16);
        }
        System.out.println("into  RandomController  getRandomCode  rand="+this.rcode);
        g.dispose();
        image.flush();
        return image;
    }

    private Color getRandColor(int fc, int bc) {// 给定范围获得随机颜色
        Random random = new Random();
        if (fc > 255)
            fc = 255;
        if (bc > 255)
            bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }


}
