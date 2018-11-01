package com.igu.developer.demo.entity;

import lombok.Getter;
import lombok.Setter;
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
@Table(name = "m_role")
@Getter
@Setter
@org.hibernate.annotations.Cache(region = "common", usage = CacheConcurrencyStrategy.READ_WRITE)
public class MRoleEntity extends AbstractAuditable<MUserEntity, Long> {
    private static final long serialVersionUID = 1973317447477922449L;
    private String name;
    private String nmDisplay;
    private boolean flgSystem;
    private int status;
    private String description;
    private Date  updateTime;
    @Transient
    private boolean check;

    public MRoleEntity() {
    }

    public MRoleEntity(Long id) {
        this.setId(id);
    }

    // 多对多定义
    @ManyToMany
    @JoinTable(name = "m_role_permission", joinColumns = {@JoinColumn(name = "role_id")}, inverseJoinColumns = {@JoinColumn(name = "permission_id")})
    // Fecth策略定义
    @Fetch(FetchMode.SUBSELECT)
    // 集合按id排序
    @OrderBy("id ASC")
    // 缓存策略
    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private List<MPermissionEntity> permissions;

    // 多对多定义
    @ManyToMany
    @JoinTable(name = "m_user_role", joinColumns = {@JoinColumn(name = "role_id")}, inverseJoinColumns = {@JoinColumn(name = "user_id")})
    // Fecth策略定义
    @Fetch(FetchMode.SUBSELECT)
    // 集合按id排序
    @OrderBy("realName ASC")
    // 缓存策略
    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private List<MUserEntity> users;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MRoleEntity that = (MRoleEntity) o;

        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (nmDisplay != null ? nmDisplay.hashCode() : 0);
        result = 31 * result + (flgSystem ? 1 : 0);
        result = 31 * result + status;
        return result;
    }
}
