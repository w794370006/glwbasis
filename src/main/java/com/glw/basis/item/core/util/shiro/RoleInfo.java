package com.glw.basis.item.core.util.shiro;

import java.util.List;

/**
 * @ClassName RoleInfo
 * @Description: TODO
 * @Author guoliangwen
 * @Date 2019/9/19 0019
 * @Version V1.0
 **/
public class RoleInfo {
    private String roleName;
    private List<String> perms;

    public RoleInfo(String roleName, List<String> perms) {
        this.roleName = roleName;
        this.perms = perms;
    }

    public String getRoleName() {
        return roleName;
    }

    public List<String> getPerms() {
        return perms;
    }
}
