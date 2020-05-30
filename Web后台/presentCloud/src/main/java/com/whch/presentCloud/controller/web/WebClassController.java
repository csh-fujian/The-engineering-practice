package com.whch.presentCloud.controller.web;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.whch.presentCloud.entity.addpage;
import com.whch.presentCloud.entity.classLesson;
import com.whch.presentCloud.entity.userInfo;
import com.whch.presentCloud.mapper.userInfoMapper;
import com.whch.presentCloud.service.IService.IClassManageService;

import com.whch.presentCloud.service.IService.IDictionaryDataService;
import com.whch.presentCloud.service.IService.ITokenService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("adminaddclass")
    public Object adminaddclass(@RequestBody classLesson Class){
        String ro = dicd.findbykey("teacher");
        userInfo user = userM.findOne1(Class.getTeachername(), ro);
        JSONObject jsonObject = new JSONObject();
        if (user == null)
        {
            jsonObject.put("message", "不存在该任课老师");
            return jsonObject;
        }
        else {
            Date date = new Date();
            Class.setTeacherid(user.getId());
            Class.setCreattime(date);
            boolean flag = classManageService.addCourse(Class);
            if (flag){
                jsonObject.put("message", "添加成功");
                return jsonObject;
            }
            else {
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
        Class.setTeacherid(user.getId());
        Date date = new Date();
        Class.setCreattime(date);
        JSONObject jsonObject1 = new JSONObject();
        boolean flag = classManageService.addCourse(Class);
        if (flag){
            jsonObject1.put("message", "添加成功");
            return jsonObject1;
        }
        else {
            jsonObject1.put("message", "添加失败，该班课id已存在");
            return jsonObject1;
        }
    }

    @GetMapping("findAll")
    public List<classLesson> findAll(){
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        List<classLesson> classes = classManageService.findAll();
        for(classLesson c : classes)
        {
            date = c.getCreattime();
            c.setClasstime(dateFormat.format(date));
        }
        return classes;
    }

    @GetMapping("findbyteacher")
    public List<classLesson> findbyteacher(HttpServletRequest request) throws Exception {
        String Token = request.getHeader("Authorization");
        Claims claims = tokenS.parseJWT(Token);
        String subject = claims.getSubject();
        JSONObject jsonObject = JSON.parseObject(subject);
        userInfo user = JSON.toJavaObject(jsonObject, userInfo.class);
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        List<classLesson> classes = classManageService.find(user.getName());
        for(classLesson c : classes)
        {
            date = c.getCreattime();
            c.setClasstime(dateFormat.format(date));
        }
        return classes;
    }

    @RequestMapping("delete/{classId}")
    public Object delete(@PathVariable Integer classId)
    {
        JSONObject jsonObject1 = new JSONObject();
        boolean flag = classManageService.deleteCourse(classId);
        if (flag){
            jsonObject1.put("message", "删除成功");
            return jsonObject1;
        }
        else {
            jsonObject1.put("message", "删除失败");
            return jsonObject1;
        }
    }

    @RequestMapping("update")
    public Object update(@RequestBody classLesson Class)
    {
        JSONObject jsonObject1 = new JSONObject();
        boolean flag = classManageService.updateCourse(Class);
        if (flag){
            jsonObject1.put("message", "编辑成功");
            return jsonObject1;
        }
        else {
            jsonObject1.put("message", "编辑失败");
            return jsonObject1;
        }
    }

}