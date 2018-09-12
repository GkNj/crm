package com.nuc.sw.crm.vo;




import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.nuc.sw.crm.entity.User;

import java.io.Serializable;

@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class DistributeVo implements Serializable {
    private  int dId;
    /**
     * user的ID
     */
    private User user;

    /**
     * 分配时间
     */
    private String dTime;

    private ServiceVO service;

    public int getdId() {
        return dId;
    }

    public void setdId(int dId) {
        this.dId = dId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getdTime() {
        return dTime;
    }

    public void setdTime(String dTime) {
        this.dTime = dTime;
    }

    public ServiceVO getService() {
        return service;
    }

    public void setService(ServiceVO service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return "DistributeVo{" +
                "dId=" + dId +
                ", user=" + user +
                ", dTime='" + dTime + '\'' +
                ", service=" + service +
                '}';
    }
}
