package com.whch.presentCloud.mapper;

import com.github.pagehelper.Page;
import com.whch.presentCloud.entity.userInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


public interface userInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(userInfo record);

    int insertSelective(userInfo record);

    userInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(@Param("record") userInfo record, @Param("oldnumber") String oldnumber);

    int updateByPrimaryKeyWithBLOBs(userInfo record);

    int updateByPrimaryKey(userInfo record);

    Page<userInfo> findByPaging();

    List<userInfo> multiquery(String number, String role, String school, String department);

    @Update("update userinfo u set u.password = #{password} where u.number=#{number}")
    void setpassword(@Param("password")String password, @Param("number")String number);

    @Select("select * from userinfo u where u.nickname = #{nickname} and u.password = #{password}")
	userInfo findOne(@Param("nickname")String nickname, @Param("password")String password);

    @Select("select * from userinfo")
    List<userInfo> getAll();

    @Select("select * from userinfo u where u.number = #{number} or u.nickname= #{nickname}")
    userInfo getUser1(@Param("number")String number, @Param("nickname")String nickname);

    @Select("select * from userinfo where Phone = #{phone}")
	userInfo getUser(@Param("phone")String phone);

    @Delete("delete from userinfo where number = #{number}")
    int deleteuser(@Param("number") String number);
}