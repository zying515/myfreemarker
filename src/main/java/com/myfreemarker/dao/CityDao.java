package com.myfreemarker.dao;

import com.myfreemarker.bean.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 城市 DAO 接口类
 *
 * Created by bysocket on 07/02/2017.
 */
@Mapper
public interface CityDao {

    /**
     * 根据城市名称，查询城市信息
     * @param cityName 城市名
     */
    @Select("SELECT * FROM CITY WHERE city_name = #{cityName}")
    City findByName(@Param("cityName") String cityName);
}
