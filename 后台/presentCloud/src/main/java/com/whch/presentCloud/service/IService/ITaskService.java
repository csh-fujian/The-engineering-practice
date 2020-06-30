package com.whch.presentCloud.service.IService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

/*
 * @Description: 
 * @Version: 1.0
 * @Autor: whc
 * @Date: 2020-06-26 09:41:03
 * @LastEditors: whc
 * @LastEditTime: 2020-06-26 10:15:08
 */ 

public interface ITaskService {

	HashMap<String, Object> getTask(String username, String classId);
    
}
