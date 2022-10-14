package com.noirix.controller.requests;

import lombok.Data;

import java.sql.Timestamp;


@Data
public class UserCreateRequest {

    private String login;

    private String password;

    private String email;

    private Timestamp birth;
}
