package com.noirix.controller.dto.user;

import lombok.Data;

import javax.validation.constraints.Email;
import java.sql.Timestamp;

@Data
public class UserChangeRequest {

    private Long id;

    private String login;

    private String password;

    @Email
    private String email;

    private Timestamp birth;


}
