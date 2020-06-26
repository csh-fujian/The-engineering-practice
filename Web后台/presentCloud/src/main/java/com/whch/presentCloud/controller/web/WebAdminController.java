package com.whch.presentCloud.controller.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.whch.presentCloud.entity.admin;
import com.whch.presentCloud.entity.userInfo;
import com.whch.presentCloud.mapper.adminMapper;
import com.whch.presentCloud.service.IService.IAdminService;
import com.whch.presentCloud.service.IService.ITokenService;
import com.whch.presentCloud.service.IService.IUserLoginService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("webadmin")
public class WebAdminController {

    @Autowired
    private IAdminService adminS;
    @Autowired
    private ITokenService tokenS;
    @Autowired
    private IUserLoginService userloginservice;
    @Autowired
    private adminMapper adminM;

    @PostMapping("addadmin/{name}")
    public String addadmin(@PathVariable String name)
    {
        List<admin> list1 = adminM.find1(name);
        int i = 0;
        for(admin a : list1)
        {
            if (a.getName().equals(name)){
                i++;
            }
        }
        try{
            adminS.addadmin(name);
            return "新增成功";
        }catch (Exception e){
            return "新增失败，该昵称已存在";
        }
    }

    @RequestMapping("delete/{name}")
    public int deleteadmin(@PathVariable String name)
    {
        return adminS.delete(name);
    }

    @GetMapping("getAll")
    public List<admin> find(){
        return adminS.find();
    }

    @RequestMapping("update/{password}")
    public int update(@PathVariable String password, HttpServletRequest request) throws Exception
    {
        String Token = request.getHeader("Authorization");
        Claims claims = tokenS.parseJWT(Token);
        String subject = claims.getSubject();
        JSONObject jsonObject = JSON.parseObject(subject);
        userInfo user = JSON.toJavaObject(jsonObject, userInfo.class);
        if (Token.equals("")){
            System.out.println("token为空");
        }
        admin Admin = userloginservice.adminlogin(user.getNickname(), user.getPassword());
        userInfo user1 = userloginservice.login(user.getNickname(), user.getPassword());
        if (Admin == null && user1 == null){
            return 0;
        }
        else if(Admin != null){
            return adminS.update(password, Admin.getName());
        }
        else{
            return userloginservice.setpw(user, password);
        }
    }
}
