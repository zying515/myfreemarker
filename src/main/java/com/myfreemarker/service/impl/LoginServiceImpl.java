package com.myfreemarker.service.impl;

import com.myfreemarker.bean.City;
import com.myfreemarker.bean.UserBean;
import com.myfreemarker.dao.LoginDao;
import com.myfreemarker.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/3/31.
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;
    public UserBean login(UserBean userBean){
      return loginDao.login(userBean);
    }

}
