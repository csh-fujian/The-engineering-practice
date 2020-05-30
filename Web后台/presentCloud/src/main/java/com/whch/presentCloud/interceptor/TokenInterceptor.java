package com.whch.presentCloud.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.whch.presentCloud.entity.CheckResult;
import com.whch.presentCloud.entity.userInfo;
import com.whch.presentCloud.exception.BaseException;
import com.whch.presentCloud.mapper.tokenMapper;
import com.whch.presentCloud.service.IService.ITokenService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    private ITokenService tokenS;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws IOException{

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        final String headerToken = request.getHeader("Authorization");

        if (headerToken == null || headerToken.trim().equals("")){
            throw new BaseException(999, "token为空，需要登录");
        }
        CheckResult checkResult = tokenS.validateJWT(headerToken);
        if(checkResult.isSuccess()){
            return true;
        }else {
            throw new BaseException(999, "token解析失败");
        }
        // 最后才放行
    }
}
