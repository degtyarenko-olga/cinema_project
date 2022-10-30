package com.noirix.repository;

import com.noirix.entity.Movie;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieSpringDataRepository extends JpaRepository<Movie, Long> {

    @Cacheable("movies")
    List<Movie> findAll();

    List<Movie> findMovieHibernatesByTitle(String title);

    List<Movie> findMovieHibernatesByGenre(String genre);

}
