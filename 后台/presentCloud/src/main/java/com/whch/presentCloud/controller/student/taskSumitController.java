package com.whch.presentCloud.controller.student;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.whch.presentCloud.entity.ResponseData;
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
 * @LastEditTime: 2020-06-30 21:04:16
 */
@RestController
public class taskSumitController {
    @Autowired
    private ITaskService taskService;

 

    @RequestMapping("/banke/id/oneclass/upLoadWork")
    public ResponseData createTask(@RequestParam String workId,@RequestParam String workcontent,@RequestParam String username){
        return taskService.submitTask(username,workId,workcontent);
    }
}
