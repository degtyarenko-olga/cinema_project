package com.noirix.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Embeddable
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Credentials {
//    @NotBlank(message = "Enter login")
//    @Size(min = 2, max = 20, message = "Login should be between 2 and 20 characters")
    private String login;

//    @NotBlank(message = "Enter password")
//    @Size(min = 8, max = 20, message = "Password should be between 8 and 20 characters")
    @JsonIgnore
    private String password;
}

