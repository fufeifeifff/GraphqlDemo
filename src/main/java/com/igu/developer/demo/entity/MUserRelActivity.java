package com.igu.developer.demo.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
* @Author:fffu
* @Description:用户活动关联
* @Date:2018/7/11 16:51
*/
@Data
@Table(name = "m_user_rel_activity")
public class MUserRelActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;

    private Integer activityId;

    private Integer flgDeleted;

    private Integer flgStatus;

    private Date createTime;
}
