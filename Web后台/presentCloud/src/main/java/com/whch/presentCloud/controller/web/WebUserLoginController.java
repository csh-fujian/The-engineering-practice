package com.whch.presentCloud.controller.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.whch.presentCloud.entity.result;
import com.whch.presentCloud.entity.token;
import com.whch.presentCloud.entity.userInfo;
import com.whch.presentCloud.mapper.tokenMapper;
import com.whch.presentCloud.service.IService.IClassManageService;
import com.whch.presentCloud.service.IService.ITokenService;
import com.whch.presentCloud.service.IService.IUserLoginService;
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
    private tokenMapper tokenM;
    @Autowired
    private ITokenService tokenS;

    @PostMapping("login1")
    public token login(@RequestBody userInfo user, HttpServletRequest request)
    {
        userInfo user1 = userloginservice.login(user.getNickname(), user.getPassword());
        if (user1 != null){
            token Token = tokenM.getByUserId(user1.getId());
            String tokenString = "";
            Date date = new Date();
            int nowTime = (int) (date.getTime()/1000);
            tokenString = tokenS.createtoken(user1, date);

            if(Token == null){
                // 如果是第一次登陆
                Token = new token();
                Token.setToken(tokenString);
                Token.setBuildTime(nowTime);
                Token.setUserId(user1.getId());
                tokenM.Insert(Token);
            }
            else {
                // 登陆后跟新Token信息
                tokenString = tokenS.createtoken(user1, date);
                Token.setToken(tokenString);
                Token.setBuildTime(nowTime);
                tokenM.update(Token);
            }
            return Token;
        }
        return null;
    }

    @GetMapping("parsejwt")
    public Object parsejwt(HttpServletRequest request) throws Exception{
        String Token = request.getParameter("token");
        if (Token.equals("")){
            System.out.println("token为空");
        }
        Claims claims = tokenS.parseJWT(Token);
        String subject = claims.getSubject();
        JSONObject jsonObject = JSON.parseObject(subject);
        userInfo user = JSON.toJavaObject(jsonObject, userInfo.class);
        return user;
    }

    //测试
    @RequestMapping("login")
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
