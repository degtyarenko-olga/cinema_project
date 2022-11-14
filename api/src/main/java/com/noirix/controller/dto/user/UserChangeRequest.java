package com.noirix.controller.dto.user;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.Data;

import javax.validation.constraints.Email;
import java.sql.Timestamp;

@Data
public class UserChangeRequest {
    @Hidden
    private Long id;

    private String login;

    private String password;

    @Email
    private String email;

    private Timestamp birth;


}
