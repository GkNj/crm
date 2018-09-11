package com.nuc.sw.crm.entity;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Service {

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

    public Service() {
    }

    public Service(String sType, String sDetail, String sState, String sRequest, int uId, String sCreateDate, int cId) {
        this.sType = sType;
        this.sDetail = sDetail;
        this.sState = sState;
        this.sRequest = sRequest;
        this.uId = uId;
        this.sCreateDate = sCreateDate;
        this.cId = cId;
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
                '}';
    }
}
