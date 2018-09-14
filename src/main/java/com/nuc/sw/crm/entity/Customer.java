package com.nuc.sw.crm.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class Customer {
    @Id
    @GeneratedValue
    private int cId;
    private String cName;
    private String cAddress;
    @Column(columnDefinition = "普通客户")
    private String cClass;
    @Column(name="c_satisfaction",columnDefinition = "int default 0")
    private int cSatisfaction;
    @Column(name="c_credit",columnDefinition = "int default 0")
    private int cCredit;
    private String cPost;
    private String cWebsite;
    private String cPicture;
    private int uId;

    public Customer() {
    }


    public Customer(String cName, String cAddress, String cClass, int cSatisfaction, int cCredit, String cPost, String cWebsite, String cPicture, int uId) {
        this.cName = cName;
        this.cAddress = cAddress;
        this.cClass = cClass;
        this.cSatisfaction = cSatisfaction;
        this.cCredit = cCredit;
        this.cPost = cPost;
        this.cWebsite = cWebsite;
        this.cPicture = cPicture;
        this.uId = uId;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcAddress() {
        return cAddress;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress;
    }

    public String getcClass() {
        return cClass;
    }

    public void setcClass(String cClass) {
        this.cClass = cClass;
    }

    public int getcSatisfaction() {
        return cSatisfaction;
    }

    public void setcSatisfaction(int cSatisfaction) {
        this.cSatisfaction = cSatisfaction;
    }

    public int getcCredit() {
        return cCredit;
    }

    public void setcCredit(int cCredit) {
        this.cCredit = cCredit;
    }

    public String getcPost() {
        return cPost;
    }

    public void setcPost(String cPost) {
        this.cPost = cPost;
    }

    public String getcWebsite() {
        return cWebsite;
    }

    public void setcWebsite(String cWebsite) {
        this.cWebsite = cWebsite;
    }

    public String getcPicture() {
        return cPicture;
    }

    public void setcPicture(String cPicture) {
        this.cPicture = cPicture;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                ", cAddress='" + cAddress + '\'' +
                ", cClass='" + cClass + '\'' +
                ", cSatisfaction=" + cSatisfaction +
                ", cCredit=" + cCredit +
                ", cPost='" + cPost + '\'' +
                ", cWebsite='" + cWebsite + '\'' +
                ", cPicture='" + cPicture + '\'' +
                ", uId=" + uId +
                '}';
    }
}
