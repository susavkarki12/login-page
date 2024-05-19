package com.one.loginpage.service.impl;

import com.one.loginpage.Dto.RegisterDto;
import com.one.loginpage.model.UserRegisterPage;
import com.one.loginpage.repository.UserLoginRepository;
import com.one.loginpage.repository.UserRegisterRepository;
import com.one.loginpage.service.UserRegisterService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Component
public class UserRegisterImpl implements UserRegisterService {
    UserLoginRepository loginRepository;

    public UserRegisterImpl(UserLoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public RegisterDto createAccount(RegisterDto registerDto) {
        UserRegisterPage userRegister= mapToEntity(registerDto);
        UserRegisterPage newPage= loginRepository.save(userRegister);
        return mapToDto(newPage);
    }

    @Override
    public List<RegisterDto> getAllUserList() {
        List<UserRegisterPage> pageList= loginRepository.findAll();
        return pageList.stream().map(page -> mapToDto(page)).collect(Collectors.toList());
    }


    private UserRegisterPage mapToEntity(RegisterDto registerDto) {
        UserRegisterPage userRegisterPage = new UserRegisterPage();
        userRegisterPage.setUserName(registerDto.getUserName());
        userRegisterPage.setPassword(registerDto.getPassword());
        userRegisterPage.setEmail(registerDto.getEmail());
        userRegisterPage.setPhone(registerDto.getPhone());

        return userRegisterPage;
    }
    private RegisterDto mapToDto(UserRegisterPage userRegisterPage) {
        RegisterDto registerDto = new RegisterDto();
        registerDto.setId(userRegisterPage.getId());
        registerDto.setUserName(userRegisterPage.getUserName());
        registerDto.setPassword(userRegisterPage.getPassword());
        registerDto.setEmail(userRegisterPage.getEmail());
        registerDto.setPhone(userRegisterPage.getPhone());
        return registerDto;
    }
}
