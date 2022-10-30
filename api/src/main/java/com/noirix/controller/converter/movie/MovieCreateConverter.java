package com.noirix.controller.converter.movie;

import com.noirix.controller.dto.movie.MovieCreateRequest;
import com.noirix.entity.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovieCreateConverter implements Converter<MovieCreateRequest, Movie> {

    @Override
    public Movie convert(MovieCreateRequest source) {
        Movie movie = new Movie();

        movie.setDescription(source.getDescription());
        movie.setGenre(source.getGenre());
        movie.setAgeRestrictions(source.getAgeRestrictions());
        movie.setTitle(source.getTitle());
        return movie;

    }

}
