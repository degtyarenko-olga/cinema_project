package com.noirix.controller.dto.user;

import lombok.Data;

import javax.validation.constraints.Email;
import java.sql.Timestamp;


@Data
public class UserCreateRequest {


    private String login;


    private String password;

    @Email
    private String email;

    private Timestamp birth;
}
