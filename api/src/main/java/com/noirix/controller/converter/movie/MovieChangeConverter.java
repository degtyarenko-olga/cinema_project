package com.noirix.controller.converter.movie;

import com.noirix.controller.dto.movie.MovieChangeRequest;
import com.noirix.entity.Movie;
import com.noirix.service.impl.MovieServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovieChangeConverter implements Converter<MovieChangeRequest, Movie> {
    private final MovieServiceImpl service;

    @Override
    public Movie convert(MovieChangeRequest source) {
        Movie movie = service.findById(source.getId());
        return movie;

    }

}
