package com.nuc.sw.crm.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Distribute {

    @Id
    @GeneratedValue
    private  int dId;
    /**
     * user的ID
     */
    private  int uId;
    /**
     * 分配时间
     */
    private String dTime;

    /**
     * 服务的编号
     */
    private int sId;

    public int getdId() {
        return dId;
    }

    public void setdId(int dId) {
        this.dId = dId;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getdTime() {
        return dTime;
    }

    public void setdTime(String dTime) {
        this.dTime = dTime;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public Distribute(int uId, String dTime, int sId) {
        this.uId = uId;
        this.dTime = dTime;
        this.sId = sId;
    }

    @Override
    public String toString() {
        return "Distribute{" +
                "dId=" + dId +
                ", uId=" + uId +
                ", dTime='" + dTime + '\'' +
                ", sId=" + sId +
                '}';
    }

    public Distribute() {
    }
}
