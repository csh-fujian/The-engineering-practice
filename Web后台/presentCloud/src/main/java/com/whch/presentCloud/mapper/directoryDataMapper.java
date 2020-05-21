package com.whch.presentCloud.mapper;

import java.util.List;

import com.whch.presentCloud.entity.directoryData;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface directoryDataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(directoryData record);

    int insertSelective(directoryData record);

    directoryData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(directoryData record);

    int updateByPrimaryKey(directoryData record);

    @Select("select * from directorydata")
	List<directoryData> getAll();

    @Select("select d.valued from directorydata d where d.keyd = #{keyd}")
    String findbykey(@Param("keyd") String keyd);

    @Select("select d.valued from directorydata d where d.typed = #{typed} and defaultvalued = 1")
    String finddefault(@Param("typed") String typed);

    @Select("select d.valued from directorydata d where d.typed = #{typed}")
    List<String> findAllvalue(@Param("typed") String typed);

    @Delete("delete d from directorydata d where d.keyd = #{keyd}")
    int deletebykey(@Param("keyd") String keyd);

    @Select("select * from directorydata d where d.typed = #{typed}")
    List<directoryData> findbytype(@Param("typed") String typed);

    @Update("update userinfo u set u.sex = #{valued} where u.sex = #{record}")
    int updatebyvalue11(@Param("valued") String valued, @Param("keyd") String keyd, @Param("record") String record);

    @Update("update directorydata d set d.keyd = #{keyd}, d.valued = #{valued}, d.defaultvalued = #{defaultvalued} where d.valued = #{record}")
    int updatebyvalue12(@Param("valued") String valued, @Param("keyd") String keyd, @Param("defaultvalued") Integer defaultvalued, @Param("record") String record);

    @Update("update role r set r.name = #{valued} where r.name = #{record}")
    int updatebyvalue21(@Param("valued") String valued, @Param("keyd") String keyd, @Param("record") String record);

    @Update("update directorydata d set d.keyd = #{keyd}, d.valued = #{valued}, d.defaultvalued = #{defaultvalued} where d.valued = #{record}")
    int updatebyvalue22(@Param("valued") String valued, @Param("keyd") String keyd, @Param("defaultvalued") Integer defaultvalued, @Param("record") String record);

    @Update("update userinfo u set u.role = #{valued} where u.role = #{record}")
    int updatebyvalue23(@Param("valued") String valued, @Param("keyd") String keyd, @Param("record") String record);

    @Update("update directorydata d set d.keyd = #{keyd}, d.valued = #{valued}, d.defaultvalued = #{defaultvalued} where d.valued = #{record}")
    int updatebyvalue0(@Param("valued") String valued, @Param("keyd") String keyd, @Param("defaultvalued") Integer defaultvalued, @Param("record") String record);
}