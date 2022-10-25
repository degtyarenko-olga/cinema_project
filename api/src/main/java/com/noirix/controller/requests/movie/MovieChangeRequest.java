package com.noirix.controller.requests.movie;

import lombok.Data;

@Data
public class MovieChangeRequest extends MovieCreateRequest{

    private Long id;
}
