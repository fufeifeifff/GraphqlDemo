package com.igu.developer.demo.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by jession on 14-8-19.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "m_user")
@Cache(region="common", usage = CacheConcurrencyStrategy.READ_WRITE)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class MUserEntity extends AbstractAuditable<MUserEntity, Long> {
    private static final long serialVersionUID = -370727614617587447L;
    private String loginName;
    private String realName;
    private String nickName;
    private Integer sex;
    private int status;
    private int source;
    private String password;
    private boolean flgDeleted;
    private Integer flgAuthRealname;
    private Integer flgFreeze;
    private Date birthday;
    private String identityNo;
    @Transient
    private String plainPassword;
    private String salt;

    // 多对多定义
    @ManyToMany
    @JoinTable(name = "m_user_role", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
    // Fecth策略定义
    @Fetch(FetchMode.SUBSELECT)
    // 集合按id排序
    @OrderBy("name ASC")
    // 缓存策略
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnore
    private List<MRoleEntity> roles;

    @Transient
    private String rolesString;

    private String mobile;

    public MUserEntity() {
    }

    public MUserEntity(Long id) {
        this.setId(id);
    }

    // 不持久化到数据库，也不显示在Restful接口的属性.
    @JsonIgnore
    public String getPlainPassword() {
        return plainPassword;
    }

    public void setPlainPassword(String plainPassword) {
        this.plainPassword = plainPassword;
    }





}
