package com.whch.presentCloud.mapper;

import java.util.List;

import com.whch.presentCloud.entity.checkInHistory;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface checkInHistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(checkInHistory record);

    int insertSelective(checkInHistory record);

    checkInHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(checkInHistory record);

    int updateByPrimaryKey(checkInHistory record);

    @Select("select * from checkinhistory where Number = #{number}")
	List<checkInHistory> findOne(@Param("number") String number);

    @Select("select * from checkinhistory")
	List<checkInHistory> getAll();

    @Select("select * from checkinhistory where Id = #{id}")
	List<checkInHistory> getHistories(@Param("id") Integer id);
}