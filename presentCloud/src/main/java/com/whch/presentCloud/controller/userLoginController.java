package com.whch.presentCloud.controller;


import com.whch.presentCloud.entity.userInfo;
import com.whch.presentCloud.service.IService.IUserLoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/user")
public class userLoginController {

    @Autowired
    private IUserLoginService userloginservice;

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

   
    //测试
    @RequestMapping("/userLogin")
    @ResponseBody
    public String userLogin(@RequestParam("number")String number,@RequestParam("password")String password,HttpServletRequest request){
//       System.out.println(tel+password);
        if(number == "" || password == ""){
            request.setAttribute("msg","账号密码不能为空");
            return "账号密码不能为空";
        }

        userInfo User=userloginservice.getUserInfo(number, password);
        

        return User.getName(); }

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
