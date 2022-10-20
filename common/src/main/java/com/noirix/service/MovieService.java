package com.noirix.service;

import com.noirix.repository.MovieSpringDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Transactional
    public Object findAllByGenre(String genre) {
        return repository.findAllByGenre(genre);
    }
}
