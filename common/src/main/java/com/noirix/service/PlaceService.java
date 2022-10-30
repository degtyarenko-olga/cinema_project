package com.noirix.service;

import com.noirix.entity.Place;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PlaceService {
    List<Place> findAllBy();

    Place findById(Long id);

    List<Place> findAllPlaceByRow(int row);

    Long delete(Long id);

    @Transactional
    Place create(Place place);

    Place update(Place place);
}
