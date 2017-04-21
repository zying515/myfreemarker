package com.myfreemarker.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/4/10.
 */
@Entity
@Table(name="cm_task")
public class CmTask implements Serializable {

    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "taskid", updatable = false)
    private Integer taskid;
    @Column(nullable = false,name = "name")
    private String name;
    @Column(nullable = false,name = "author")
    private String  author;
    @Column(nullable = false,name = "remark")
    private String remark;
    @Column(nullable = false,name = "begindate")
    private Date begindate;
    @Column(nullable = false,name = "enddate")
    private Date enddate;
    @Column(nullable = false,name = "registerdate")
    private Date registerdate;
    @Column(nullable = false,name = "isfinish")
    private int isfinish;
//
//   @Column(nullable = false,name = "deleted")
//    private boolean deleted = false;


    public int getIsfinish() {
        return isfinish;
    }

    public void setIsfinish(int isfinish) {
        this.isfinish = isfinish;
    }



    public Integer getTaskid() {
        return taskid;
    }

    public void setTaskid(Integer taskid) {
        this.taskid = taskid;
    }

    public Date getRegisterdate() {
        return registerdate;
    }

    public void setRegisterdate(Date registerdate) {
        this.registerdate = registerdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getBegindate() {
        return begindate;
    }

    public void setBegindate(Date begindate) {
        this.begindate = begindate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

//    public boolean isDeleted() {
//        return deleted;
//    }
//
//    public void setDeleted(boolean deleted) {
//        this.deleted = deleted;
//    }



}
