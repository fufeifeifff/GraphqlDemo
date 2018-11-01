package com.igu.developer.demo.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "m_address")
public class MAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String addressName;

    private Integer addressCode;

    private Integer parentAddressCode;

    private Integer addressLevel;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName == null ? null : addressName.trim();
    }

    public Integer getAddressCode() {
        return addressCode;
    }

    public void setAddressCode(Integer addressCode) {
        this.addressCode = addressCode;
    }

    public Integer getParentAddressCode() {
        return parentAddressCode;
    }

    public void setParentAddressCode(Integer parentAddressCode) {
        this.parentAddressCode = parentAddressCode;
    }

    public Integer getAddressLevel() {
        return addressLevel;
    }

    public void setAddressLevel(Integer addressLevel) {
        this.addressLevel = addressLevel;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}