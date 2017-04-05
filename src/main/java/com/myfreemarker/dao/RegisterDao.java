package com.myfreemarker.dao;

import com.myfreemarker.bean.City;
import com.myfreemarker.bean.UserBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Administrator on 2017/3/30.
 */
@Mapper
public interface RegisterDao {
    /**
     * 注册
     *
     * @param userBean 注册对象
     */
    @Insert("INSERT INTO cm_user(phone,username,password) values(#{phone},#{username},#{password})")
    public void Register(UserBean userBean);
}
