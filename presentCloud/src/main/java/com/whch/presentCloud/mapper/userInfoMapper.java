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

    @Select("select * from userinfo where Number = #{number} and password = #{password}")
	userInfo findOne(@Param("number") String number, @Param("password") String password);

    @Select("select * from userinfo")
    List<userInfo> getAll();

}