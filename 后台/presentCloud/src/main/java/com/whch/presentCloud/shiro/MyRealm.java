package com.whch.presentCloud.shiro;

import javax.annotation.Resource;

import com.whch.presentCloud.entity.userInfo;
import com.whch.presentCloud.service.IService.IUserManageService;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class MyRealm extends AuthorizingRealm {
    @Resource
    private IUserManageService userService;

    @Override
    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("============用户授权==============");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        /*获取当前的用户,已经登录后可以使用在任意的地方获取用户的信息*/
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        /*查询用户的权限*/
        System.out.println("============用户授权=============="+username);
        // Roles role = rolesMapper.getRole(username);
        userInfo user = userService.getUser(username);
        /*将role放在一个集合中,多个权限使用集合*/
        // info.addRole(role.getRole());
        info.addRole(user.getRole());
        return info;
    }
 /**
  * 当调用Subject.login(token)才调用该方法
  */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("============用户验证==============");
        //从token中获取信息,此token只是shiro用于身份验证的,并非前端传过来的token.
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        userInfo user = userService.getUser(username);
        // String password = rolesMapper.getPassword(username);
        String password = user.getPassword();

        if (null == password) {
            throw new AuthenticationException("doGetAuthenticationInfo中的用户名不对");
        } else if (!password.equals(new String(token.getPassword()))){
            throw new AuthenticationException("doGetAuthenticationInfo中的密码不对");
        }
        //组合一个验证信息
        System.out.println("token.getPrincipal()默认返回的username======"+token.getPrincipal());
        System.out.println("getName()"+getName());
        SimpleAuthenticationInfo info = 
        	new SimpleAuthenticationInfo(token.getPrincipal(),password,getName());
        return info;
    }
	
}
