package com.one.loginpage.repository;

import com.one.loginpage.model.UserRegisterPage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRegisterRepository extends JpaRepository<UserRegisterPage, Long> {
    Optional<UserRegisterPage> findByUserName(String userName);
    Optional<UserRegisterPage> findByEmail(String email);
    Optional<UserRegisterPage> findByUserNameOrEmail(String userName, String email);
    Boolean existsByUserName(String userName);
    Boolean existsByEmail(String email);

}
