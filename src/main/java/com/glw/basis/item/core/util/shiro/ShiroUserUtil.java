package com.glw.basis.item.core.util.shiro;

import com.glw.basis.item.data.model.User;

/**
 * @ClassName ShiroUserUtil
 * @Description: TODO
 * @Author guoliangwen
 * @Date 2019/9/20 0020
 * @Version V1.0
 **/
public class ShiroUserUtil {

    public static ShiroUser getUser(User user){
        ShiroUser shiroUser= new ShiroUser();
        shiroUser.setAccount(user.getUserName());
        shiroUser.setName(user.getUserName());
        return shiroUser;
    }
}
