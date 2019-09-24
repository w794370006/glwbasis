package com.glw.basis.item.business.app.controller;

import com.glw.basis.item.core.annotation.webannotation.LoginRequired;
import com.glw.basis.item.data.model.User;
import com.glw.basis.item.business.app.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService IUserService;

    @RequestMapping("/showUser")
    @LoginRequired
    @ResponseBody
    public User toIndex(HttpServletRequest request, Model model){
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = this.IUserService.getUserById(userId);

        return user;
    }

}