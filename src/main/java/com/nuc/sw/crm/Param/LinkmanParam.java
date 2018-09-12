package com.nuc.sw.crm.Param;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class LinkmanParam {


    private int lId;
    @NotNull(message = "姓名不能为空")
    private String lName;
    private String lSex;
    @NotNull(message = "职位不能为空")
    private String lPosition;
    @NotNull(message = "联系方式不能为空")
    private String lTel;
    private String lRemark;
    private int cId;

    public LinkmanParam() {
    }

    public LinkmanParam(int lId, String lName, String lSex, String lPosition, String lTel, String lRemark, int cId) {
        this.lId = lId;
        this.lName = lName;
        this.lSex = lSex;
        this.lPosition = lPosition;
        this.lTel = lTel;
        this.lRemark = lRemark;
        this.cId = cId;
    }

    public int getlId() {
        return lId;
    }

    public void setlId(int lId) {
        this.lId = lId;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getlSex() {
        return lSex;
    }

    public void setlSex(String lSex) {
        this.lSex = lSex;
    }

    public String getlPosition() {
        return lPosition;
    }

    public void setlPosition(String lPosition) {
        this.lPosition = lPosition;
    }

    public String getlTel() {
        return lTel;
    }

    public void setlTel(String lTel) {
        this.lTel = lTel;
    }

    public String getlRemark() {
        return lRemark;
    }

    public void setlRemark(String lRemark) {
        this.lRemark = lRemark;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    @Override
    public String toString() {
        return "Linkman{" +
                "lId=" + lId +
                ", lName='" + lName + '\'' +
                ", lSex='" + lSex + '\'' +
                ", lPosition='" + lPosition + '\'' +
                ", lTel='" + lTel + '\'' +
                ", lRemark='" + lRemark + '\'' +
                ", cId=" + cId +
                '}';
    }
}
