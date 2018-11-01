package com.igu.developer.demo.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "t_sms")
public class TSms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mobile;

    private String smsCode;

    private String smsContent;

    private Integer flgUse;

    private Integer type;

    private Double expireTime;

    private Integer flgDeleted;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode == null ? null : smsCode.trim();
    }

    public String getSmsContent() {
        return smsContent;
    }

    public void setSmsContent(String smsContent) {
        this.smsContent = smsContent == null ? null : smsContent.trim();
    }

    public Integer getFlgUse() {
        return flgUse;
    }

    public void setFlgUse(Integer flgUse) {
        this.flgUse = flgUse;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Double getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Double expireTime) {
        this.expireTime = expireTime;
    }

    public Integer getFlgDeleted() {
        return flgDeleted;
    }

    public void setFlgDeleted(Integer flgDeleted) {
        this.flgDeleted = flgDeleted;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}