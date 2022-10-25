package com.noirix.controller.converter.movie;

import com.noirix.controller.requests.movie.MovieChangeRequest;
import com.noirix.controller.requests.movie.MovieCreateRequest;
import com.noirix.domain.MovieHibernate;
import com.noirix.domain.UsersHibernate;
import com.noirix.repository.MovieSpringDataRepository;
import com.noirix.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MovieChangeConverter implements Converter<MovieChangeRequest, MovieHibernate> {

    private final MovieService service;


    @Override
    public MovieHibernate convert(MovieChangeRequest source) {

        MovieHibernate movie = service.findById(source.getId());

        return movie;
    }
}
