package com.myfreemarker.dao;

import com.myfreemarker.bean.TaskBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Administrator on 2017/4/5.
 */
@Mapper
public interface TaskDao {
    /**
     * 注册
     *
     * @param taskBean 注册对象
     */
    @Insert("INSERT INTO cm_user(begindate,enddate,remark,registerdate,author,name) values(#{begindate},#{enddate},#{remark},#{registerdate},#{author},#{name})")
    public void addTask(TaskBean taskBean);
}
