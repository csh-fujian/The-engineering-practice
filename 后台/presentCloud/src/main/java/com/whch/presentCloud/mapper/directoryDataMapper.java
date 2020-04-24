package com.whch.presentCloud.mapper;

import java.util.List;

import com.whch.presentCloud.entity.directoryData;

import org.apache.ibatis.annotations.Select;

public interface directoryDataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(directoryData record);

    int insertSelective(directoryData record);

    directoryData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(directoryData record);

    int updateByPrimaryKey(directoryData record);

    @Select("select * from directorydata")
	List<directoryData> getAll();
}