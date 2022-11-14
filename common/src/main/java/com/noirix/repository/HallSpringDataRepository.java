package com.noirix.repository;

import com.noirix.entity.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HallSpringDataRepository extends JpaRepository<Hall, Long> {

    Optional<Hall> findHallByNameHall(String name);

}
