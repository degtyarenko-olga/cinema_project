package com.noirix.controller.dto.movie;

import lombok.Data;

@Data
public class MovieChangeRequest extends MovieCreateRequest{

    private Long id;
}
