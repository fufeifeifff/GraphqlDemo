package com.igu.developer.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by jession on 13/11/2016.
 */
@MappedSuperclass
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractAuditable<U, PK extends Serializable> extends AbstractPersistable<PK> {

    private static final long serialVersionUID = 141481953116476081L;
    /*@ManyToOne
    @CreatedBy
    private U createdBy;*/
    @Column(name = "create_time")
    @CreatedDate
    private LocalDateTime createdDate;
    /*@ManyToOne
    @LastModifiedBy
    private U lastModifiedBy;
    @LastModifiedDate
    @Column(name = "last_modified_time")
    private LocalDateTime lastModifiedDate;*/

}
