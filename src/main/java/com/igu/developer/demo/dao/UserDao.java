package com.igu.developer.demo.dao;


import com.igu.developer.demo.entity.MUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<MUserEntity, Long> {

    @Modifying
    @Query(value = "update m_user_info u set u.password = 1111,u.SALT = 2222 WHERE u.id = 27", nativeQuery = true)
    int resetPssword(String password, String salt, Long userid);

    MUserEntity findByLoginNameAndFlgDeletedFalse(String loginName);

    MUserEntity findByMobileAndFlgDeletedFalse(String mobile);

    MUserEntity findByIdAndFlgDeletedFalse(long id);


    @Modifying
    @Query("update MUserEntity u set u.flgDeleted = ?1 where u.id = ?2")
    int setFixedFlgDeletedFor(boolean state, Long id);
}

