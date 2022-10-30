package com.noirix.repository;

import com.noirix.entity.Hall;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HallSpringDataRepository extends JpaRepository<Hall, Long> {

    @Query(value = "select h from Hall h")
    List<Hall> findAllHall();

    @Cacheable("hall")
    List<Hall> findAll();

    Hall findHallHibernateByNameHall(String name);
}
