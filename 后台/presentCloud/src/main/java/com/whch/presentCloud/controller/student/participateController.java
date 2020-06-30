package com.whch.presentCloud.controller.student;

import java.util.Map;

import com.whch.presentCloud.entity.ResponseData;
import com.whch.presentCloud.entity.result;
import com.whch.presentCloud.service.IService.IClassManageService;
import com.whch.presentCloud.utils.IPUtils;
import com.whch.presentCloud.utils.ResponseDataUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 * @Description: 
 * @Version: 1.0
 * @Autor: whc
 * @Date: 2020-06-26 09:35:54
 * @LastEditors: whc
 * @LastEditTime: 2020-06-29 19:01:03
 */ 
@RestController
public class participateController {
    @Autowired
    private IClassManageService classManageService;

     /**
     * 发起签到
     * @param classId
     * @return
     */
    @RequestMapping("/participate")
    public ResponseData participate(@RequestParam("classId")String classId)
    {
        
        return classManageService.getSignType(classId);
    }

    /**
     * 一键签到
     * @param username 学号
     * @param ip
     * @return
     * @throws Exception
     */
    @RequestMapping("/participate/1")
    public Map<String ,Object> participate(@RequestParam("username")String username,@RequestParam("classId")String classId, @RequestParam("longitude")String longitude,@RequestParam("latitude")String latitude,@RequestParam("signId")String signId) throws Exception {
        
        return classManageService.isSucced(username,classId,longitude,latitude,1,"",signId);
    }

    /**
     * 手势签到
     * @param username 学号
     * @param classId
     * @param number 1-4-5-7-9
     * @param ip ip地址
     * @return 
     * @throws Exception
     */

    @RequestMapping("/participate/2")
    public Map<String ,Object> shouShiQiandao(@RequestParam("username")String username,@RequestParam("classId")String classId, @RequestParam("poseNumber")String number, @RequestParam("longitude")String longitude,@RequestParam("latitude")String latitude, @RequestParam("signId")String signId) throws Exception {
        
        return classManageService.isSucced(username,classId,longitude,latitude,2,number,signId);
    }
}
