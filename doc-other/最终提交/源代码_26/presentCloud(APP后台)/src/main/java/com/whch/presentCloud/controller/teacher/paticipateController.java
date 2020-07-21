/*
 * @Description: 
 * @Version: 1.0
 * @Autor: whc
 * @Date: 2020-06-26 09:35:07
 * @LastEditors: whc
 * @LastEditTime: 2020-06-28 10:43:58
 */
package com.whch.presentCloud.controller.teacher;

import java.util.List;
import java.util.Map;

import com.whch.presentCloud.service.IService.IParticipateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class paticipateController {
    @Autowired
    private IParticipateService participateService;

    @RequestMapping("/banke/id/member/launch-sign")
    public List<Map<String, Object>> getSignHistory(@RequestParam("classId") String classId) {
        return participateService.getSignHistory(classId);
    }
    /**
     * 发起一键签到
     * @param username 教师工号
     * @param classId 班课号
     * @param longitude 经度
     * @param latitude 纬度
     * @return
     */
    @RequestMapping("/banke/id/member/launch-sign/sign-now")
    public String signNow(@RequestParam("username")String  username,@RequestParam("classId")String classId,
    @RequestParam("longitude")String longitude,@RequestParam("latitude")String latitude)
    {
        return participateService.insertSign(username,classId,longitude,latitude,"1",null);

    }
    

/**
     * 发起手势签到
     * @param username 教师工号
     * @param classId 班课号
     * @param longitude 经度
     * @param latitude 纬度
     * @return
     */
    @RequestMapping("/banke/id/member/launch-sign/pose")
    public String poseSignNow(@RequestParam("username")String  username,@RequestParam("classId")String classId,
    @RequestParam("longitude")String longitude,@RequestParam("latitude")String latitude,@RequestParam("posenumber")String posenumber)
    {
        return participateService.insertSign(username,classId,longitude,latitude,"2",posenumber);

    }

    @RequestMapping("/banke/id/member/launch-sign/sign-end")
    public String SignEnd(@RequestParam("signId")String  signId)
    {
        return participateService.updateSign(signId,"1");

    }

    @RequestMapping("/banke/id/member/launch-sign/pose-end")
    public String poseSignEnd(@RequestParam("signId")String  signId)
    {
        return participateService.updateSign(signId,"2");

    }
}