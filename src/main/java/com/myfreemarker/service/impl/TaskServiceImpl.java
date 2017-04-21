package com.myfreemarker.service.impl;

import com.myfreemarker.bean.CmTask;
import com.myfreemarker.bean.PageBean;
import com.myfreemarker.bean.TaskBean;
import com.myfreemarker.dao.CmTaskRepository;
import com.myfreemarker.dao.TaskDao;
import com.myfreemarker.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public PageBean<TaskBean> selectTaskList(PageBean<TaskBean> pageBean){
        int totalNum=taskDao.selectTaskNum();
        pageBean.setTotalNum(totalNum+"");
        return null;
    }
    public TaskBean selectTaskObject(TaskBean bean){
        return taskDao.selectTaskObject(bean);
    }

}
