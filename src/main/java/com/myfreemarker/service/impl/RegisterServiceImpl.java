package com.myfreemarker.service.impl;

import com.myfreemarker.bean.UserBean;
import com.myfreemarker.dao.CityDao;
import com.myfreemarker.dao.RegisterDao;
import com.myfreemarker.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/3/30.
 */
@Service
public class RegisterServiceImpl implements  RegisterService {
    @Autowired
    private RegisterDao registerDao;
    public void Register(UserBean userBean){
        registerDao.Register(userBean);
    }
}
