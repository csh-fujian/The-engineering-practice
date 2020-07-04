package com.whch.presentCloud.controller.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.whch.presentCloud.entity.*;
import com.whch.presentCloud.mapper.userInfoMapper;
import com.whch.presentCloud.service.IService.IClassManageService;

import com.whch.presentCloud.service.IService.IDictionaryDataService;
import com.whch.presentCloud.service.IService.ITokenService;
import com.whch.presentCloud.service.IService.Isha256Service;
import io.jsonwebtoken.Claims;
import org.apache.ibatis.binding.BindingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
@RestController
@RequestMapping("webclass")
public class WebClassController {

    @Autowired
    private IClassManageService classManageService;
    @Autowired
    private ITokenService tokenS;
    @Autowired
    private userInfoMapper userM;
    @Autowired
    private IDictionaryDataService dicd;
    @Autowired
    private Isha256Service sha256S;

    @PostMapping("adminaddclass")
    public Object adminaddclass(@RequestBody classLesson Class){
        JSONObject jsonObject = new JSONObject();
        String id = Class.getTeacherid().toString();
        userInfo user = userM.getTeacherUser(id);
        if (user == null){
            jsonObject.put("message", "该教师id不存在");
            return jsonObject;
        }
        else {
            Date date = new Date();
            Class.setTeacherid(Integer.parseInt(user.getNumber()));
            Class.setTeachername(user.getName());
            Class.setCreattime(date);
            Class.setClasstime("2020-2021-2");
            try{
                classManageService.addCourse(Class);
                jsonObject.put("message", "添加成功");
                return jsonObject;
            }catch (DuplicateKeyException e){
                jsonObject.put("message", "添加失败,该班课id已存在");
                return jsonObject;
            }
        }
    }

    @PostMapping("addclass")
    public Object addclass(@RequestBody classLesson Class, HttpServletRequest request) throws Exception {
        String Token = request.getHeader("Authorization");
        Claims claims = tokenS.parseJWT(Token);
        String subject = claims.getSubject();
        JSONObject jsonObject = JSON.parseObject(subject);
        userInfo user = JSON.toJavaObject(jsonObject, userInfo.class);
        Class.setTeachername(user.getName());
        Class.setTeacherid(Integer.parseInt(user.getNumber()));
        Date date = new Date();
        Class.setCreattime(date);
        Class.setClasstime("2020-2021-2");
        JSONObject jsonObject1 = new JSONObject();
        try{
            classManageService.addCourse(Class);
            jsonObject1.put("message", "添加成功");
            jsonObject1.put("flag","1");
            return jsonObject1;
        }catch (DuplicateKeyException e){
            jsonObject1.put("message", "添加失败，该班课id已存在");
            return jsonObject1;
        }
    }

    @GetMapping("findAll")
    public List<classlesson1> findAll(){
        System.out.println("管理员查询班课");
        DateFormat df = DateFormat.getDateTimeInstance();
        List<classLesson> classes = classManageService.findAll();
        List<classlesson1> classes1 = new ArrayList<>();
        for(classLesson c : classes)
        {
            Date date = c.getCreattime();
            classlesson1 c1 = new classlesson1();
            c1.setClassid(c.getClassid());
            c1.setClassname(c.getClassname());
            c1.setTeachername(c.getTeachername());
            c1.setTeacherid(c.getTeacherid());
            c1.setType(c.getType());
            c1.setMaster(c.getMaster());
            c1.setPeopleCount(c.getPeopleCount());
            c1.setLocation(c.getLocation());
            c1.setClasstime(c.getClasstime());
            c1.setCollege(c.getCollege());
            c1.setSchool(c.getSchool());
            try{
                c1.setCreattime(df.format(date));
            }catch (NullPointerException e){

            }
            classes1.add(c1);
        }
        return classes1;
    }

    @GetMapping("findbyteacher")
    public List<classlesson1> findbyteacher(HttpServletRequest request) throws Exception {
        System.out.println("教师查询班课");
        String Token = request.getHeader("Authorization");
        Claims claims = tokenS.parseJWT(Token);
        String subject = claims.getSubject();
        JSONObject jsonObject = JSON.parseObject(subject);
        userInfo user = JSON.toJavaObject(jsonObject, userInfo.class);
        Date date = new Date();
        DateFormat df = DateFormat.getDateTimeInstance();
        int x = Integer.parseInt(user.getNumber());
        List<classLesson> classes = classManageService.find(user.getName(), x);
        List<classlesson1> classes1 = new ArrayList<>();
        for(classLesson c : classes)
        {
            classlesson1 c1 = new classlesson1();
            c1.setClassid(c.getClassid());
            c1.setClassname(c.getClassname());
            c1.setTeachername(c.getTeachername());
            c1.setTeacherid(c.getTeacherid());
            c1.setType(c.getType());
            c1.setMaster(c.getMaster());
            c1.setPeopleCount(c.getPeopleCount());
            c1.setLocation(c.getLocation());
            c1.setClasstime(c.getClasstime());
            c1.setCollege(c.getCollege());
            c1.setSchool(c.getSchool());
            try{
                c1.setCreattime(df.format(c.getCreattime()));
            }catch (NullPointerException e){

            }
            classes1.add(c1);
        }
        return classes1;
    }

    @RequestMapping("delete/{classId}")
    public Object delete(@PathVariable Integer classId)
    {
        JSONObject jsonObject1 = new JSONObject();
        classManageService.deleteCourse(classId);
        jsonObject1.put("message", "删除成功");
        return jsonObject1;
    }

    @RequestMapping("update")
    public Object update(@RequestBody updateclass Class2)
    {
        classLesson Class = Class2.getClass1();
        Integer oldclassid = Class2.getOldclassid();
        JSONObject jsonObject = new JSONObject();
        String id = Class.getTeacherid().toString();
        userInfo user = userM.getTeacherUser(id);
        if (user == null){
            jsonObject.put("message", "该教师id不存在");
            return jsonObject;
        }
        System.out.println(Class.getClassname());
        try{
            classManageService.updateCourse(Class, oldclassid);
            jsonObject.put("message", "编辑成功");
            return jsonObject;
        }catch (DuplicateKeyException e){
            jsonObject.put("message", "编辑失败，该班课id已存在");
            return jsonObject;
        }
    }

}