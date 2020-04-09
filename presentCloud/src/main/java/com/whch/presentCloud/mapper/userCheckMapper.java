package com.whch.presentCloud.mapper;

import java.util.List;

import com.whch.presentCloud.entity.userCheck;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface userCheckMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(userCheck record);

    int insertSelective(userCheck record);

    userCheck selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(userCheck record);

    int updateByPrimaryKey(userCheck record);

    @Select("select * from usercheck where Fk_UserInfo_UserCheck_Id = #{userId}")
	List<userCheck> findOne(@Param("userId") Integer userId);
}