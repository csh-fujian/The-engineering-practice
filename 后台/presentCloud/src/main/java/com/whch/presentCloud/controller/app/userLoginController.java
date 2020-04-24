package com.whch.presentCloud.controller.app;

import com.whch.presentCloud.entity.classCourseMember;
import com.whch.presentCloud.entity.classLesson;
import com.whch.presentCloud.entity.result;
import com.whch.presentCloud.entity.userInfo;
import com.whch.presentCloud.service.IService.IClassManageService;
import com.whch.presentCloud.service.IService.IUserLoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


@Controller
public class userLoginController {

    @Autowired
    private IUserLoginService userloginservice;
    @Autowired
    private IClassManageService classManageService;

    @RequestMapping("/login")
    public Map<String,Object> login(@RequestParam("phone") String phone) {
        Map res = userloginservice.IsExistUser(phone);
        return res; 
    }

   
    //测试
    @RequestMapping("/login")
    @ResponseBody
    public result userLogin(@RequestParam("username")String number,@RequestParam("password")String password){
//       System.out.println(tel+password);
        HashMap lessonInfo = new HashMap<>();
        result r = new result();
        if(number == "" || password == ""){
            r.setInfo("帐号密码不能为空");
            r.setState("false");
            return r;
        }

        int flag =userloginservice.IsExistUser(number, password);
        
        if(flag == 1)
        {
            List<classCourseMember> lessons = classManageService.getLessons(number);
            List studentClassList = new ArrayList<>();
            for (classCourseMember lesson : lessons) {
               
                lessonInfo.put("bankeName", lesson.getClassname());
                lessonInfo.put("teacher", lesson.getTeachername());
                lessonInfo.put("description", lesson.getClassname());
                lessonInfo.put("profilePhoto", "");
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
    @RequestMapping("/userLoginOut")
    public String userLoginOutController(HttpServletRequest request){
        request.getSession().removeAttribute("session_user");
        return "login";
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
