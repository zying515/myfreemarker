package com.myfreemarker.controller;

import com.myfreemarker.util.JumpUrlUtil;
import com.sun.deploy.net.HttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/26.
 */
@Controller
@RequestMapping("/index")
public class IndexController extends BaseController {
    @RequestMapping("/home")
    public String toIndex(Map<String,Object> map, HttpSession session){
        initRegisterFreemarker();
        String url = getBaseUrl();
        map.put("baseUrl",url);
        if(!checkLogin(session)){
            return JumpUrlUtil.LOGIN_HTML;
        }
        return JumpUrlUtil.INDEX_HTML;
    }

}
