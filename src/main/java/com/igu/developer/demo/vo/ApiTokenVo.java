package com.igu.developer.demo.vo;

import cn.wewin.modules.springdatajpa.vo.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ApiTokenVo extends BaseVo {

    private String token;
    private String device;
}
