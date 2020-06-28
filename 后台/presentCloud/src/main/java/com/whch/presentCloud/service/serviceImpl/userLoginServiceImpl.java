package com.whch.presentCloud.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.whch.presentCloud.entity.LoginResult;
import com.whch.presentCloud.entity.classCourseMember;
import com.whch.presentCloud.entity.classLesson;
import com.whch.presentCloud.entity.result;
import com.whch.presentCloud.entity.userInfo;
import com.whch.presentCloud.repository.IRepository.userInfoRepository;
import com.whch.presentCloud.service.IService.IClassManageService;
import com.whch.presentCloud.service.IService.IUserLoginService;

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
            else if(user.getRole().equals("教师"))
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
    public Map<String,Object> IsExistUser(String phone) {
        userInfo user = userInfoRepo.get(phone);
        
        if(user != null){
            HashMap res = new HashMap<String,Object>();
            res.put("username", user.getNumber());
            res.put("role", user.getRole());
            
            return res;
        }
        return null;
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
                if(lesson.getType().equals("over"))
                {
                    continue;
                }
                HashMap lessonInfo = new HashMap<>();
                lessonInfo.put("bankeName", lesson.getClassname());
                lessonInfo.put("teacher", lesson.getTeachername());
                lessonInfo.put("description", lesson.getType());
                lessonInfo.put("semster", lesson.getClasstime());
                lessonInfo.put("master", lesson.getMaster());
                lessonInfo.put("profilePhoto", "");
                studentClassList.add(lessonInfo);
            }


            return studentClassList;
        }
        return null;
    }


}