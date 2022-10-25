package com.noirix.service;

import com.noirix.repository.HallSpringDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HallService {

    private final HallSpringDataRepository repository;

    public Object findAllHall() {
        return repository.findAllHall();
    }

    public Object findById(Long id) {
        return repository.findById(id);
    }

    public Object findHallByName(String name) {
        return repository.findHallHibernateByNameHall(name);
    }
}
