package com.nuc.sw.crm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Opportunity {
    @Id
    @GeneratedValue
    //机会id

    private int id;
    @Column(nullable = false)
    //机会编号

    private int num;
    //机会来源

    private String resource;
    //机会状态

    private String state;
    //客户id

    @Column(nullable = false)
    private int cId;
    //客户姓名

    @Column(nullable = false)
    private String username;
    //成功几率

    @Column(nullable = false)
    private int successPercent;
    //机会概要

    @Column(nullable = false)
    private String summary;
    //联系人姓名

    private String lName;
    //联系人电话

    private String lPhone;
    //机会描述

    @Column(nullable = false)
    private String cComment;
    //创建人

    @Column(nullable = false)
    private String sId;
    //创建时间

    @Column(nullable = false)
    private String startDate;
    //指派人

    @Column(nullable = false)
    private String pUsername;
    //指派人id

    @Column(nullable = false)
    private String pId;
    //指派时间

    @Column(nullable = false)
    private String pDate;
    public String getpDate() {
        return pDate;
    }

    public void setpDate(String pDate) {
        this.pDate = pDate;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public int getSuccessPercent() {
        return successPercent;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setSuccessPercent(int successPercent) {
        this.successPercent = successPercent;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getlPhone() {
        return lPhone;
    }

    public void setlPhone(String lPhone) {
        this.lPhone = lPhone;
    }

    public String getcComment() {
        return cComment;
    }

    public void setcComment(String cComment) {
        this.cComment = cComment;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getpUsername() {
        return pUsername;
    }

    public void setpUsername(String pUsername) {
        this.pUsername = pUsername;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }
}
