/*
 * @Description: 
 * @Version: 1.0
 * @Autor: whc
 * @Date: 2020-04-09 22:48:05
 * @LastEditors: whc
 * @LastEditTime: 2020-06-30 07:54:07
 */ 
package com.whch.presentCloud.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.whch.presentCloud.entity.classCourseMember;
import com.whch.presentCloud.entity.classLesson;
import com.whch.presentCloud.entity.result;
import com.whch.presentCloud.entity.userInfo;
import com.whch.presentCloud.repository.IRepository.userInfoRepository;
import com.whch.presentCloud.service.IService.IClassManageService;
import com.whch.presentCloud.service.IService.IUserLoginService;
import com.whch.presentCloud.service.IService.IUserManageService;
import com.whch.presentCloud.utils.TokenUtil;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userLoginServiceImpl implements IUserLoginService {

    @Autowired
    private userInfoRepository userInfoRepo;
    @Autowired
    private IUserLoginService userloginservice;
    @Autowired
    private IClassManageService classManageService;
    @Autowired
    private IUserManageService userService;

    //判断用户的角色
    @Override
    public int IsExistUser(String number, String password) {
        userInfo user1 = new userInfo();
        user1.setName(number);
        user1.setPassword(password);
        userInfo user = userInfoRepo.get(user1);
        System.out.println(user.getRole());
        if (user != null) {
            if(user.getRole().equals("学生"))
            {
                return 1;
            }
            else if(user.getRole().equals("老师"))
            {
                return 2;
            }
           
            
        }
        return 0;
    }

    //添加用户
    @Override
    public int addUser(userInfo user) {

        return userInfoRepo.add(user);

    }

    //通过手机号查询用户是否存在，若存在返回含用户名和角色的res
    @Override
    public result phoneLoginResult(String phone,String remoteAddr) {
        userInfo user = userInfoRepo.get(phone);
        result resu = new result();
        if(user != null){
            result re = userLoginResult(user.getNumber(), user.getPassword(), remoteAddr);
            HashMap res = new HashMap<String,Object>();
            res.put("username", user.getNumber());
            re.setMap(res);
            
            return re;
        }
        resu.setState("false");
        resu.setInfo("手机号有误！");
        return resu;
    }

    @Override
    public userInfo findbyphone(String phone)
    {
        userInfo user = userInfoRepo.get(phone);
        if(user != null){
            return user;
        }
        return null;
    }

    @Override
    public result regist(userInfo user) {
        result Registresult = new result();
        Registresult.setState("false");
        Registresult.setRole(null);
        try {
            userInfo existUser = userInfoRepo.get(user.getNumber(),user.getNickname());
            if(existUser != null){
                //如果用户名或学/工号已存在
                Registresult.setInfo("用户名或学/工号已存在");
            }else{
                userInfoRepo.add(user);
                //System.out.println(user.getNumber());
                Registresult.setInfo("注册成功");
                Registresult.setRole(user.getRole());
            }
        } catch (Exception e) {
            Registresult.setState(e.getMessage());
            e.printStackTrace();
        }
        return Registresult;
    }

    @Override
    public int setpw(userInfo user, String password) {
        user.setPassword(password);
        return userInfoRepo.update(user, user.getNumber());
    }

    @Override
    public userInfo login(String nickname, String password) {
        return userInfoRepo.login(nickname, password);
    }

    @Override
    public result loginResult(String number, String password) {
        // HashMap lessonInfo = new HashMap<>();
        result r = new result();
        int flag =IsExistUser(number, password);
        // System.out.println(flag);
        if(flag == 1)
        {

            r.setState("true");
            r.setRole("学生");
//            r.setResult(studentClassList);
            
            return r;
        } else if(flag == 2){

            r.setState("true");
            r.setRole("老师");
//            r.setResult(studentClassList);

            return r;
        }
        return null;
    }



    public List<Map<String,Object>> classsInfo(String number, int flag) {
        List studentClassList = new ArrayList<>();

        if(flag == 1)
        {
            List<classCourseMember> lessons = classManageService.getLessons(number);

            for (classCourseMember lesson : lessons) {
                HashMap lessonInfo =  classManageService.getCourse(lesson.getClassid().toString());
                if(lessonInfo.get("state").equals("ok")){
                    studentClassList.add(lessonInfo);
                }
                
            }


            return studentClassList;
        } else if(flag == 2){
            List<classLesson> lessons = classManageService.getBanke(number);
            for (classLesson lesson : lessons) {
                if(lesson.getType() != null)
                {
                    continue;
                }
                HashMap lessonInfo = new HashMap<>();
                lessonInfo.put("bankeName", lesson.getClassname());
                lessonInfo.put("teacher", lesson.getTeachername());
                lessonInfo.put("description", lesson.getType());
                lessonInfo.put("semster", lesson.getClasstime());
                lessonInfo.put("classId", lesson.getClassid());
                lessonInfo.put("master", lesson.getMaster());
                lessonInfo.put("profilePhoto", "");
                studentClassList.add(lessonInfo);
            }


            return studentClassList;
        }
        return null;
    }

    @Override
    public result userLoginResult(String number, String password,String remoteAddr) {
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
//            subject.login(usernamePasswordToken);
            userInfo role = userService.getUser(number);
            //生成token
            String token = TokenUtil.getToken(role.getName(), Integer.toString(role.getId()) , remoteAddr);
            
           
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


}