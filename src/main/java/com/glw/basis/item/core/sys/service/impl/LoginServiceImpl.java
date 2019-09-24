package com.glw.basis.item.core.sys.service.impl;

import com.glw.basis.item.core.sys.service.ILoginService;
import com.glw.basis.item.data.dao.UserDao;
import com.glw.basis.item.data.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName LoginServiceImpl
 * @Description: TODO
 * @Author guoliangwen
 * @Date 2019/9/19 0019
 * @Version V1.0
 **/
@Service("loginService")
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private UserDao userDao;


    public User selectByName(String name){
        return userDao.selectByName(name);
    };
}
