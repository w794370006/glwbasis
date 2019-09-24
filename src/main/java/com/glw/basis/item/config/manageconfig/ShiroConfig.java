package com.glw.basis.item.config.manageconfig;

import com.glw.basis.item.core.util.shiro.ShiroPasswordEncryption;
import com.glw.basis.item.core.util.shiro.UserRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName ShiroConfig
 * @Description: TODO
 * @Author guoliangwen
 * @Date 2019/9/19 0019
 * @Version V1.0
 **/
@Configuration
public class ShiroConfig {

    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(userRealm());
        manager.setSessionManager(sessionManager());
        return manager;
    }

    @Bean
    public DefaultWebSessionManager sessionManager() {
        DefaultWebSessionManager manager = new DefaultWebSessionManager();
        manager.setGlobalSessionTimeout(18000);
        return manager;
    }

    @Bean
    public UserRealm userRealm() {
        UserRealm manager = new UserRealm();
        manager.setCredentialsMatcher(matcher());
        return manager;
    }
    @Bean
    public HashedCredentialsMatcher matcher() {
        HashedCredentialsMatcher matcher = new ShiroPasswordEncryption();
        return matcher;
    }

    @Bean
    public ShiroFilterFactoryBean filter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        // 定义URL拦截链
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        // 指定loginurl 路径
        shiroFilterFactoryBean.setLoginUrl("/login.html");
        // 登录成功后跳转路径
        shiroFilterFactoryBean.setSuccessUrl("/index.html");
        // for un authenticated
        shiroFilterFactoryBean.setUnauthorizedUrl("/error/403.html");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        // 自定义filters，可覆盖默认的Filter列表，参考 DefaultFilter
        Map<String, Filter> filters = new LinkedHashMap<String, Filter>();

        // 定制logout 过滤，指定注销后跳转到登录页(默认为根路径)
        LogoutFilter logoutFilter = new LogoutFilter();
        logoutFilter.setRedirectUrl("/shiro/login");
        filters.put("logout", logoutFilter);
        // 定制authc 过滤，指定登录表单参数
        FormAuthenticationFilter authFilter = new FormAuthenticationFilter();
        authFilter.setUsernameParam("username");
        authFilter.setPasswordParam("password");
        filters.put("authc", authFilter);
        shiroFilterFactoryBean.setFilters(filters);
        return shiroFilterFactoryBean;
    }
}
