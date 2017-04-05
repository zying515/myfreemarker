package com.myfreemarker.controller;

import cn.org.rapid_framework.freemarker.directive.BlockDirective;
import cn.org.rapid_framework.freemarker.directive.ExtendsDirective;
import cn.org.rapid_framework.freemarker.directive.OverrideDirective;
import freemarker.template.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

/**
 * Created by Administrator on 2017/3/26.
 */
@Controller
public class BaseController {
    @Autowired
    private Configuration configuration;
    @Value("${web.url}")
    private String baseUrl;
    private void registerFreemarker(){
        configuration.setSharedVariable("block",new BlockDirective());
        configuration.setSharedVariable("override", new OverrideDirective());
        configuration.setSharedVariable("extends", new ExtendsDirective());
    }
    public void initRegisterFreemarker(){
        this.registerFreemarker();
    }
    public String getBaseUrl(){
        return baseUrl;
    }


}
