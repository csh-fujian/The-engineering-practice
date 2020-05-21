package com.whch.presentCloud.service.IService;

import com.whch.presentCloud.entity.CheckResult;
import com.whch.presentCloud.entity.userInfo;
import io.jsonwebtoken.Claims;

import java.util.Date;

public interface ITokenService {
    public String createtoken(userInfo user, Date date);
    public Claims parseJWT(String jwt) throws Exception;
    public CheckResult validateJWT(String jwtStr);
    public String generalSubject(userInfo user);
}
