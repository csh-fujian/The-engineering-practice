/*
 * @Description: 
 * @Version: 1.0
 * @Autor: whc
 * @Date: 2020-04-09 22:48:05
 * @LastEditors: whc
 * @LastEditTime: 2020-07-02 10:16:55
 */ 
package com.whch.presentCloud.controller.student;

import com.whch.presentCloud.entity.ResponseData;
import com.whch.presentCloud.entity.classCourseMember;
import com.whch.presentCloud.entity.classLesson;
import com.whch.presentCloud.entity.result;
import com.whch.presentCloud.entity.userInfo;
import com.whch.presentCloud.service.IService.IClassManageService;
import com.whch.presentCloud.service.IService.IUserLoginService;
import com.whch.presentCloud.service.IService.IUserManageService;
import com.whch.presentCloud.utils.ResponseDataUtil;
import com.whch.presentCloud.utils.TokenUtil;

import org.apache.http.HttpResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class userLoginController {

    @Autowired
    private IUserLoginService userloginservice;
    @Autowired
    private IClassManageService classManageService;
    @Autowired
    private IUserManageService userService;

   

    @RequestMapping(value = "/noAuthorize")
    @ResponseBody
    public ResponseData notRole() {
    
        return ResponseDataUtil.authorizationFailed("您没有权限！");
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData logout(HttpServletRequest request,HttpServletResponse response)  {
        // Subject subject = SecurityUtils.getSubject();
        Subject subject = SecurityUtils.getSubject();
        //注销
        subject.logout();
        return ResponseDataUtil.success("成功注销！");
    }

    
    
    @RequestMapping(value="/loginbyphone", method = RequestMethod.POST)
    public result login(@RequestParam("phone") String phone, HttpServletRequest request) {
        
        return userloginservice.phoneLoginResult(phone,request.getRemoteAddr());
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public result userLogin(@RequestParam("phone")String number,@RequestParam("password")String password, HttpServletRequest request){
//       System.out.println(tel+password);
      return userloginservice.userLoginResult(number,password,request.getRemoteAddr());
        
    }


    @RequestMapping("/banke")
    public List<Map<String,Object>> banke(@RequestParam("username")String username,@RequestParam("flag")String flag)
    {
        return userloginservice.classsInfo(username, Integer.parseInt(flag));
    }
    @RequestMapping(value = "/noLogin", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData notLogin() {
        return ResponseDataUtil.failure("请先登录！");
    }

    /**
     * 注册
     */
    @RequestMapping("/register")
    public String register(@RequestParam("Name")String Name,@RequestParam("status")String role,
    @RequestParam("studentId")String studentId,@RequestParam("phone")String phone,@RequestParam("passWord")String passWord,
    @RequestParam("school")String school,@RequestParam("department")String department)
    {
        
        int flag = userloginservice.insertUser(studentId,passWord,Name,school,department,role,phone);

        if(flag == 1)
        {
            return "true";
        }
        return "false";
    }

    @RequestMapping("/resetpassword")
    @ResponseBody
    public ResponseData resetpassword(@RequestParam("phone")String phone,@RequestParam("newPassWord")String newPassWord) {
        return userloginservice.setPassword(phone,newPassWord);
    }
}
