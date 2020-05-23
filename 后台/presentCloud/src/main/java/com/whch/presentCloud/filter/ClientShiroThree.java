package com.whch.presentCloud.filter;

//package com.example.shirojwt.filter;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.web.filter.authc.AuthenticationFilter;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.whch.presentCloud.utils.TokenUtil;
 
 


@Component//这个注入与否影响不大
public class ClientShiroThree extends AuthenticationFilter {
    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse response1) throws Exception {
        HttpServletResponse response = (HttpServletResponse) response1;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String ajax = request.getHeader("x-requested-with");
        if (null==ajax) {
            System.out.println("=====不是ajax");
            response.sendRedirect("/login");
        }else {
            System.out.println("=====是ajax"+ajax);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("访问有问题");
        }
        return false;
    }
  
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse response, Object mappedValue) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String token = request.getHeader(TokenUtil.tokenHeard);
        System.out.println("================"+token);
        if (null == token||"".equals(token)) {
            System.out.println("-------------------token为空");
            return false;
        }
        //验证token的真实性
        try {
            TokenUtil.getTokenBody(token);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("----------------token有问题");
            return false;
        }
        return true;
    }
}
