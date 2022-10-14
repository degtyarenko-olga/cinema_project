package com.noirix.service;

import com.noirix.repository.springdata.PlaceSpringDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceSpringDataRepository repository;

    public Object findAllBy() {
        return repository.findAllBy();
    }
}
