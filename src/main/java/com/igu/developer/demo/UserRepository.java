package com.igu.developer.demo;

import com.igu.developer.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByIdAndFlgDeleted(Long UserId, Integer flgDeleted);

}