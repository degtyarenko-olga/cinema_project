package com.noirix.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Data
@Embeddable
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Credentials {


    private String login;

    @JsonIgnore
    private String password;
}

