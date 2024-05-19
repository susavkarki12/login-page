package com.one.loginpage.repository;

import com.one.loginpage.model.UserRegisterPage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoginRepository extends JpaRepository<UserRegisterPage, String> {

}
