//package com.igu.developer.demo.service;
//
///**
// * Created by wuxia on 2017/8/22.
// */
//
//
//import com.igu.developer.demo.dao.RoleDao;
//import com.igu.developer.demo.entity.MRoleEntity;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.time.LocalDateTime;
//import java.util.Date;
//
//@Service
//@Transactional
//@Slf4j
//public class RoleService {
//    @Autowired
//    private RoleDao roleDao;
//
//    public MRoleEntity findByRoleName(String roleName){
//        return roleDao.findByName(roleName);
//    }
////    public Page<Map<String,Object>> findPageByParam(Pageable pageable, Map<String, Object> allParams) {
////        return roleDao.findPageByNativeQuery("findPage", pageable,allParams);
////    }
//    public  void addRole(MRoleEntity mRoleEntity){
//        MRoleEntity roleEntity = new MRoleEntity();
//        roleEntity.setDescription(mRoleEntity.getDescription());
//        roleEntity.setName(mRoleEntity.getName());
//        roleEntity.setCreatedDate(LocalDateTime.now());
//        roleEntity.setUpdateTime(new Date());
//        roleDao.save(roleEntity);
//    }
//
//}
