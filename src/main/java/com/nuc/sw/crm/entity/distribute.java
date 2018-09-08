package com.nuc.sw.crm.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class distribute {

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
    private Date dTime;

    public distribute() {
    }

    @Override
    public String toString() {
        return "distribute{" +
                "dId=" + dId +
                ", uId=" + uId +
                ", dTime=" + dTime +
                ", sId=" + sId +
                '}';
    }

    public distribute(int uId, Date dTime, int sId) {
        this.uId = uId;
        this.dTime = dTime;
        this.sId = sId;
    }

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

    public Date getdTime() {
        return dTime;
    }

    public void setdTime(Date dTime) {
        this.dTime = dTime;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    /**
     * 服务的编号
     */
    private int sId;
}
