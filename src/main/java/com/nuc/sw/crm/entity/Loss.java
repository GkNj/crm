package com.nuc.sw.crm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Loss {

    @Id
    @GeneratedValue
    private int lId;
    private String oDate;
    private String lMeasure;
    private String lReason;
    private String lState;
    private int cId;
    private int uId;

    public Loss() {
    }

    public Loss(String oDate, String lMeasure, String lReason, String lState, int cId, int uId) {
        this.oDate = oDate;
        this.lMeasure = lMeasure;
        this.lReason = lReason;
        this.lState = lState;
        this.cId = cId;
        this.uId = uId;
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

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    @Override
    public String toString() {
        return "LossVo{" +
                "lId=" + lId +
                ", oDate='" + oDate + '\'' +
                ", lMeasure='" + lMeasure + '\'' +
                ", lReason='" + lReason + '\'' +
                ", lState='" + lState + '\'' +
                ", cId=" + cId +
                ", uId=" + uId +
                '}';
    }
}
