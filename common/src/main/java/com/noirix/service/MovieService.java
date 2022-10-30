package com.noirix.service;

import com.noirix.entity.Movie;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MovieService {
    @Cacheable("movies")
    List<Movie> findAll();

    List<Movie> findMovieHibernatesByTitle(String title);

    List<Movie> findAllByGenre(String genre);

    Movie findById(Long id);

    @Transactional
    Movie create(Movie movie);

    Long delete(Long id);

    @Transactional
    Movie update(Movie movie);
}
