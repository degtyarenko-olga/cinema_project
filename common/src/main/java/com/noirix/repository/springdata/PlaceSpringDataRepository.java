package com.noirix.repository.springdata;

import com.noirix.domain.hibernate.MovieHibernate;
import com.noirix.domain.hibernate.PlaceHibernate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlaceSpringDataRepository extends JpaRepository<PlaceHibernate, Long> {


    @Query(value = "select p from PlaceHibernate p")
    List<PlaceHibernate> findAllBy();
}
