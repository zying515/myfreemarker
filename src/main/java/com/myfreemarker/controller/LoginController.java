package com.myfreemarker.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.myfreemarker.bean.UserBean;
import com.myfreemarker.service.LoginService;
import com.myfreemarker.util.WebSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/30.
 */
@Controller
@RequestMapping("/user")
public class LoginController extends BaseController {
    @Autowired
    private LoginService loginService;

    /**
     * 通过这个方法可以跳转到登录页面
     * @param map
     * @return
     */
    @RequestMapping("/login")
    public String toIndex(Map<String,Object> map){
        initRegisterFreemarker();
        String url = getBaseUrl();
        map.put("baseUrl",url);
        return "/user/login";
    }

    /**
     * 登录方法的post请求
     * @param userBean
     * @param map
     * @param session
     * @return
     */
    @RequestMapping(value="/login/select",method = { RequestMethod.POST, RequestMethod.GET })
    public  String login(UserBean userBean, Map<String,Object> map, HttpSession session){
        initRegisterFreemarker();
        String url = getBaseUrl();
        map.put("baseUrl",url);
        if(userBean != null){
            String yzmcode = userBean.getYzmCode();
            System.out.println("用户名:"+userBean.getUsername()+"验证码:"+yzmcode);
            String password = userBean.getPassword();
            UserBean bean = loginService.login(userBean);
            String check_code = (String) session.getAttribute(WebSecurityConfig.CHECK_CODE);
            System.out.println("session中验证码为"+check_code);
            if(bean == null){
                map.put("success", false);
                map.put("message", "用户不存在");
                return "/user/login";
            }else{
                if (!bean.getPassword().equals(password)) {
                    map.put("success", false);
                    map.put("message", "密码错误");
                    return "/user/login";
                } else if(yzmcode == null||yzmcode.trim().length()<=0||!yzmcode.equals(check_code)){
                    map.put("success", false);
                    map.put("message", "验证码不正确，请重新输入");
                    return "/user/login";
                }else{
                    // 设置session
                    session.setAttribute(WebSecurityConfig.SESSION_KEY, userBean.getUsername());
                    //session.setAttribute(WebSecurityConfig.SESSION_KEY, userBean);
                    // map.put("username",userBean.getUsername());
                    map.put("success", true);
                    map.put("message", "登录成功");
                    return "index";
                }
            }

        }else{
            map.put("success", false);
            map.put("message", "用户信息为空");
            return "/user/login";
        }

    }
}
