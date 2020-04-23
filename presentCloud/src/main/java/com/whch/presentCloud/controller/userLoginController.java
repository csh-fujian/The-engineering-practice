package com.whch.presentCloud.controller;


import com.whch.presentCloud.entity.LoginResult;
import com.whch.presentCloud.entity.userInfo;
import com.whch.presentCloud.service.IService.IUserLoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/user")
public class userLoginController {

    @Autowired
    private IUserLoginService userloginservice;



    @PostMapping(value = "/regist")
    public LoginResult regist(userInfo user){
        return userloginservice.regist(user);
    }
    /**
     * 登录
     * @param user 参数封装
     * @return LoginResult
     */
    @PostMapping(value = "/login")
    public LoginResult login(userInfo user){
        return userloginservice.login(user);
    }

    /**
     * 退出登录
     * @param request
     * @return
     */
    @RequestMapping("/userLoginOut")
    public String userLoginOutController(HttpServletRequest request){
        request.getSession().removeAttribute("session_user");
        return "login";
    }

}
