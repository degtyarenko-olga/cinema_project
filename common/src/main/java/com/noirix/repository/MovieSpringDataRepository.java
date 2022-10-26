package com.noirix.repository;

import com.noirix.domain.MovieHibernate;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieSpringDataRepository extends JpaRepository<MovieHibernate, Long> {

    @Cacheable("movies")
    List<MovieHibernate> findAll();

    List<MovieHibernate> findMovieHibernatesByTitle(String title);

    List<MovieHibernate> findMovieHibernatesByGenre(String genre);

}
