package com.whch.presentCloud.mapper;

import java.util.List;

import com.whch.presentCloud.entity.userInfo;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


public interface userInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(userInfo record);

    int insertSelective(userInfo record);

    userInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(userInfo record);

    int updateByPrimaryKeyWithBLOBs(userInfo record);

    int updateByPrimaryKey(userInfo record);

    @Select("select * from userinfo where name = #{name}")
	userInfo findOne(@Param("name") String name);

    @Select("select u.id from userinfo u where u.name = #{name} and u.password = #{password}")
    Integer login(userInfo user);

    @Select("select * from userinfo")
    List<userInfo> getAll();

}