package com.whch.presentCloud.controller.web;

import com.whch.presentCloud.entity.classCourseMember;
import com.whch.presentCloud.entity.result;
import com.whch.presentCloud.entity.userInfo;
import com.whch.presentCloud.service.IService.IClassManageService;
import com.whch.presentCloud.service.IService.IUserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("webinitialization")
public class WebUserLoginController {

    @Autowired
    private IUserLoginService userloginservice;
    @Autowired
    private IClassManageService classManageService;

   
    //测试
    @RequestMapping("login")
    @ResponseBody
    public result userLogin(@RequestParam("username")String nickname,@RequestParam("password")String password, HttpSession session){
//       System.out.println(tel+password);

        result r = new result();
        if(nickname == "" || password == ""){
            r.setInfo("用户名或密码不能为空");
            r.setState("false");
            return r;
        }

        userInfo user = userloginservice.login(nickname, password);

        if(user == null) {
            session.removeAttribute("loginUser");
            r.setInfo("用户名或密码不能为空");
            r.setState("false");
            return r;
        }

        session.setAttribute("loginUser", user);
        r.setState("true");
        return r;
    }

    /**
     *
     * @param session
     * @return
     */
    @RequestMapping("loginOut")
    public String userLoginOutController(HttpSession session){
        session.removeAttribute("user");
        return "1";
    }

    /**
     * 注册
     */
    @PostMapping("register")
    public result register(@RequestBody userInfo user)
    {
        return userloginservice.regist(user);
    }


    /**
     * 忘记密码，通过手机号查询该用户
     * @param phone
     * @return
     */
    @GetMapping("foget")
    public result forgetpassword(@RequestParam("phone") String phone, HttpSession session)
    {
        result r = new result();
        userInfo user = userloginservice.findbyphone(phone);
        if(user == null) {
            session.removeAttribute("fogetUser");
            r.setInfo("该用户不存在");
            r.setState("false");
            return r;
        }

        session.setAttribute("fogetUser", user);
        r.setState("true");
        return r;
    }


    /**
     * 重置密码
     * @param password
     * @return
     */
    @RequestMapping("setpassword")
    public int setpassword(@RequestParam("password") String password, HttpSession session)
    {
        userInfo user = (userInfo) session.getAttribute("forgetUser");
        session.removeAttribute("fogetUser");
        return userloginservice.setpw(user, password);
    }

}
