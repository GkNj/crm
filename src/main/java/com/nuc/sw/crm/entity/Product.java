package com.nuc.sw.crm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private int pId;
    private String pName;
    private int pNum;
    private String pUnit;
    private double pPrice;
    private int oId;

    public double getFluctuation() {
        return fluctuation;
    }

    public void setFluctuation(double fluctuation) {
        this.fluctuation = fluctuation;
    }

    private double fluctuation;

    public Product() {
    }

    public Product(int pId, String pName, int pNum, String pUnit, double pPrice, int oId) {
        this.pId = pId;
        this.pName = pName;
        this.pNum = pNum;
        this.pUnit = pUnit;
        this.pPrice = pPrice;
        this.oId = oId;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getpNum() {
        return pNum;
    }

    public void setpNum(int pNum) {
        this.pNum = pNum;
    }

    public String getpUnit() {
        return pUnit;
    }

    public void setpUnit(String pUnit) {
        this.pUnit = pUnit;
    }

    public double getpPrice() {
        return pPrice;
    }

    public void setpPrice(double pPrice) {
        this.pPrice = pPrice;
    }

    public int getoId() {
        return oId;
    }

    public void setoId(int oId) {
        this.oId = oId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pId=" + pId +
                ", pName='" + pName + '\'' +
                ", pNum=" + pNum +
                ", pUnit='" + pUnit + '\'' +
                ", pPrice=" + pPrice +
                ", oId=" + oId +
                '}';
    }
}
