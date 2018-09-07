package com.nuc.sw.crm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Trade {

    @Id
    @GeneratedValue
    private int tId;
    private String tDate;
    private String tAddress;
    private String tOutline;
    private String tRemark;
    private int cId;

    public Trade() {
    }


    public Trade(String tDate, String tAddress, String tOutline, String tRemark, int cId) {
        this.tDate = tDate;
        this.tAddress = tAddress;
        this.tOutline = tOutline;
        this.tRemark = tRemark;
        this.cId = cId;
    }

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public String gettDate() {
        return tDate;
    }

    public void settDate(String tDate) {
        this.tDate = tDate;
    }

    public String gettAddress() {
        return tAddress;
    }

    public void settAddress(String tAddress) {
        this.tAddress = tAddress;
    }

    public String gettOutline() {
        return tOutline;
    }

    public void settOutline(String tOutline) {
        this.tOutline = tOutline;
    }

    public String gettRemark() {
        return tRemark;
    }

    public void settRemark(String tRemark) {
        this.tRemark = tRemark;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "tId=" + tId +
                ", tDate='" + tDate + '\'' +
                ", tAddress='" + tAddress + '\'' +
                ", tOutline='" + tOutline + '\'' +
                ", tRemark='" + tRemark + '\'' +
                ", cId=" + cId +
                '}';
    }
}
