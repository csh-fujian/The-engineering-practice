package com.whch.presentCloud.mapper;

import com.github.pagehelper.Page;
import com.whch.presentCloud.entity.sysparameter;
import com.whch.presentCloud.entity.userInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


public interface sysparameterMapper {


    @Select("select * from systemparameter")
    List<sysparameter> findsysparameter();

    @Delete("delete from systemparameter where name = #{name}")
    int delete(String name);

    @Update("update systemparameter s set s.name = #{name}, s.value = #{value} where s.name = #{record}")
    int updatesys(@Param("value") Integer value, @Param("name") String name, @Param("record") String record);
}