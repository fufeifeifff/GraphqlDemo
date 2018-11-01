package com.igu.developer.demo.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
* @Author:fffu
* @Description:开团列表
* @Date:2018/7/16 10:17
*/
@Data
@Table(name = "t_user_group_goods")
public class TUserGroupGoods implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;

    private String imgUrl;

    private Integer goodsId;

    private Integer lessNum;

    private String userPhone;

    private Integer groupNum;

    private Date startTime;

    private Date endTime;

    private Date createTime;
}
