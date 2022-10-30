package com.noirix.controller.converter.movie;

import com.noirix.controller.dto.movie.MovieChangeRequest;
import com.noirix.entity.Movie;
import com.noirix.service.MovieService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MovieChangeConverter implements Converter<MovieChangeRequest, Movie> {
    private final MovieService service;

    public MovieChangeConverter(MovieService service) {
        this.service = service;
    }

    @Override
    public Movie convert(MovieChangeRequest source) {
        Movie movie = service.findById(source.getId());
        movie.setDescription(source.getDescription());
        movie.setGenre(source.getGenre());
        movie.setAgeRestrictions(source.getAgeRestrictions());
        movie.setTitle(source.getTitle());
        return movie;

    }

}
