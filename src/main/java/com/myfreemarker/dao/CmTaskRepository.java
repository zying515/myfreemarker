package com.myfreemarker.dao;

import com.myfreemarker.bean.CmTask;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/4/10.
 */
public interface CmTaskRepository extends PagingAndSortingRepository<CmTask, Integer> {
   // Page<CmTask> findByDeletedFalse(Pageable pageable);
    Page<CmTask> findAll(Pageable pageable);
}
