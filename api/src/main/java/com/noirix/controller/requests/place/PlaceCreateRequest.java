package com.noirix.controller.requests.place;

import lombok.Data;

@Data
public class PlaceCreateRequest {

    private int place;

    private int row;

    private Boolean isAvailable;

    private Double price;

}