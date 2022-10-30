package com.noirix.service.impl;

import com.noirix.entity.Hall;
import com.noirix.repository.HallSpringDataRepository;
import com.noirix.service.HallService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HallServiceImpl implements HallService {

    private final HallSpringDataRepository repository;

    @Override
    public List<Hall> findAllHall() {
        return repository.findAll();

    }

    @Override
    public Hall findById(Long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);

    }

    @Override
    public Hall findHallByName(String name) {
        return repository.findHallHibernateByNameHall(name);

    }

    @Override
    @Transactional
    public Hall create(Hall hall) {
        return repository.save(hall);

    }

    @Override
    public Long delete(Long id) {
        repository.deleteById(id);
        return id;

    }

    @Override
    public Hall update(Hall hall) {
        return repository.save(hall);
    }

}
