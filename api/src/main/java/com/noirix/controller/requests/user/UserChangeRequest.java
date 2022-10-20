package com.noirix.controller.requests.user;

import lombok.Data;

@Data
public class UserChangeRequest extends UserCreateRequest {

    private Long id;
}
