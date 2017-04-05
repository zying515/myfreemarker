package com.myfreemarker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by Administrator on 2017/3/26.
 */
@Controller
@RequestMapping("/index")
public class IndexController extends BaseController {
    @RequestMapping("/home")
    public String toIndex(Map<String,Object> map){
        initRegisterFreemarker();
        String url = getBaseUrl();
        map.put("baseUrl",url);
        return "index";
    }

}
