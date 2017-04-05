package com.myfreemarker.dao;

import com.myfreemarker.bean.City;
import com.myfreemarker.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Administrator on 2017/3/31.
 */
@Mapper
public interface LoginDao {

    @Select("SELECT * FROM cm_user WHERE username = #{username} and password=#{password}")
    UserBean login(UserBean userBean);
}
