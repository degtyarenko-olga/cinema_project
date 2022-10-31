package com.noirix.repository;

import com.noirix.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceSpringDataRepository extends JpaRepository<Place, Long> {

    List<Place> findAllByRow(int row);

}
