package com.igu.developer.demo.dao;


import cn.wewin.modules.springdatajpa.MyJpaRepository;
import com.igu.developer.demo.entity.MPermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionDao extends JpaRepository<MPermissionEntity, Long> {

    List<MPermissionEntity> findByFlgMenuAndParentIdIsNullOrderByCdSortAsc(boolean flgMenu);

}
