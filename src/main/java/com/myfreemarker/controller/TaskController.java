package com.myfreemarker.controller;

import com.fasterxml.jackson.databind.deser.Deserializers;
import com.myfreemarker.bean.CmTask;
import com.myfreemarker.bean.PageBean;
import com.myfreemarker.bean.TaskBean;
import com.myfreemarker.dao.CmTaskRepository;
import com.myfreemarker.service.TaskService;
import com.myfreemarker.util.JumpUrlUtil;
import com.myfreemarker.util.WebSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.criteria.Order;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2017/4/3.
 */
@Controller
@RequestMapping("/task")
public class TaskController  extends BaseController{
   private static final String dateFormat      = "yyyy-MM-dd HH:mm:ss";
   private static final String shortDateFormat = "yyyy-MM-dd";
   @Autowired
   private TaskService taskService;
    @Autowired
    private CmTaskRepository cmTaskRepository;
   @RequestMapping("/home")
    public String toIndex(Map<String,Object> map, HttpSession session){
        initRegisterFreemarker();
        String url = getBaseUrl();
        map.put("baseUrl",url);
       String name=(String) session.getAttribute(WebSecurityConfig.SESSION_KEY);
       if(name==null||name.length()<=0){
           return JumpUrlUtil.LOGIN_HTML;
       }
    return JumpUrlUtil.TASK_HTML;

    }
    @RequestMapping("/home/add")
    public String addTask(TaskBean bean, Map<String,Object> map, HttpSession session){
        initRegisterFreemarker();
        String url = getBaseUrl();
        map.put("baseUrl",url);
        String name=(String) session.getAttribute(WebSecurityConfig.SESSION_KEY);
        if(name==null||name.length()<=0){
            return JumpUrlUtil.LOGIN_HTML;
        }
        bean.setAuthor(name);
        bean.setRegisterdate(new Date());
        taskService.addTask(bean);
        return JumpUrlUtil.TASK_PAGE_HTML;


    }
    @RequestMapping("/home/selectPageTask")
    public PageBean<TaskBean> selectTask(TaskBean bean){
        System.out.println("查询任务....");
        PageBean<TaskBean> pageBean= new PageBean<TaskBean>();
        if(bean==null){

        }
        List<TaskBean> listTaskBean=new ArrayList<TaskBean>();
        TaskBean taskBean = new TaskBean();
        taskBean.setRegisterdate(new Date());
        taskBean.setAuthor("aaa");
        taskBean.setName("bbb");
        taskBean.setBegindate(new Date());
        taskBean.setEnddate(new Date());
        taskBean.setRemark("aaa");
        listTaskBean.add(taskBean);
        pageBean.setList(listTaskBean);
        System.out.println("查询任务...."+listTaskBean);
        return pageBean;
    }
    @RequestMapping("/page")
    public String jumpPage(Map<String,Object> map,HttpSession session){
        initRegisterFreemarker();
        String url = getBaseUrl();
        map.put("baseUrl",url);
        String name=(String) session.getAttribute(WebSecurityConfig.SESSION_KEY);
        if(name==null||name.length()<=0){
            return JumpUrlUtil.LOGIN_HTML;
        }
        return JumpUrlUtil.TASK_PAGE_HTML;
   }
    @RequestMapping("/newpage")
    public String getEntryByParams(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                         @RequestParam(value = "size", defaultValue = "3") Integer size,Map<String,Object> map,HttpSession session) {
        initRegisterFreemarker();
        String url = getBaseUrl();
        map.put("baseUrl",url);
        String name=(String) session.getAttribute(WebSecurityConfig.SESSION_KEY);
        if(name==null||name.length()<=0){
            return JumpUrlUtil.LOGIN_HTML;
        }
        Sort sort = new Sort(Sort.Direction.DESC, "taskid");
        page=page<=0?1:page;
        map.put("page",page);
        page=page>=1?page-1:page;
        Pageable pageable = new PageRequest(page, size, sort);
        Page<CmTask> iteatorable=cmTaskRepository.findAll(pageable);
        List<CmTask> cmTasks=iteatorable.getContent();
        map.put("pagesize",size);
        map.put("first",iteatorable.isFirst());
        map.put("last",iteatorable.isLast());
        map.put("isFirstPage",iteatorable.nextPageable());
        map.put("totalPages",iteatorable.getTotalPages());
        map.put("rows",iteatorable.getTotalElements());
        map.put("itaskList",iteatorable.getContent());
        return JumpUrlUtil.TASK_PAGE_HTML;
    }






}
