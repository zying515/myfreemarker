package com.myfreemarker.controller;

import cn.org.rapid_framework.freemarker.directive.BlockDirective;
import cn.org.rapid_framework.freemarker.directive.ExtendsDirective;
import cn.org.rapid_framework.freemarker.directive.OverrideDirective;
import com.myfreemarker.util.WebSecurityConfig;
import freemarker.template.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/3/26.
 */
@Controller
public class BaseController {
    @Autowired
    private Configuration configuration;
    @Value("${pic_url}")
    private String pictureUrl;
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

    public String getPictureUrl() {
        return pictureUrl;
    }

    /**
     * 检查是否登录
     * @param session
     * @return 返回为true是登录了，否则，就是没有登录
     */
    public boolean checkLogin(HttpSession session){
        String name=(String) session.getAttribute(WebSecurityConfig.SESSION_KEY);
        if(name==null||name.length()<=0){
            return false;
        }
        return true;
    }
    @Bean
    public Converter<String, Date> addNewConvert() {
        return new Converter<String, Date>() {
            @Override
            public Date convert(String source) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date date = null;
                try {
                    date = sdf.parse((String) source);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return date;
            }
        };
    }

}
