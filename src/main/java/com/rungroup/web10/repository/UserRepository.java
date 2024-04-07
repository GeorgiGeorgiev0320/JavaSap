package com.rungroup.web10.repository;

import com.rungroup.web10.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
    UserEntity findByUserName(String userName);
    UserEntity findFirstByUserName(String userName);
}
