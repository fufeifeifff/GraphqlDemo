package com.igu.developer.demo.entity;


import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "t_message")
public class TMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer receiveId;

    private Integer businessId;

    private String title;

    private Integer type;

    private Integer flgRead;

    private Integer flgDeleted;

    private Integer flgSuccess;

    private Date createTime;

    private Date updateTime;

    private String content;

}