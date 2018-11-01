package com.igu.developer.demo.entity;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class User implements Serializable{

    private static final long serialVersionUID = -8898121245997614680L;
    @Id @GeneratedValue
    @GraphQLQuery(name = "id", description = "A user's id")
    private Long id;
    @GraphQLQuery(name = "loginName", description = "A car's loginName")
    private String loginName;
    @GraphQLQuery(name = "nickName", description = "A car's nickName")
    private String nickName;
    @GraphQLQuery(name = "realName", description = "A car's realName")
    private String realName;
    @GraphQLQuery(name = "identityNo", description = "A car's identityNo")
    private String identityNo;
    @GraphQLQuery(name = "salt", description = "A car's salt")
    private String salt;
    @GraphQLQuery(name = "password", description = "A car's password")
    private String password;
    @GraphQLQuery(name = "mobile", description = "A car's mobile")
    private String mobile;
    @GraphQLQuery(name = "sex", description = "A car's sex")
    private Integer sex;
    @GraphQLQuery(name = "headIcon", description = "A car's headIcon")
    private String headIcon;
    @GraphQLQuery(name = "userType", description = "A car's userType")
    private Integer userType;
    @GraphQLQuery(name = "birthday", description = "A car's birthday")
    private Date birthday;
    @GraphQLQuery(name = "height", description = "A car's height")
    private Double height;
    @GraphQLQuery(name = "weight", description = "A car's weight")
    private Double weight;
    @GraphQLQuery(name = "flgFreeze", description = "A car's flgFreeze")
    private Integer flgFreeze;
    @GraphQLQuery(name = "flgDeleted", description = "A car's flgDeleted")
    private Integer flgDeleted;
    @GraphQLQuery(name = "flgMember", description = "A car's flgMember")
    private Integer flgMember;
    @GraphQLQuery(name = "createdBy", description = "A car's createdBy")
    private Integer createdBy;
    @GraphQLQuery(name = "createTime", description = "A car's createTime")
    private Date createTime;
    @GraphQLQuery(name = "lastModifiedBy", description = "A car's lastModifiedBy")
    private Integer lastModifiedBy;
    @GraphQLQuery(name = "lastModifiedTime", description = "A car's lastModifiedTime")
    private Date lastModifiedTime;
    @GraphQLQuery(name = "bankMemberId", description = "A car's bankMemberId")
    private String bankMemberId;
    @GraphQLQuery(name = "memberStatus", description = "A car's memberStatus")
    private Integer memberStatus;
}