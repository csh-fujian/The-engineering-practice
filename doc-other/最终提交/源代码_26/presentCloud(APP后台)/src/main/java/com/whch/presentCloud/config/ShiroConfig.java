package com.whch.presentCloud.config;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;

import com.whch.presentCloud.filter.ClientShiroThree;
import com.whch.presentCloud.shiro.MyRealm;

import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class ShiroConfig {
    @Bean
    public Realm myRealm() {
        return new MyRealm();
    }
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(myRealm());

        //  /*
        //  * 关闭shiro自带的session，详情见文档
        //  * http://shiro.apache.org/session-management.html#SessionManagement-StatelessApplications%28Sessionless%29
        //  */
        // DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
        // DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
        // defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
        // subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
        // manager.setSubjectDAO(subjectDAO);

        return manager;
    }
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean() {
        ShiroFilterFactoryBean filter = new ShiroFilterFactoryBean();
        filter.setSecurityManager(securityManager());

        //加入自定义的filter
        Map<String, Filter> filterMap = filter.getFilters();
        filterMap.put("client", new ClientShiroThree());
        filter.setFilters(filterMap);

        //定义相关路径
        //让未登录的返回登录操作提醒
        filter.setLoginUrl("/noLogin");
        //拦截没有权限的用户跳到哪里去
        filter.setUnauthorizedUrl("/noAuthorize");

        //定义拦截路径,记得将静态资源也排除过滤
        /*进行权限的控制,必须使用LinkHashMap,shrio要按照顺序进行设置*/
        Map<String, String> authMap = new LinkedHashMap<>();
        // authMap.put("/joinClass", "anon");
        authMap.put("/logout", "anon");
        authMap.put("/register", "anon");
        authMap.put("/loginbyphone", "anon");
        authMap.put("/resetpassword", "anon");
//        authMap.put("/join-class/join-in", "anon");
//        authMap.put("/banke/id/one-class", "anon");
        // authMap.put("/static/**", "anon");
        // authMap.put("/student/**", "client,roles[user]");
        authMap.put("/teacher/**", "roles[老师]");
        authMap.put("/login", "anon");
        authMap.put("/**", "authc");
        authMap.put("/**", "client");
        filter.setFilterChainDefinitionMap(authMap);

        //配置完成
//        log.info("---------------shirofactory创建成功");
        
        return filter;
    }
}
