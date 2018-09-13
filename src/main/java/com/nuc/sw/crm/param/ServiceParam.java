package com.nuc.sw.crm.param;


import javax.validation.constraints.NotNull;


public class ServiceParam {
    private int sId;

    private String sType;
    @NotNull(message = "概要不能为空")
    private String sDetail;

    private String sState;
    @NotNull(message = "请求不能为空")
    private String sRequest;
    private int uId;
    private String sCreateDate;
    private int cId;

    public ServiceParam() {
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

    public ServiceParam(int sId, String sType, @NotNull(message = "概要不能为空") String sDetail, String sState, @NotNull(message = "请求不能为空") String sRequest, int uId, String sCreateDate, int cId) {
        this.sId = sId;
        this.sType = sType;
        this.sDetail = sDetail;
        this.sState = sState;
        this.sRequest = sRequest;
        this.uId = uId;
        this.sCreateDate = sCreateDate;
        this.cId = cId;
    }

    @Override
    public String toString() {
        return "ServiceParam{" +
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
