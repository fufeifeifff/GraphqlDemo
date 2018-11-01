package com.igu.developer.demo.vo;

import cn.wewin.modules.springdatajpa.vo.BaseVo;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.*;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
* @Author:fffu
* @Description:测试多层数据封装
* @Date:2018/10/23 11:00
*/

@Data
public class UserVo {

    @GraphQLQuery(name = "id", description = "A userVo's id")
    private Long id;
    @GraphQLQuery(name = "loginName", description = "A userVo's loginName")
    private String loginName;
    @GraphQLQuery(name = "nickName", description = "A userVo's nickName")
    private String nickName;
    @GraphQLQuery(name = "realName", description = "A userVo's realName")
    private String realName;
    @GraphQLQuery(name = "mobile", description = "A userVo's mobile")
    private String mobile;
    @GraphQLQuery(name = "sex", description = "A userVo's sex")
    private Integer sex;
    @GraphQLQuery(name = "userType", description = "A userVo's userType")
    private Integer userType;
    @GraphQLQuery(name = "birthday", description = "A userVo's birthday")
    private Date birthday;
    private List<AddressList> address;

    @Data
    public static class AddressList{
        @GraphQLQuery(name = "id", description = "A userVo's id")
        private Long id;
        @GraphQLQuery(name = "businessId", description = "A address's businessId")
        private Integer businessId;
        @GraphQLQuery(name = "receiverName", description = "A address's receiverName")
        private String receiverName;
        @GraphQLQuery(name = "receiverPhone", description = "A address's receiverPhone")
        private String receiverPhone;
        @GraphQLQuery(name = "address", description = "A address's address")
        private String address;
        @GraphQLQuery(name = "detailAddress", description = "A address's detailAddress")
        private String detailAddress;
        @GraphQLQuery(name = "completeAddress", description = "A address's completeAddress")
        private String completeAddress;
        @GraphQLQuery(name = "addressType", description = "A address's addressType")
        private Integer addressType;
    }
}
