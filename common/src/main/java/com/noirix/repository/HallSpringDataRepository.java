package com.noirix.repository;

import com.noirix.domain.HallHibernate;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HallSpringDataRepository extends JpaRepository<HallHibernate, Long> {

    @Query(value = "select h from HallHibernate h")
    List<HallHibernate> findAllHall();

    @Cacheable("hall")
    List<HallHibernate> findAll();

    HallHibernate findHallHibernateByNameHall(String name);
}
