package com.noirix.controller.dto.movie;

import lombok.Data;

@Data
public class MovieCreateRequest {

    private String title;

    private String description;

    private String genre;

    private int ageRestrictions;
}
