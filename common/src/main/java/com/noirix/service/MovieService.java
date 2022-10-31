package com.noirix.service;

import com.noirix.entity.Movie;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface MovieService {
    @Cacheable("movies")
    List<Movie> findAll();

    List<Movie> findMovieHibernatesByTitle(String title);

    List<Movie> findAllByGenre(String genre);

    Movie findById(Long id);

    Movie create(Movie movie);

    Long delete(Long id);

    Movie update(Movie movie);
}
