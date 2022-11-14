package com.noirix.service.impl;

import com.noirix.entity.Place;
import com.noirix.repository.PlaceSpringDataRepository;
import com.noirix.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaceServiceImpl implements PlaceService {

    private final PlaceSpringDataRepository repository;

    @Override
    public List<Place> findAll() {
        return repository.findAll();
    }

    @Override
    public Place findById(Long id) {
        return repository.findById(id).orElse(new Place());
    }

    @Override
    public List<Place> findAllPlaceByRow(Integer row) {
        return repository.findAllByRow(row);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Place create(Place place) {
        return repository.save(place);
    }

    @Override
    public Place update(Place place) {
        return create(place);
    }

}
