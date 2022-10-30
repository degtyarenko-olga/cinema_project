package com.noirix.controller.dto.user;

import lombok.Data;

@Data
public class UserSearchRequest {

    private String limit;

    private String offset;

    private String searchQuery;

}
