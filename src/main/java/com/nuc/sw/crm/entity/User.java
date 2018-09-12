package com.nuc.sw.crm.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author 杨晓辉 2018-09-05 16:29
 * 登录用户实体
 */
@Entity
public class User implements Serializable, UserDetails {

    /**
     * 主键 id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * 登录名
     */
    private String username;

    /**
     * 登录密码
     */
    private String password;


    /**
     * 用户名称
     */
    private String name;


    /**
     * 用户性别
     */
    private String sex;

    /**
     * 用户职位
     */
    private String position;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = {
                    @JoinColumn(name = "ur_user_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ur_role_id")
            }
    )
    private List<Role> roles;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        List<Role> roles = getRoles();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        }
        authorities.forEach(System.out::println);
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPosition() {
//        switch (position) {
//            case "ROOT":
//                position = "超级管理员";
//                break;
//            case "ADMIN":
//                position = "系统管理";
//                break;
//            case "AM":
//                position = "客户经理";
//                break;
//            case "SA":
//                position = "销售主管";
//                break;
//            case "SM":
//                position = "高管";
//                break;
//            default:
//                position = "未知职位";
//                break;
//        }


        return position;
    }

    public String setPosition(String position) {
        this.position = position;
        return position;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", position='" + position + '\'' +
                ", roles=" + roles +
                '}';
    }
}

