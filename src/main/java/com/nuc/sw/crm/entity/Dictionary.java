package com.nuc.sw.crm.entity;

import org.apache.catalina.User;

import javax.persistence.*;

@Entity
public class Dictionary {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "type_key")
    private String typeKey;
    @Column(name = "type_value")
    private String typeValue;
    @Column(name = "index_num")
    private int indexNub;
    @Column(name = "p_id")
    private int parentID;
    @Column(name = "editable")
    private int editable;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeKey() {
        return typeKey;
    }

    public void setTypeKey(String typeKey) {
        this.typeKey = typeKey;
    }

    public String getTypeValue() {
        return typeValue;
    }

    public void setTypeValue(String typeValue) {
        this.typeValue = typeValue;
    }

    public int getIndexNub() {
        return indexNub;
    }

    public void setIndexNub(int indexNub) {
        this.indexNub = indexNub;
    }

    public int getParentID() {
        return parentID;
    }

    public void setParentID(int parentID) {
        this.parentID = parentID;
    }

    public int getEditable() {
        return editable;
    }

    public void setEditable(int editable) {
        this.editable = editable;
    }

    @Override
    public String toString() {
        return "Dictionary{" +
                "id=" + id +
                ", typeKey='" + typeKey + '\'' +
                ", typeValue='" + typeValue + '\'' +
                ", indexNub=" + indexNub +
                ", parentID=" + parentID +
                ", editable=" + editable +
                '}';
    }
}
