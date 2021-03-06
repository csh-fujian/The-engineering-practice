package com.whch.presentCloud.filter;

//package com.example.shirojwt.filter;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.web.filter.authc.AuthenticationFilter;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

import io.jsonwebtoken.JwtException;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.whch.presentCloud.exception.DefaultExceptionHandler;
import com.whch.presentCloud.exception.MyException;
import com.whch.presentCloud.utils.TokenUtil;

@Component // 这个注入与否影响不大
public class ClientShiroThree extends AuthenticationFilter {

    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse response1) throws Exception {
        HttpServletResponse response = (HttpServletResponse) response1;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String ajax = request.getHeader("x-requested-with");
        if (null == ajax) {
            System.out.println("=====不是ajax");
            // response.setContentType("text/html;charset=utf-8");
            // response.getWriter().write("请先登录");
            // response.sendRedirect("/noLogin");
            return false;
        } else {
            System.out.println("=====是ajax" + ajax);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("访问有问题");
        }
        return false;
    }

    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse response1, Object mappedValue) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) response1;
        String token = request.getHeader(TokenUtil.tokenHeard);
        System.out.println("================" + token);
        if (null == token || "".equals(token)) {
            System.out.println("-------------------token为空");
            return false;
        }
        // 验证token的真实性
        try {
            TokenUtil.getTokenBody(token);
        } catch (JwtException e) {
            // e.printStackTrace();
            // System.out.println("----------------token有问题");
            // response.setContentType("text/html;charset=utf-8");
            // response.getWriter().write("访问有问题");

            try {
                // response.sendError(500, "非法token");
                response.sendRedirect("/noLogin");
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            // throw new AuthenticationException("非法token");
            
        }
        return true;
    }


   

    /**
     * 对跨域提供支持
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        // 跨域时会首先发送一个option请求，这里我们给option请求直接返回正常状态
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        return super.preHandle(request, response);
    }
}
