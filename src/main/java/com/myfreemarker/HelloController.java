package com.myfreemarker;

import java.util.Map;

import cn.org.rapid_framework.freemarker.directive.BlockDirective;
import cn.org.rapid_framework.freemarker.directive.ExtendsDirective;
import cn.org.rapid_framework.freemarker.directive.OverrideDirective;
import freemarker.template.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试velocity;
 * @author Angel --守护天使
 * @version v.0.1
 * @date 2016年10月4日
 */
@Controller
public class HelloController {
    @Value("${name}")
    private String name;


     @Autowired
     private Configuration configuration;
   /*configuration.setSharedVariable("block", new BlockDirective());
   configuration.setSharedVariable("override", new OverrideDirective());
    configuration.setSharedVariable("extends", new ExtendsDirective());*/

    @RequestMapping("/hello")
    public String hello(Map<String,Object> map){
       map.put("name", name);
        configuration.setSharedVariable("block",new BlockDirective());
        configuration.setSharedVariable("override", new OverrideDirective());
        configuration.setSharedVariable("extends", new ExtendsDirective());
        return "child";
    }
   
}