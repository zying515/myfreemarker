package com.myfreemarker.controller;

import com.myfreemarker.bean.UserBean;
import com.myfreemarker.service.RegisterService;
import com.myfreemarker.util.JumpUrlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/30.
 */
@Controller
@RequestMapping("/user")
public class RegisterController extends BaseController {
    @Autowired
    private RegisterService registerService;
    @RequestMapping("/register")
    public String toRegister(Map<String,Object> map){
        initRegisterFreemarker();
        String url = getBaseUrl();
        map.put("baseUrl",url);
        return "/user/register";
    }
    /**
     * 参数为一个bean对象.spring会自动为我们关联映射
     * @param userBean
     * @return
     */
    @RequestMapping(value="/register/add",method = { RequestMethod.POST, RequestMethod.GET })
    public String addRegister(UserBean userBean,Map<String,Object> map){
       initRegisterFreemarker();
       String url = getBaseUrl();
        if(userBean!=null){
            System.out.println("用户名:"+userBean.getUsername());
            System.out.println("密码："+userBean.getPassword());
            System.out.println("密码2:"+userBean.getPassword2());
            System.out.println("手机号:"+userBean.getPhone());
            String password=userBean.getPassword();
            String password1=userBean.getPassword2();
            if(!password.equals(password1)){
                System.out.println("密码错误.....");
                return "error";
            }

            registerService.Register(userBean);
        }else{
           return "error";
        }
        map.put("baseUrl",url);
        return JumpUrlUtil.INDEX_HTML;
    }
}
