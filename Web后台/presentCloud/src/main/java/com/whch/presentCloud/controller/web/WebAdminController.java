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

    @PostMapping("addadmin/{name}")
    public int addadmin(@PathVariable String name)
    {
        return adminS.addadmin(name);
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

    @RequestMapping("update")
    public int update(@PathVariable String password, HttpServletRequest request) throws Exception
    {
        System.out.println(password);
        String Token = request.getHeader("Authorization");
        Claims claims = tokenS.parseJWT(Token);
        String subject = claims.getSubject();
        JSONObject jsonObject = JSON.parseObject(subject);
        admin Admin = JSON.toJavaObject(jsonObject, admin.class);
        admin Admin1 = userloginservice.admintoken(Admin.getName());
        System.out.println(Admin1.getName());
        if (Admin1 != null)
        {
            return adminS.update(password, Admin.getName());
        }
        else {
            JSONObject jsonObject1 = JSON.parseObject(subject);
            userInfo user = JSON.toJavaObject(jsonObject1, userInfo.class);
            return userloginservice.setpw(user, password);
        }
    }
}
