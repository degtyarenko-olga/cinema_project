package com.noirix.controller.requests;

import lombok.Data;


@Data
public class UserCreateRequest {

    private String userName;

    private String password;

    private String email;
}