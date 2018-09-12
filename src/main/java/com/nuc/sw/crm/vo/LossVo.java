package com.nuc.sw.crm.vo;

import com.nuc.sw.crm.entity.Customer;
import com.nuc.sw.crm.entity.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public class LossVo {

    private int lId;
    private String oDate;
    private String lMeasure;
    private String lReason;
    private String lState;
    private Customer customer;
    private User user;

    public LossVo() {
    }

    public LossVo(int lId, String oDate, String lMeasure, String lReason, String lState, Customer customer, User user) {
        this.lId = lId;
        this.oDate = oDate;
        this.lMeasure = lMeasure;
        this.lReason = lReason;
        this.lState = lState;
        this.customer = customer;
        this.user = user;
    }

    public int getlId() {
        return lId;
    }

    public void setlId(int lId) {
        this.lId = lId;
    }

    public String getoDate() {
        return oDate;
    }

    public void setoDate(String oDate) {
        this.oDate = oDate;
    }

    public String getlMeasure() {
        return lMeasure;
    }

    public void setlMeasure(String lMeasure) {
        this.lMeasure = lMeasure;
    }

    public String getlReason() {
        return lReason;
    }

    public void setlReason(String lReason) {
        this.lReason = lReason;
    }

    public String getlState() {
        return lState;
    }

    public void setlState(String lState) {
        this.lState = lState;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "LossVo{" +
                "lId=" + lId +
                ", oDate='" + oDate + '\'' +
                ", lMeasure='" + lMeasure + '\'' +
                ", lReason='" + lReason + '\'' +
                ", lState='" + lState + '\'' +
                ", customer=" + customer +
                ", user=" + user +
                '}';
    }
}
