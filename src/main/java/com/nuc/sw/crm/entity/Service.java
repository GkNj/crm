package com.nuc.sw.crm.entity;




import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class Service {

    public Service() {
    }

    @Id
    @GeneratedValue
    private int sId;
    private String sType;
    private String sDetail;
    private String sState;
    private String sRequest;
    private int uId;
    private String sCreateDate;
    private int cId;
    private String hTime;
    private String hContent;
    private String hResult;
    private int hSatisficing;

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

    @Override
    public String toString() {
        return "Service{" +
                "sId=" + sId +
                ", sType='" + sType + '\'' +
                ", sDetail='" + sDetail + '\'' +
                ", sState='" + sState + '\'' +
                ", sRequest='" + sRequest + '\'' +
                ", uId=" + uId +
                ", sCreateDate='" + sCreateDate + '\'' +
                ", cId=" + cId +
                ", hTime='" + hTime + '\'' +
                ", hContent='" + hContent + '\'' +
                ", hResult='" + hResult + '\'' +
                ", hSatisficing=" + hSatisficing +
                '}';
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

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getsCreateDate() {
        return sCreateDate;
    }

    public void setsCreateDate(String sCreateDate) {
        this.sCreateDate = sCreateDate;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }


    public Service(String sType, String sDetail, String sState, String sRequest, int uId, String sCreateDate, int cId, String hTime, String hContent, String hResult, int hSatisficing) {
        this.sType = sType;
        this.sDetail = sDetail;
        this.sState = sState;
        this.sRequest = sRequest;
        this.uId = uId;
        this.sCreateDate = sCreateDate;
        this.cId = cId;
        this.hTime = hTime;
        this.hContent = hContent;
        this.hResult = hResult;
        this.hSatisficing = hSatisficing;
    }

}
