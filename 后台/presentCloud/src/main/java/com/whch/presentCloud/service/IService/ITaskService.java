package com.whch.presentCloud.service.IService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.whch.presentCloud.entity.ResponseData;

import org.springframework.stereotype.Service;

/*
 * @Description: 
 * @Version: 1.0
 * @Autor: whc
 * @Date: 2020-06-26 09:41:03
 * @LastEditors: whc
 * @LastEditTime: 2020-07-01 10:22:33
 */ 

public interface ITaskService {

	HashMap<String, Object> getTask(String username, String classId);

	String addTask(String username, String classId, String detail, String scroeMax, String endtime, String title);

	ResponseData submitTask(String username, String workId, String workcontent);
    
}
