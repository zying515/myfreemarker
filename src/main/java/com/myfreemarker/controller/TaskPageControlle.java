package com.myfreemarker.controller;

import com.myfreemarker.dao.CmTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/4/11.
 */
@RestController
public class TaskPageControlle {
    @Autowired
    private CmTaskRepository cmTaskRepository;
    @RequestMapping(value = "/params", method= RequestMethod.GET)
    public Iterable getEntryByParams(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                     @RequestParam(value = "size", defaultValue = "15") Integer size) {
        Sort sort = new Sort(Sort.Direction.DESC, "taskid");
        page=page<=0?1:page;
        page=page>=1?page-1:page;
        Pageable pageable = new PageRequest(page, size, sort);
        Iterable itask=cmTaskRepository.findAll(pageable);
        System.out.println("itask="+itask);
        ModelAndView mv = new ModelAndView("index");
        return itask;
    }
}
