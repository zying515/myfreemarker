package com.myfreemarker.controller;

import com.myfreemarker.bean.TaskBean;
import com.myfreemarker.service.TaskService;
import com.myfreemarker.util.WebSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/3.
 */
@Controller
@RequestMapping("/task")
public class TaskController extends BaseController {
   @Autowired
   private TaskService taskService;
    @RequestMapping("/home")
    public String toIndex(Map<String,Object> map,HttpSession session){
        initRegisterFreemarker();
        String url = getBaseUrl();
        map.put("baseUrl",url);
        String name=(String) session.getAttribute(WebSecurityConfig.SESSION_KEY);
        if(name==null||name.length()<=0){
            return "/user/login";
        }
       // session.setAttribute(WebSecurityConfig.SESSION_KEY,name);
        return "/task/taskbox";


    }

    @RequestMapping("/home/add")
    public String addTask(TaskBean bean, Map<String,Object> map, HttpSession session){
        initRegisterFreemarker();
        String url = getBaseUrl();
        String name=(String) session.getAttribute(WebSecurityConfig.SESSION_KEY);
        if(name==null||name.length()<=0){
            return "/user/login";
        }
        bean.setRegisterdate(new Date());
        taskService.addTask(bean);
        map.put("baseUrl",url);
        return "/task/taskbox";


    }

}
