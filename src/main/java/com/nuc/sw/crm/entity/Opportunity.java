package com.nuc.sw.crm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Opportunity {
    @Id
    @GeneratedValue
    private int id;
    private String resource;
    private String state;

    @Column(nullable = false)
    private int cId;

    @Column(nullable = false)
    private int successPercent;

    @Column(nullable = false)
    private String summary;

    private String lName;

    private String lPhone;

    @Column(nullable = false)
    private String opDescription;

    @Column(nullable = false)
    private String sId;

    @Column(nullable = false)
    private String startDate;

    @Column(nullable = false)
    private String pUsername;

    @Column(nullable = false)
    private String pId;

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

    public String getOpDescription() {
        return opDescription;
    }

    public void setOpDescription(String opDescription) {
        this.opDescription = opDescription;
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
