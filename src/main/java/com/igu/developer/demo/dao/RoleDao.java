package com.igu.developer.demo.dao;


import com.igu.developer.demo.entity.MRoleEntity;
import com.igu.developer.demo.entity.MUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao extends JpaRepository<MRoleEntity, Long> {

    List<MRoleEntity> findByNameContainingOrderByNmDisplayAsc(String name);

    MRoleEntity findByName(String name);

    MRoleEntity findByNmDisplay(String nmDisplay);

    List<MRoleEntity> findByUsers(MUserEntity user);

    List<MRoleEntity> findByNameInAndFlgDeletedIsFalse(List<String> roleNamesByApartmentAdminManaged);
}
