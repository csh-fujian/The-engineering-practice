package com.whch.presentCloud.controller.web;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.whch.presentCloud.entity.addpage;
import com.whch.presentCloud.entity.classLesson;
import com.whch.presentCloud.entity.updateclass;
import com.whch.presentCloud.entity.userInfo;
import com.whch.presentCloud.mapper.userInfoMapper;
import com.whch.presentCloud.service.IService.IClassManageService;

import com.whch.presentCloud.service.IService.IDictionaryDataService;
import com.whch.presentCloud.service.IService.ITokenService;
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
    public List<classLesson> findAll(){
        System.out.println("管理员查询班课");
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        List<classLesson> classes = classManageService.findAll();
        return classes;
    }

    @GetMapping("findbyteacher")
    public List<classLesson> findbyteacher(HttpServletRequest request) throws Exception {
        System.out.println("教师查询班课");
        String Token = request.getHeader("Authorization");
        Claims claims = tokenS.parseJWT(Token);
        String subject = claims.getSubject();
        JSONObject jsonObject = JSON.parseObject(subject);
        userInfo user = JSON.toJavaObject(jsonObject, userInfo.class);
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        int x = Integer.parseInt(user.getNumber());
        List<classLesson> classes = classManageService.find(user.getName(), x);
        return classes;
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