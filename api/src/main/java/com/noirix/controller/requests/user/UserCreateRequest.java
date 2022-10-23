package com.noirix.controller.requests.user;

import lombok.Data;

import java.sql.Timestamp;


@Data
//@ApiModel(description = "Create user object without system info")
public class UserCreateRequest {

   // @ApiModelProperty(required = true, allowableValues = "Admin", dataType = "string", notes = "user's login")
    //@NotNull
   // @Size(min = 2, max = 20, message = "Login should be between 2 and 20 characters")
    private String login;

   // @ApiModelProperty(required = true, allowableValues = "ADMIN", dataType = "string", notes = "user's password")
    //@NotNull
    //@Size(min = 8, max = 20, message = "Password should be between 8 and 20 characters")
    private String password;

    //@Email(message = "Email should be valid")
    //@Size(max = 50, message = "Email should be 50 characters or less")
    private String email;

    //@ApiModelProperty(required = true, allowableValues = "1665685166000", dataType = "timestamp", notes = "user's birth")
    private Timestamp birth;
}
