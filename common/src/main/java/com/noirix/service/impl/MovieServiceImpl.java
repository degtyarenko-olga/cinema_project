package com.noirix.service.impl;

import com.noirix.entity.Movie;
import com.noirix.repository.MovieSpringDataRepository;
import com.noirix.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MovieServiceImpl implements MovieService {

    private final MovieSpringDataRepository repository;

    @Override
    @Cacheable("movies")
    public List<Movie> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Movie> findMovieByTitle(String title) {
        return repository.findMovieByTitle(title);
    }

    @Override
    public List<Movie> findAllByGenre(String genre) {
        return repository.findMovieByGenre(genre);
    }

    @Override
    public Movie findById(Long id) {
        return repository.findById(id).orElse(new Movie());
    }

    @Override
    @Transactional
    public Movie create(Movie movie) {
        return repository.save(movie);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public Movie update(Movie movie) {
        return create(movie);
    }

}
