package com.whch.presentCloud.controller.teacher;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.whch.presentCloud.service.IService.ITaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 * @Description: 
 * @Version: 1.0
 * @Autor: whc
 * @Date: 2020-06-26 09:34:31
 * @LastEditors: whc
 * @LastEditTime: 2020-07-01 10:22:18
 */
@RestController
public class taskController {
    @Autowired
    private ITaskService taskService;

    @RequestMapping("/banke/id/oneclass")
    public HashMap<String, Object> getAllTasks(@RequestParam("classId") String classId,
            @RequestParam("username") String username)
    {
        return taskService.getTask(username,classId);
    }

    @RequestMapping("/banke/id/oneclass/createWork")
    public String createTask(@RequestParam String classId,@RequestParam String title,@RequestParam String detail,@RequestParam String scroeMax,@RequestParam String endtime,@RequestParam String username){
        return taskService.addTask(username,classId,detail,scroeMax,endtime,title);
    }
}
