package com.glw.basis.item.core.util.shiro;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.springframework.util.DigestUtils;

/**
 * @Description: TODO
 * @Author guoliangwen
 * @Date 2019/9/19 0019
 * @Version V1.0
 **/
public class ShiroPasswordEncryption extends HashedCredentialsMatcher{

    public ShiroPasswordEncryption() {
        super.setHashAlgorithmName("md5");
        super.setHashIterations(1);
    }
}
