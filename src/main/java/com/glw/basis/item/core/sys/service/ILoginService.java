package com.glw.basis.item.core.sys.service;

import com.glw.basis.item.data.model.User;

/**
 * @ClassName ILoginService
 * @Description: TODO
 * @Author guoliangwen
 * @Date 2019/9/19 0019
 * @Version V1.0
 **/
public interface ILoginService {

    User selectByName(String name);
}
