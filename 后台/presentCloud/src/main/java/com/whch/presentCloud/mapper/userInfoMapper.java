package com.whch.presentCloud.mapper;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.whch.presentCloud.entity.role;
import com.whch.presentCloud.entity.userInfo;

import org.apache.ibatis.annotations.*;


public interface userInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(userInfo record);

    int insertSelective(userInfo record);

    userInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(@Param("record") userInfo record, @Param("oldid") Integer id);

    int updateByPrimaryKeyWithBLOBs(userInfo record);

    int updateByPrimaryKey(userInfo record);

    Page<userInfo> findByPaging();

    List<userInfo> multiquery(Integer id, String role, String school, String department);

    @Select("select * from userinfo u where u.nickname = #{nickname} and u.password = #{password}")
	userInfo findOne(@Param("name")String nickname, @Param("password")String password);

    @Select("select * from userinfo")
    List<userInfo> getAll();

    @Select("select * from userinfo u where u.id = #{id} or u.nickname= #{nickname}")
    userInfo getUser1(@Param("id")Integer id, @Param("nickname")String nickname);

    @Select("select * from userinfo where Phone = #{phone}")
	userInfo getUser(@Param("phone")String phone);

}