package com.nuc.sw.crm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Orders {

    @Id
    @GeneratedValue
    private int oId;
    private String oDate;
    private String oAddress;
    private String oState;
    private double oPrice;
    private int cId;

    public Orders() {
    }

    public Orders(int oId, String oDate, String oAddress, String oState, double oPrice, int cId) {
        this.oId = oId;
        this.oDate = oDate;
        this.oAddress = oAddress;
        this.oState = oState;
        this.oPrice = oPrice;
        this.cId = cId;
    }

    public int getoId() {
        return oId;
    }

    public void setoId(int oId) {
        this.oId = oId;
    }

    public String getoDate() {
        return oDate;
    }

    public void setoDate(String oDate) {
        this.oDate = oDate;
    }

    public String getoAddress() {
        return oAddress;
    }

    public void setoAddress(String oAddress) {
        this.oAddress = oAddress;
    }

    public String getoState() {
        return oState;
    }

    public void setoState(String oState) {
        this.oState = oState;
    }

    public double getoPrice() {
        return oPrice;
    }

    public void setoPrice(double oPrice) {
        this.oPrice = oPrice;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "oId=" + oId +
                ", oDate='" + oDate + '\'' +
                ", oAddress='" + oAddress + '\'' +
                ", oState='" + oState + '\'' +
                ", oPrice=" + oPrice +
                ", cId=" + cId +
                '}';
    }
}
