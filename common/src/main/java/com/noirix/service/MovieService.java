package com.noirix.service;

import com.noirix.entity.Movie;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface MovieService {
    List<Movie> findAll();

    List<Movie> findMovieByTitle(String title);

    List<Movie> findAllByGenre(String genre);

    Movie findById(Long id);

    Movie create(Movie movie);

    void delete(Long id);

    Movie update(Movie movie);

}
