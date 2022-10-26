package com.noirix.repository;

import com.noirix.domain.PlaceHibernate;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PlaceSpringDataRepository extends JpaRepository<PlaceHibernate, Long> {

    @Cacheable("places")
    @Query(value = "select p from PlaceHibernate p")
    List<PlaceHibernate> findAllBy();


    List<PlaceHibernate> findAllByRow(int row);
}
