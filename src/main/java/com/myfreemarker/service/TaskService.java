package com.myfreemarker.service;

import com.myfreemarker.bean.CmTask;
import com.myfreemarker.bean.PageBean;
import com.myfreemarker.bean.TaskBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Administrator on 2017/4/5.
 */

public interface TaskService {
    public void addTask(TaskBean bean);
    public PageBean<TaskBean> selectTaskList(PageBean<TaskBean> pageBean);
    public TaskBean selectTaskObject(TaskBean bean);
}
