package com.myfreemarker.service;

import com.myfreemarker.bean.TaskBean;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/4/5.
 */

public interface TaskService {
    public void addTask(TaskBean bean);
}
