package com.noirix.controller.requests.user;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;


@Data
public class UserCreateRequest {

    @NotNull
    @Size(min = 2, max = 20)
    private String login;

    @NotNull
    @Size(min = 8, max = 50)
    private String password;

    @Email
    private String email;

    private Timestamp birth;
}
