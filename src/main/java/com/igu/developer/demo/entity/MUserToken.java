package com.igu.developer.demo.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "m_user_token")
public class MUserToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;

    private String device;

    private Integer deviceType;

    private String token;

    private String validTime;

    private Integer flgDeleted;

    private Date createTime;

    private Date updateTime;

}