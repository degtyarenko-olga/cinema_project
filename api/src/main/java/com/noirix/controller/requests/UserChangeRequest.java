package com.noirix.controller.requests;

import com.noirix.controller.requests.UserCreateRequest;
import lombok.Data;

@Data
public class UserChangeRequest extends UserCreateRequest {

    private Long id;
}
