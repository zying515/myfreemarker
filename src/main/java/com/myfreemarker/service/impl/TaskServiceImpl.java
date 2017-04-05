package com.myfreemarker.service.impl;

import com.myfreemarker.bean.TaskBean;
import com.myfreemarker.dao.TaskDao;
import com.myfreemarker.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/4/5.
 */
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskDao taskDao;
    public void addTask(TaskBean bean){
         taskDao.addTask(bean);
    }

}
