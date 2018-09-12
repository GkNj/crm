package com.nuc.sw.crm.entity;



import javax.persistence.*;

@Entity
public class Opportunity1 {
    @Id
    @GeneratedValue
    private int id;
    //机会来源
    private String resource;
    //机会状态
    private String state;
    //客户id
    private String cName;
    //客户姓名
    private int successPercent;
    //机会概要
    private String summary;
    //联系人姓名

    private String lName;
    //联系人电话

    private String lPhone;
    //机会描述
    private String cComment;
    //创建人
    private String sName;
    //创建时间
    private String startDate;
    //指派人id
    @ManyToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "p_id",referencedColumnName = "id")
    private User pId;
    //指派时间
    private String pDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public int getSuccessPercent() {
        return successPercent;
    }

    public void setSuccessPercent(int successPercent) {
        this.successPercent = successPercent;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getlPhone() {
        return lPhone;
    }

    public void setlPhone(String lPhone) {
        this.lPhone = lPhone;
    }

    public String getcComment() {
        return cComment;
    }

    public void setcComment(String cComment) {
        this.cComment = cComment;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }


    public String getpDate() {
        return pDate;
    }

    public void setpDate(String pDate) {
        this.pDate = pDate;
    }

    @Override
    public String toString() {
        return "Opportunity1{" +
                "id=" + id +
                ", resource='" + resource + '\'' +
                ", state='" + state + '\'' +
                ", cName='" + cName + '\'' +
                ", successPercent=" + successPercent +
                ", summary='" + summary + '\'' +
                ", lName='" + lName + '\'' +
                ", lPhone='" + lPhone + '\'' +
                ", cComment='" + cComment + '\'' +
                ", sName='" + sName + '\'' +
                ", startDate='" + startDate + '\'' +
                ", pId=" + pId +
                ", pDate='" + pDate + '\'' +
                '}';
    }
}
