package com.noirix.service;

import com.noirix.entity.Hall;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface HallService {

    List<Hall> findAllHall();

    Hall findById(Long id);

    Hall findHallByName(String name);

    @Transactional
    Hall create(Hall hall);

    Long delete(Long id);

    @Transactional
    Hall update(Hall hall);
}
