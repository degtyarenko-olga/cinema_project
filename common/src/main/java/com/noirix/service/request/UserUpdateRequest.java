package com.noirix.service.request;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class UserUpdateRequest {

    private String email;

    private Timestamp birth;
}
