package com.kevin.shiro.realm;


import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginRealm extends AuthorizingRealm {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private Map<String, String> usernamePasswords;
    private Map<String, List<String>> usernameRoles;

    public LoginRealm() {
        usernamePasswords = new HashMap<String, String>();
        usernameRoles = new HashMap<String, List<String>>();

        usernamePasswords.put("admin", "password");
        usernamePasswords.put("register", "password");

        usernameRoles.put("admin", Arrays.asList("Register", "Admin"));
        usernameRoles.put("register", Arrays.asList("Register"));
    }

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        // 用户需要提供 principals (身份)和 credentials(证明)给 shiro,从而应用能验证用户身份
        // 最常见的 principals 和 credentials 组合就是用户名/密码了
        // String username = (String) principals.fromRealm(getName()).iterator().next();
        String username = (String) principals.getPrimaryPrincipal();

        // Authentication 成功后查询用户授权信息.
        List<String> roles = queryRoles(username);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        logger.debug("Username: {}, Roles: {}", username, roles);

        if (roles != null && !roles.isEmpty()) {
//            info.addStringPermissions(permissions);
            info.addRoles(roles);
        }

        return info;

    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username = upToken.getUsername(); // 通过表单接收的用户名

        logger.info("--------------username: " + username);
        logger.info("--------------token: " + token);


//        User user = userMapper.findUserById(1);
//        System.out.println(user);

        // 取得预先定义的用户名密码对
        return new SimpleAuthenticationInfo(username, queryPassword(username), getName());
    }

    private String queryPassword(String username) {
        return usernamePasswords.get(username);
    }

    private List<String> queryRoles(String username) {
        return usernameRoles.get(username);
    }
}
