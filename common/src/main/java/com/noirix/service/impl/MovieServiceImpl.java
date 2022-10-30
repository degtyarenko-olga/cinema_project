package com.noirix.service.impl;

import com.noirix.entity.Movie;
import com.noirix.repository.MovieSpringDataRepository;
import com.noirix.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieSpringDataRepository repository;

    @Override
    public List<Movie> findAll() {
        return repository.findAll();

    }

    @Override
    public List<Movie> findMovieHibernatesByTitle(String title) {
        return repository.findMovieHibernatesByTitle(title);

    }

    @Override
    public List<Movie> findAllByGenre(String genre) {
        return repository.findMovieHibernatesByGenre(genre);

    }

    @Override
    public Movie findById(Long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);

    }

    @Override
    @Transactional
    public Object create(Movie movie) {
        Movie movieHibernate = repository.save(movie);
        return movieHibernate;

    }

    @Override
    public Long delete(Long id) {
        repository.deleteById(id);
        return id;

    }

    @Override
    public Movie update(Movie movie) {
        return repository.save(movie);

    }

}
