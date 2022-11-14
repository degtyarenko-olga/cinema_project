package com.noirix.service;

import com.noirix.entity.Place;

import java.util.List;

public interface PlaceService {
    List<Place> findAll();

    Place findById(Long id);

    List<Place> findAllPlaceByRow(Integer row);

    void delete(Long id);

    Place create(Place place);

    Place update(Place place);

}
