package com.myfreemarker.bean;

/**
 * 用户信息实体类
 * Created by Administrator on 2017/3/30.
 */
public class UserBean {
    private String username;//用户名
    private String password;//密码
    private String phone;//手机号
    private String password2;//确定输入密码
    private String yzmCode;//验证码


    public String getYzmCode() {
        return yzmCode;
    }

    public void setYzmCode(String yzmCode) {
        this.yzmCode = yzmCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
}
