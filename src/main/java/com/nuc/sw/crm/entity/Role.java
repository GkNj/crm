package com.nuc.sw.crm.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author 杨晓辉 2018-08-30 11:14
 * 角色实体类
 */

@Entity
@Table(name = "role")
public class Role implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * 角色名称
     */
    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}