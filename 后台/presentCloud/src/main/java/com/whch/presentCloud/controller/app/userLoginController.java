/*
 * @Description: 
 * @Version: 1.0
 * @Autor: whc
 * @Date: 2020-04-09 22:48:05
 * @LastEditors: whc
 * @LastEditTime: 2020-05-23 13:07:56
 */ 
package com.whch.presentCloud.controller.app;

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

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
    public ResponseData logout() {
        Subject subject = SecurityUtils.getSubject();
        //注销
        subject.logout();
        return ResponseDataUtil.success("成功注销！");
    }

    
    
    @RequestMapping("/loginbyphone")
    public Map<String,Object> login(@RequestParam("phone") String phone) {
        Map res = userloginservice.IsExistUser(phone);
        return res;
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public result userLogin(@RequestParam("username")String number,@RequestParam("password")String password, HttpServletRequest request){
//       System.out.println(tel+password);
        HashMap lessonInfo = new HashMap<>();
        result r = new result();
        if(number == "" || password == ""){
            r.setInfo("帐号密码不能为空");
            r.setState("false");
            return r;
        }


        try {
            //shiro 用户权限认证 教师/学生
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(number, password);
            subject.login(usernamePasswordToken);
            userInfo role = userService.getUser(number);
            //生成token
            String token = TokenUtil.getToken(role.getName(), Integer.toString(role.getId()) , request.getRemoteAddr());
            
           
            //返回登录结果
            result r1 = userloginservice.loginResult(number, password);
            //返回token
            r1.setToken(token);
            return r1;
        } catch (Exception e) {
            e.printStackTrace();
            r.setState("false");
            r.setInfo("帐号或用户名错误");
            return r;
        }
        
    }

    @RequestMapping(value = "/noLogin", method = RequestMethod.GET)
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
        userInfo user = new userInfo(studentId,passWord,Name,school,department,role,phone);
        int flag = userloginservice.addUser(user);

        if(flag == 1)
        {
            return "true";
        }
        return "false";
    }

    
}
