package com.glw.basis.item.core.sys.controller;

import com.glw.basis.item.core.sys.service.ILoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
/**
 * @ClassName LoginController
 * @Description: TODO
 * @Author guoliangwen
 * @Date 2019/9/19 0019 
 * @Version V1.0
 **/
@Controller
@RequestMapping(value = "/system/login")
public class LoginController {

    @Autowired
    private ILoginService loginService;

    @RequestMapping(value = "/login")
    @ResponseBody
    public Object toIndex(HttpServletRequest request,
                          @RequestParam(required = true) String username,
                          @RequestParam(required = true) String password,
                          @RequestParam(required = false) String remember){

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try {
            subject.login(token);
            System.out.println(subject.isAuthenticated());
        }catch (Exception e){
            return "登录失败";
        }
        return "登录成功";
    }
}
