package com.noirix.service;

import com.noirix.domain.PlaceHibernate;
import com.noirix.repository.PlaceSpringDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceSpringDataRepository repository;

    public Object findAllBy() {
        return repository.findAllBy();
    }

    public PlaceHibernate findById(Long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Object findAllPlaceByRow(int row) {
        return repository.findAllByRow(row);
    }


    @Transactional
    public Long delete(Long id) {
        repository.deleteById(id);
        return id;

    }

    @Transactional
    public PlaceHibernate create(PlaceHibernate place) {

         return repository.save(place);

    }
}
