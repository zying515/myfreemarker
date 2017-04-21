package com.myfreemarker.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/4/6.
 */
public class PageBean<T> {
    private String curpage;//当前页
    private String pageSize;//每页显示的记录数
    private String totalNum;//总记录数
    private String totalPage;//总页数
    private List<T> List;//查询出来的数据

    public String getCurpage() {
        return curpage;
    }

    public void setCurpage(String curpage) {
        this.curpage = curpage;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(String totalNum) {
        this.totalNum = totalNum;
    }

    public String getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(String totalPage) {
        this.totalPage = totalPage;
    }

    public java.util.List<T> getList() {
        return List;
    }

    public void setList(java.util.List<T> list) {
        List = list;
    }
}
