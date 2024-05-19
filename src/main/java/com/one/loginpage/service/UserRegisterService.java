package com.one.loginpage.service;

import com.one.loginpage.Dto.RegisterDto;
import com.one.loginpage.model.UserRegisterPage;

import java.util.List;

public interface UserRegisterService {
    public RegisterDto createAccount(RegisterDto registerDto);
    List<RegisterDto> getAllUserList();

}
