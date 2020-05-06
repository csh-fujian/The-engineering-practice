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
    public result userLogin(@RequestParam("username")String number,@RequestParam("password")String password){
//       System.out.println(tel+password);

        result r = new result();
        if(number == "" || password == ""){
            r.setInfo("帐号密码不能为空");
            r.setState("false");
            return r;
        }

        //获取该用户的角色
        int flag =userloginservice.IsExistUser(number, password);
        
        if(flag == 1)
        {
            List<classCourseMember> lessons = classManageService.getLessons(number);
            List studentClassList = new ArrayList<>();
            for (classCourseMember lesson : lessons) {
                HashMap lessonInfo = new HashMap<>();
                lessonInfo.put("bankeName", lesson.getClassname());
                lessonInfo.put("teacher", lesson.getTeachername());
                lessonInfo.put("description", lesson.getClassname());
                lessonInfo.put("profilePhoto", "");
                studentClassList.add(lessonInfo);
            }
            r.setState("true");
            r.setRole("学生");
            r.setResult(studentClassList);
            return r;
        } else if(flag == 2){

        }
        
        r.setState("false");
        r.setInfo("帐号或用户名错误");
        return r;
        
    }

    /**
     * 退出登录
     * @param request
     * @return
     */
    @RequestMapping("loginOut")
    public String userLoginOutController(HttpServletRequest request){
        request.getSession().removeAttribute("session_user");
        return "login";
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
     * @param user
     * @return
     */
    @GetMapping("foget")
    public userInfo forgetpassword(@RequestBody userInfo user)
    {
        return userloginservice.findbyphone(user.getPhone());
    }


    /**
     * 重置密码
     * @param user
     * @param password
     * @return
     */
    @RequestMapping("setpassword")
    public int setpassword(@RequestBody userInfo user,@RequestParam("password") String password)
    {
        System.out.println(user.getPassword());
        return userloginservice.setpw(user, password);
    }

}
