package com.igu.developer.demo.dao;

import cn.wewin.modules.springdatajpa.MyJpaRepository;
import cn.wewin.modules.springdatajpa.annotation.CustomQueries;
import cn.wewin.modules.springdatajpa.annotation.CustomQuery;
import com.igu.developer.demo.entity.MUserAddress;
import com.igu.developer.demo.vo.AddressVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @Author:fffu
* @Description:
* @Date:2018/10/22 18:27
*/
@CustomQueries(
        queries = {
                @CustomQuery(
                        name = "findAddressByUserId",
                        sql = "SELECT mud.* \n" +
                                "FROM m_user_address mud\n" +
                                "LEFT JOIN m_user mus ON mus.ID = mud.BUSINESS_ID\n" +
                                "WHERE 1=1" +
                                "[and mus.ID = :UserId]"
                )
        }
)
@Repository
public interface UserAddressDao extends JpaRepository<MUserAddress, Long> {

    List<MUserAddress> findByBusinessIdAndFlgDeleted(Integer businessId, Integer flgDeleted);


    List<AddressVo> findAddressByBusinessIdAndFlgDeleted(Integer businessId, Integer flgDeleted);

    @Override
    Page<MUserAddress> findAll(Pageable pageable);

    @Query(value = "SELECT mua.ID id,mua.ADDRESS FROM\n" +
            "m_user_address mua",
            nativeQuery = true
    )
    AddressVo findAddressByHQLResultObj();

    MUserAddress findByIdAndFlgDeleted(Long id, Integer flgDeleted);


}
