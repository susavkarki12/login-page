package com.one.loginpage.controller;

import com.one.loginpage.Dto.RegisterDto;
import com.one.loginpage.model.UserRegisterPage;
import com.one.loginpage.service.UserRegisterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/register")
public class RegisterController {

   UserRegisterService userRegisterService;

    public RegisterController(UserRegisterService userRegisterService) {
        this.userRegisterService = userRegisterService;
    }


    @PostMapping
    public ResponseEntity<RegisterDto> createAccount(@Valid @RequestBody RegisterDto registerDto) {
        return new ResponseEntity<>(userRegisterService.createAccount(registerDto), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/get")
    public List<RegisterDto> getUserRegisterPage() {
        return userRegisterService.getAllUserList();
    }


}
