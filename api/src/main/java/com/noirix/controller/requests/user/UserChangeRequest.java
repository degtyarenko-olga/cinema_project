package com.noirix.controller.requests.user;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Data
public class UserChangeRequest extends UserCreateRequest {

    private Long id;

    @NotNull
    @Size(min = 8, max = 50)
    private String password;

    @Email
    private String email;

    private Timestamp birth;



}
