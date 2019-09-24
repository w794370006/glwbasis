package com.glw.basis.item.core.util.shiro;

import com.glw.basis.item.core.sys.service.ILoginService;
import com.glw.basis.item.data.model.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;

import java.util.List;

/**
 * @ClassName UserRealm
 * @Description: TODO
 * @Author guoliangwen
 * @Date 2019/9/19 0019
 * @Version V1.0
 **/
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private ILoginService loginService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("进入了tionInfo ");
        SimpleAuthorizationInfo authInfo = new SimpleAuthorizationInfo();
        return authInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken tokens = (UsernamePasswordToken) token;
        String username = tokens.getUsername();
        // 获取用户信息
        User user = loginService.selectByName(username);
        if (user == null) {
            return null;
        }
        ShiroUser shiroUser = ShiroUserUtil.getUser(user);
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(shiroUser,user.getPassword(),getName());
        authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(user.getSalt()));
        return authenticationInfo;
    }
}
