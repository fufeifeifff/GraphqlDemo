package com.igu.developer.demo.entity;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractAuditable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
/**
* @Author:fuff
* @Description:用户类
* @Date: 10:01 2018/10/23
*/
//@Data
//@Entity
//@EqualsAndHashCode(callSuper = true)
//@Table(name = "m_user")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class MUser extends AbstractAuditable<MUser, Long> {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false)
//    private Integer id;

    private static final long serialVersionUID = 386034749373924445L;

    private String loginName;

    private String nickName;

    private String realName;

    private String identityNo;

    private String salt;

    private String password;

    private String mobile;

    private Integer sex;

    private String headIcon;

    private Integer userType;

    private Date birthday;

    private Double height;

    private Double weight;

    private Integer flgFreeze;

    private Integer flgDeleted;

    private Integer flgMember;

//    private Integer createdBy;

    private Date createTime;

//    private Integer lastModifiedBy;

    private Date lastModifiedTime;

    private String bankMemberId;

    private Integer memberStatus;
}