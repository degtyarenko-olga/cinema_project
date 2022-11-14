package com.noirix.service;

import com.noirix.entity.Place;

import java.util.List;

public interface PlaceService {
    List<Place> findAll();

    Place findById(Long id);

    List<Place> findAllPlaceByRow(int row);

    Long delete(Long id);

    Place create(Place place);

    Place update(Place place);

}
