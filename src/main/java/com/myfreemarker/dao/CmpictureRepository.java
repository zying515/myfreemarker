package com.myfreemarker.dao;

import com.myfreemarker.bean.CmPicture;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator on 2017/4/22.
 */
public interface CmpictureRepository extends JpaRepository<CmPicture, Long> {

}
