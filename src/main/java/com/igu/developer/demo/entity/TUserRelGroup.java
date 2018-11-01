package com.igu.developer.demo.entity;

/**
* @Author:fffu
* @Description:用户  开团 关联表
* @Date:2018/7/25 16:36
*/

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "t_user_rel_group")
public class TUserRelGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;

    private Integer groupId;
}
