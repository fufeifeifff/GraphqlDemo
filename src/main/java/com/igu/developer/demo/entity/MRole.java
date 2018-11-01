package com.igu.developer.demo.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "m_role")
public class MRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;

    private String nmDisplay;

    private Byte flgSystem;

    private Byte flgBusiness;

    private Byte status;

    private Byte flgDeleted;

    private Integer createdBy;

    private Date createTime;

    private Integer lastModifiedBy;

    private Date lastModifiedTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getNmDisplay() {
        return nmDisplay;
    }

    public void setNmDisplay(String nmDisplay) {
        this.nmDisplay = nmDisplay == null ? null : nmDisplay.trim();
    }

    public Byte getFlgSystem() {
        return flgSystem;
    }

    public void setFlgSystem(Byte flgSystem) {
        this.flgSystem = flgSystem;
    }

    public Byte getFlgBusiness() {
        return flgBusiness;
    }

    public void setFlgBusiness(Byte flgBusiness) {
        this.flgBusiness = flgBusiness;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getFlgDeleted() {
        return flgDeleted;
    }

    public void setFlgDeleted(Byte flgDeleted) {
        this.flgDeleted = flgDeleted;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(Integer lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(Date lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }
}