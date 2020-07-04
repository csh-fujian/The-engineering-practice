package com.whch.presentCloud.controller.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.whch.presentCloud.entity.admin;
import com.whch.presentCloud.entity.result;
import com.whch.presentCloud.entity.token;
import com.whch.presentCloud.entity.userInfo;
import com.whch.presentCloud.mapper.adminMapper;
import com.whch.presentCloud.mapper.tokenMapper;
import com.whch.presentCloud.mapper.userInfoMapper;
import com.whch.presentCloud.service.IService.*;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
@RequestMapping("webinitialization")
public class WebUserLoginController {

    @Autowired
    private IUserLoginService userloginservice;
    @Autowired
    private IClassManageService classManageService;
    @Autowired
    private ITokenService tokenS;
    @Autowired
    private IDictionaryDataService dicd;
    @Autowired
    private adminMapper adminM;
    @Autowired
    private userInfoMapper userM;
    @Autowired
    private Isha256Service sha256S;

    @PostMapping("login")
    public Object login(@RequestBody userInfo user, HttpServletRequest request)
    {
        JSONObject jsonObject = new JSONObject();
        admin Admin = userloginservice.adminlogin(user.getNickname(), sha256S.getSHA256Str(user.getPassword()));
        userInfo user1 = userloginservice.login(user.getNickname(), sha256S.getSHA256Str(user.getPassword()));
        if (Admin == null && user1 == null){
            jsonObject.put("message", "登录失败,用户名或密码错误");
            return jsonObject;
        }
        else if(Admin != null){
            Date date = new Date();
            int nowTime = (int) (date.getTime()/1000);
            String tokenString = tokenS.createtoken(user, date);
            jsonObject.put("message", "用户登录成功");
            jsonObject.put("token", tokenString);
            jsonObject.put("role", "admin");
            jsonObject.put("layer", Admin.getAccount());
            return jsonObject;
        }
        else if(user1 != null) {
            String ro = dicd.findbykey("teacher");
            if (user1.getRole().equals(ro)){
                String tokenString = "";
                Date date = new Date();
                int nowTime = (int) (date.getTime()/1000);
                tokenString = tokenS.createtoken(user1, date);
                jsonObject.put("message", "用户登录成功");
                jsonObject.put("token", tokenString);
                jsonObject.put("role", "teacher");
                return jsonObject;
            }
            jsonObject.put("message", "登录失败,该用户不是教师或管理员");
            return jsonObject;
        }
        jsonObject.put("message", "登录失败,数据库两表存在重复用户");
        return jsonObject;
    }

    @PostMapping("loginbyphone")
    public Object loginbyphone(@RequestBody userInfo user, HttpServletRequest request)
    {

        JSONObject jsonObject = new JSONObject();
        admin Admin = adminM.findOnebyPhone(user.getPhone(), sha256S.getSHA256Str(user.getPassword()));
        userInfo user1 = userM.findOnebyPhone(user.getPhone(), sha256S.getSHA256Str(user.getPassword()));
        if (Admin == null && user1 == null){
            jsonObject.put("message", "登录失败,手机号或密码错误");
            return jsonObject;
        }
        else if(Admin != null){
            Date date = new Date();
            int nowTime = (int) (date.getTime()/1000);
            String tokenString = tokenS.createtoken(user, date);
            jsonObject.put("message", "用户登录成功");
            jsonObject.put("token", tokenString);
            jsonObject.put("role", "admin");
            System.out.println("======1=======");
            jsonObject.put("layer", Admin.getAccount());
            return jsonObject;
        }
        else if(user1 != null) {
            String ro = dicd.findbykey("teacher");
            if (user1.getRole().equals(ro)){
                String tokenString = "";
                Date date = new Date();
                int nowTime = (int) (date.getTime()/1000);
                tokenString = tokenS.createtoken(user1, date);
                jsonObject.put("message", "用户登录成功");
                jsonObject.put("token", tokenString);
                jsonObject.put("role", "teacher");
                System.out.println("======2=======");
                return jsonObject;
            }
            jsonObject.put("message", "登录失败,该用户不是教师或管理员");
            return jsonObject;
        }
        jsonObject.put("message", "登录失败,数据库两表存在重复用户");
        return jsonObject;
    }

    @GetMapping("parsejwt")
    public Object parsejwt(HttpServletRequest request) throws Exception{
        String Token = request.getHeader("Authorization");
        if (Token.equals("")){
            System.out.println("token为空");
        }
        Claims claims = tokenS.parseJWT(Token);
        String subject = claims.getSubject();
        JSONObject jsonObject = JSON.parseObject(subject);
        userInfo user = JSON.toJavaObject(jsonObject, userInfo.class);
        return user;
    }

    @GetMapping("parse")
    public Object parse(HttpServletRequest request) throws Exception{
        String Token = request.getHeader("Authorization");
        Claims claims = tokenS.parseJWT(Token);
        String subject = claims.getSubject();
        JSONObject jsonObject = JSON.parseObject(subject);
        userInfo user = JSON.toJavaObject(jsonObject, userInfo.class);
        if (Token.equals("")){
            System.out.println("token为空");
        }
        if(user.getPhone()==null){
            admin Admin = userloginservice.adminlogin(user.getNickname(), sha256S.getSHA256Str(user.getPassword()));
            userInfo user1 = userloginservice.login(user.getNickname(), sha256S.getSHA256Str(user.getPassword()));
            if (Admin == null && user1 == null){
                jsonObject.put("message", "未知错误");
                return jsonObject;
            }
            else if(Admin != null){
                jsonObject.put("role", "admin");
                jsonObject.put("phone", Admin.getPhone());
                jsonObject.put("layer", Admin.getAccount());
                return jsonObject;
            }
            else{
                jsonObject.put("role", "teacher");
                jsonObject.put("phone", user1.getPhone());
                return jsonObject;
            }
        }
        else {
            admin Admin = adminM.findOnebyPhone(user.getPhone(), sha256S.getSHA256Str(user.getPassword()));
            userInfo user1 = userM.findOnebyPhone(user.getPhone(), sha256S.getSHA256Str(user.getPassword()));
            if (Admin == null && user1 == null){
                jsonObject.put("message", "未知错误");
                return jsonObject;
            }
            else if(Admin != null){
                jsonObject.put("role", "admin");
                jsonObject.put("phone", Admin.getPhone());
                jsonObject.put("layer", Admin.getAccount());
                return jsonObject;
            }
            else{
                jsonObject.put("role", "teacher");
                jsonObject.put("phone", user1.getPhone());
                return jsonObject;
            }
        }
    }



    //测试
    @RequestMapping("login1")
    @ResponseBody
    public result userLogin(@RequestParam("username")String nickname, @RequestParam("password")String password, HttpSession session){
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
