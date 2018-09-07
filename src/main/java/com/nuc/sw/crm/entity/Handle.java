package com.nuc.sw.crm.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Handle {
    @Id
    @GeneratedValue
    private int hId;

    private Date hTime;

    private String hContent;

    private int  uId;

    private String hResult;

    private int hSatisficing;

    @Override
    public String toString() {
        return "Handle{" +
                "hId=" + hId +
                ", hTime=" + hTime +
                ", hContent='" + hContent + '\'' +
                ", uId=" + uId +
                ", hResult='" + hResult + '\'' +
                ", hSatisficing=" + hSatisficing +
                '}';
    }

    public int gethId() {
        return hId;
    }

    public void sethId(int hId) {
        this.hId = hId;
    }

    public Date gethTime() {
        return hTime;
    }

    public void sethTime(Date hTime) {
        this.hTime = hTime;
    }

    public String gethContent() {
        return hContent;
    }

    public void sethContent(String hContent) {
        this.hContent = hContent;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String gethResult() {
        return hResult;
    }

    public void sethResult(String hResult) {
        this.hResult = hResult;
    }

    public int gethSatisficing() {
        return hSatisficing;
    }

    public void sethSatisficing(int hSatisficing) {
        this.hSatisficing = hSatisficing;
    }

    public Handle(Date hTime, String hContent, int uId, String hResult, int hSatisficing) {
        this.hTime = hTime;
        this.hContent = hContent;
        this.uId = uId;
        this.hResult = hResult;
        this.hSatisficing = hSatisficing;
    }

    public Handle() {
    }


}
