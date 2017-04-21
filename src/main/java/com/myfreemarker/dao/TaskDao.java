package com.myfreemarker.dao;

import com.myfreemarker.bean.PageBean;
import com.myfreemarker.bean.TaskBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2017/4/5.
 */
@Mapper
public interface TaskDao {
    /**
     * 添加任务
     *
     * @param taskBean 任务对象
     */
    @Insert("INSERT INTO cm_task(begindate,enddate,remark,registerdate,author,name) values(#{begindate},#{enddate},#{remark},#{registerdate},#{author},#{name})")
    public void addTask(TaskBean taskBean);

    /**
     * 分页查询所有任务
     * @return
     */
    @Select("select * from cm_task LIMIT #{curpage},#{pageSize} ")
    public List<TaskBean> selectTaskList(PageBean<TaskBean> pageBean);

    /**
     * 总记录数
     * @return
     */
    @Select("select count(1) num from cm_task")
    public int selectTaskNum();

    /**
     * 查询单个任务
     */
    @Select("select * from cm_task where taski = #{taskid} ")
    public TaskBean selectTaskObject(TaskBean bean);

}
