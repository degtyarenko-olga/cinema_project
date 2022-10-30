package com.noirix.repository;

import com.noirix.entity.Place;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PlaceSpringDataRepository extends JpaRepository<Place, Long> {

    @Cacheable("places")
    @Query(value = "select p from Place p")
    List<Place> findAllBy();


    List<Place> findAllByRow(int row);
}
