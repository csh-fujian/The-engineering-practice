/*
 * @Description: app 班课管理模块
 * @Version: 1.0
 * @Autor: whc
 * @Date: 2020-04-17 18:04:31
 * @LastEditors: whc
 * @LastEditTime: 2020-06-30 17:12:23
 */
package com.whch.presentCloud.controller.student;

import java.util.HashMap;
import java.util.Map;

import com.whch.presentCloud.entity.userInfo;
import com.whch.presentCloud.service.IService.IClassManageService;
import com.whch.presentCloud.service.IService.IUserManageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class classController {
    @Autowired
    private IClassManageService classManageService;
    @Autowired
    private IUserManageService userManageService;

    /**
     * 输入班级号获取班课详情
     * @param classId

     * @return
     */
    @RequestMapping("/joinClass")
    @ResponseBody
    public  HashMap<String,Object> joinClass(@RequestParam("classId")String classId)

    {
        HashMap<String,Object> resul = classManageService.getCourse(classId);
        return resul;
    }

    /**
     * 加入班课
     * @param classId
     * @param studentId
     * @return
     */
    @RequestMapping("/join-class/join-in")
    public String joinIn(@RequestParam("classId")String classId , @RequestParam("username")String studentId)
    {
        String resul = classManageService.addCourse(classId,studentId);
        return resul;
    }

    @RequestMapping("/banke/id/one-class")
    public Map<String,Object> getClassInfo(@RequestParam("classId")String classId,@RequestParam("username")String username)
    {
        Map<String,Object> res = classManageService.getLesson(classId,username);
        return res;
    }

   
    /**
     * 退出班课
     * @param username
     * @param classId
     * @return
     */
    @RequestMapping("/login-out")
    public String logout(@RequestParam("username")String username,@RequestParam("classId")String classId){
        return classManageService.logoutLesson(username,classId);
    }

    /**
     * 获得我的设置详情
     * @param username
     * @return
     */
    @RequestMapping("/mine")
    public Map<String, Object> getUserInfo(@RequestParam("username")String username){
        return userManageService.getUserInfo(username);
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @RequestMapping(value = "/mine/profile-update", method = RequestMethod.POST)
    public String updateUserInfo(@RequestBody userInfo user){
        return userManageService.updatebyid(user, user.getNumber());
    }
}