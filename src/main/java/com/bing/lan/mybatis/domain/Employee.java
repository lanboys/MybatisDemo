package com.bing.lan.mybatis.domain;

import java.io.Serializable;

/**
 * Created by 蓝兵 on 2018/4/20.
 */

public class Employee implements Serializable{

    private String name;
    private Long id;
    private String telephone;

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", phone='" + telephone + '\'' +
                '}';
    }
}
