package com.noirix.service;

import com.noirix.entity.Movie;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MovieService {
    List<Movie> findAll();

    List<Movie> findMovieHibernatesByTitle(String title);

    List<Movie> findAllByGenre(String genre);

    Movie findById(Long id);

    @Transactional
    Object create(Movie movie);

    Long delete(Long id);

    Movie update(Movie movie);
}
