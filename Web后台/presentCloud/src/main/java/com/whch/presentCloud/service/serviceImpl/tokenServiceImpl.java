package com.whch.presentCloud.service.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.whch.presentCloud.entity.CheckResult;
import com.whch.presentCloud.entity.userInfo;
import com.whch.presentCloud.service.IService.ITokenService;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class tokenServiceImpl implements ITokenService {

    static Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    // 生成token
    @Override
    public String createtoken(userInfo user, Date date)
    {
        String subject = generalSubject(user);
        JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "jwt") // 设置header
                .setHeaderParam("alg", "HS256")
                .setIssuedAt(date) // 设置签发时间
                .setExpiration(new Date(date.getTime() + 1000 * 60 * 20)) // 设置过期时间
                .setSubject(subject) // 设置主题
                .setIssuer("lenses")// 设置签发人
                .signWith(key); // 签名，需要算法和key
        String jwt = builder.compact();
        return jwt;
    }

    // 解析token
    @Override
    public Claims parseJWT(String jwt) throws Exception {
        return Jwts.parser().setSigningKey(key).parseClaimsJws(jwt).getBody();
    }

    @Override
    public CheckResult validateJWT(String jwtStr) {
        CheckResult checkResult = new CheckResult();
        Claims claims = null;
        try {
            claims = parseJWT(jwtStr);
            checkResult.setSuccess(true); // 验证成功
            checkResult.setClaims(claims);
        } catch (ExpiredJwtException e) {
            checkResult.setErrCode(1007); // Token过期
            checkResult.setSuccess(false);
        } catch (SignatureException e) {
            checkResult.setErrCode(1008); // 验证不通过
            checkResult.setSuccess(false);
        } catch (Exception e) {
            checkResult.setErrCode(1008); // 验证不通过
            checkResult.setSuccess(false);
        }
        return checkResult;
    }

    /**
     * 生成subject信息
     *
     * @param user
     * @return
     */
    @Override
    public String generalSubject(userInfo user) {
        return JSON.toJSONString(user);
    }
}

