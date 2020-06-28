/*
 * @Description: 
 * @Version: 1.0
 * @Autor: whc
 * @Date: 2020-06-25 18:53:13
 * @LastEditors: whc
 * @LastEditTime: 2020-06-26 16:59:01
 */
package com.whch.presentCloud.controller.teacher;

import java.util.List;
import java.util.Map;

import com.whch.presentCloud.service.IService.IClassManageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class classManageController {

    @Autowired
    private IClassManageService classManageService;
    
    
    @RequestMapping("/banke/create")
    public String createClass(@RequestParam("username")String username, @RequestParam("className")String className,@RequestParam("courseName")String courseName,@RequestParam("schoolName")String schoolName,
    @RequestParam("departmentName")String departmentName,@RequestParam("semester")String semester,@RequestParam("studyDemand")String studyDemand,@RequestParam("examDemand")String examDemand)
    {
        return classManageService.addClass(username,className,courseName,schoolName,departmentName,semester,studyDemand,examDemand);
    }
    
    @RequestMapping("/banke/id/detail")
    public Map<String,Object> getClassInfo(@RequestParam("classId") String classId,
    @RequestParam("username") String username){
        return classManageService.getClassInfo(username,classId);
    }

    @RequestMapping("/banke/id/detail/end")
    public String updateClass(@RequestParam("classId") String classId,
    @RequestParam("username") String username,@RequestParam("state")String state)
    {
        return classManageService.updateClass(username,classId,state);
    }

    @RequestMapping("/banke/id/member")
    public List<Map<String,Object>> getMembers(@RequestParam("classId") String classId){
        return classManageService.getMembers(classId);
    }
}
