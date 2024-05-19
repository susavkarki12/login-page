package com.one.loginpage.Dto;

import com.one.loginpage.model.Roles;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {
    private Long id;

    @NotNull
    @Size(min = 3, message = "The username must be at least 3 characters long")
    private String userName;

    @NotNull
    @Size(min = 3)
    private String password;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String phone;
    

}
