package com.noirix.controller.requests.movie;

import lombok.Data;

@Data
public class MovieCreateRequest {

    private String title;

    private String description;

    private String genre;

    private int ageRestrictions;
}
