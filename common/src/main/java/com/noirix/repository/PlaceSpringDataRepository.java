package com.noirix.repository;

import com.noirix.domain.PlaceHibernate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PlaceSpringDataRepository extends JpaRepository<PlaceHibernate, Long> {


    @Query(value = "select p from PlaceHibernate p")
    List<PlaceHibernate> findAllBy();
}
