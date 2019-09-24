package com.glw.basis.item.core.util.shiro;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName ShiroUser
 * @Description: TODO
 * @Author guoliangwen
 * @Date 2019/9/20 0020
 * @Version V1.0
 **/
public class ShiroUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户主键ID
     */
    private Integer id;

    /**
     * 账号
     */
    private String account;

    /**
     * 姓名
     */
    private String name;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 部门id
     */
    private Integer deptId;

    /**
     * 角色集
     */
    private List<Integer> roleList;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 角色名称集
     */
    private List<String> roleNames;

    @Override
    public String toString() {
        return "ShiroUser [id=" + id + ", account=" + account + ", name=" + name + ", email=" + email + ", avatar="
                + avatar + ", deptId=" + deptId + ", roleList=" + roleList + ", deptName=" + deptName + ", roleNames="
                + roleNames + "]";
    }

    //get
    public Integer getId() {
        return id;
    }

    public String getAccount() {
        return account;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAvatar() {
        return avatar;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public List<Integer> getRoleList() {
        return roleList;
    }

    public String getDeptName() {
        return deptName;
    }

    public List<String> getRoleNames() {
        return roleNames;
    }

    //set
    public void setId(Integer id) {
        this.id = id;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public void setRoleList(List<Integer> roleList) {
        this.roleList = roleList;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setRoleNames(List<String> roleNames) {
        this.roleNames = roleNames;
    }
}
