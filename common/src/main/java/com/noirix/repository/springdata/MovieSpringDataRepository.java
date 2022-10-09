package com.noirix.repository.springdata;

import com.noirix.domain.hibernate.MovieHibernate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieSpringDataRepository extends JpaRepository<MovieHibernate, Long> {


    @Query(value = "select m from MovieHibernate m")
    List<MovieHibernate> findAllMovie();
}
