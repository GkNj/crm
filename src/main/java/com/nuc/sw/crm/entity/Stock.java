package com.nuc.sw.crm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Stock {
    @Id
    @GeneratedValue
    private int sId;
    @Column(name = "s_name")
    private String sName;
    @Column(name = "s_address")
    private String sAddress;
    @Column(name = "s_position")
    private String sPosition;
    @Column(name = "s_num")
    private int sNum;
    @Column(name = "s_note")
    private String sNote;

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsAddress() {
        return sAddress;
    }

    public void setsAddress(String sAddress) {
        this.sAddress = sAddress;
    }

    public String getsPosition() {
        return sPosition;
    }

    public void setsPosition(String sPosition) {
        this.sPosition = sPosition;
    }

    public int getsNum() {
        return sNum;
    }

    public void setsNum(int sNum) {
        this.sNum = sNum;
    }

    public String getsNote() {
        return sNote;
    }

    public void setsNote(String sNote) {
        this.sNote = sNote;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "sId=" + sId +
                ", sName='" + sName + '\'' +
                ", sAddress='" + sAddress + '\'' +
                ", sPosition='" + sPosition + '\'' +
                ", sNum=" + sNum +
                ", sNote='" + sNote + '\'' +
                '}';
    }
}
