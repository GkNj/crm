package com.nuc.sw.crm.vo;

import com.nuc.sw.crm.entity.Customer;
import com.nuc.sw.crm.entity.User;

public class ServiceVO {

    private int sId;
    private String sType;
    private String sDetail;
    private String sState;
    private String sRequest;
    private User user;
    private String sCreateDate;
    private Customer customer;
    private String hTime;
    private String hContent;
    private String hResult;
    private int hSatisficing;
    private User huser;

    public User getHuser() {
        return huser;
    }

    public void setHuser(User huser) {
        this.huser = huser;
    }

    public String gethTime() {
        return hTime;
    }

    public void sethTime(String hTime) {
        this.hTime = hTime;
    }

    public String gethContent() {
        return hContent;
    }

    public void sethContent(String hContent) {
        this.hContent = hContent;
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

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getsType() {
        return sType;
    }

    public void setsType(String sType) {
        this.sType = sType;
    }

    public String getsDetail() {
        return sDetail;
    }

    public void setsDetail(String sDetail) {
        this.sDetail = sDetail;
    }

    public String getsState() {
        return sState;
    }

    public void setsState(String sState) {
        this.sState = sState;
    }

    public String getsRequest() {
        return sRequest;
    }

    public void setsRequest(String sRequest) {
        this.sRequest = sRequest;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getsCreateDate() {
        return sCreateDate;
    }

    public void setsCreateDate(String sCreateDate) {
        this.sCreateDate = sCreateDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public ServiceVO() {
    }

    public ServiceVO(int sId, String sType, String sDetail, String sState, String sRequest, User user, String sCreateDate, Customer customer, String hTime, String hContent, String hResult, int hSatisficing, User huser) {
        this.sId = sId;
        this.sType = sType;
        this.sDetail = sDetail;
        this.sState = sState;
        this.sRequest = sRequest;
        this.user = user;
        this.sCreateDate = sCreateDate;
        this.customer = customer;
        this.hTime = hTime;
        this.hContent = hContent;
        this.hResult = hResult;
        this.hSatisficing = hSatisficing;
        this.huser = huser;
    }

    @Override
    public String toString() {
        return "ServiceVO{" +
                "sId=" + sId +
                ", sType='" + sType + '\'' +
                ", sDetail='" + sDetail + '\'' +
                ", sState='" + sState + '\'' +
                ", sRequest='" + sRequest + '\'' +
                ", user=" + user +
                ", sCreateDate='" + sCreateDate + '\'' +
                ", customer=" + customer +
                ", hTime='" + hTime + '\'' +
                ", hContent='" + hContent + '\'' +
                ", hResult='" + hResult + '\'' +
                ", hSatisficing=" + hSatisficing +
                ", huser=" + huser +
                '}';
    }
}
