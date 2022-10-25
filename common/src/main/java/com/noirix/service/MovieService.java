package com.noirix.service;

import com.noirix.domain.MovieHibernate;
import com.noirix.repository.MovieSpringDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieSpringDataRepository repository;

    public Object findAll() {
        return repository.findAll();
    }

    public Object findMovieHibernatesByTitle(String title) {
        return repository.findMovieHibernatesByTitle(title);
    }


    public Object findAllByGenre(String genre) {
        return repository.findMovieHibernatesByGenre(genre);
    }

    public MovieHibernate findById(Long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Transactional
    public Object create(MovieHibernate movie) {

        MovieHibernate movieHibernate = repository.save(movie);
        return movieHibernate;

    }

    @Transactional
    public Object delete(Long id) {

        repository.deleteById(id);

        return id;

    }

    public Object update(MovieHibernate movie) {
        return repository.save(movie);

    }
}
