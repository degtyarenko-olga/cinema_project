package com.noirix.service;

import com.noirix.entity.Hall;

import java.util.List;

public interface HallService {
    List<Hall> findAllHall();

    Hall findById(Long id);

    Hall findHallByName(String name);

    Hall create(Hall hall);

    void delete(Long id);

    Hall update(Hall hall);

}
