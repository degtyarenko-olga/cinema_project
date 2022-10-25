package com.noirix.service;

import com.noirix.domain.PlaceHibernate;
import com.noirix.repository.PlaceSpringDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceSpringDataRepository repository;

    public Object findAllBy() {
        return repository.findAllBy();
    }

    public Object findById(Long id) {
        return repository.findById(id);
    }

    public Object findAllPlaceByRow(int row){
        return repository.findAllByRow(row);
    }



}
