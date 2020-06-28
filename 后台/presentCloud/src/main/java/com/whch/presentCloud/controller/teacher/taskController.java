package com.whch.presentCloud.controller.teacher;

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
 * @LastEditTime: 2020-06-26 10:18:44
 */
@RestController
public class taskController {
    @Autowired
    private ITaskService taskService;

    @RequestMapping("/banke/id/oneclass")
    public List<Map<String, Object>> getAllTasks(@RequestParam("classId") String classId,
            @RequestParam("username") String username)
    {
        return taskService.getTask(username,classId);
    }
}
