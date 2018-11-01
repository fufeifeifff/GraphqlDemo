package com.igu.developer.demo.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by jession on 14-8-19.
 */
@Entity
@Table(name = "m_permission")
@Data
@EqualsAndHashCode(callSuper = true)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class MPermissionEntity extends AbstractPersistable<Long> implements Serializable {
    private static final long serialVersionUID = -4851876304794671261L;
    private String name;
    private boolean flgMenu;
    private String url;
    private String nmDisplay;
    private String cdPerm;
    private boolean flgDisplay;
    private boolean flgSystem;
    private String cdSort;

    @Setter @Getter
    private String icon;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "pid")
    private MPermissionEntity parent;

    @Transient
    private MPermissionEntity virtualParent;

    @JsonIgnore
    @OneToMany(mappedBy = "parent", fetch = FetchType.EAGER)
    @OrderBy(value = "cdSort")
    private List<MPermissionEntity> children;
    @Transient
    private boolean flgOwner;

    public MPermissionEntity() {
    }

    public MPermissionEntity(Long id) {
        this.setId(id);
    }

    public MPermissionEntity getVirtualParent() {
        return virtualParent == null ? parent : this.virtualParent;
    }

}
