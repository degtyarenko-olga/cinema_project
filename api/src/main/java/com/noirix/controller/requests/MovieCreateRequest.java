package com.noirix.controller.requests;

import lombok.Data;

@Data
public class MovieCreateRequest {

    String title;

    String description;

    String genre;

    int ageRestrictions;


}
