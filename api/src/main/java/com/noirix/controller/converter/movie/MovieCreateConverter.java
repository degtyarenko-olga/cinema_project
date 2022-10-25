package com.noirix.controller.converter.movie;

import com.noirix.controller.requests.movie.MovieChangeRequest;
import com.noirix.controller.requests.movie.MovieCreateRequest;
import com.noirix.domain.MovieHibernate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;

@Component
@RequiredArgsConstructor
public class MovieCreateConverter implements Converter<MovieCreateRequest, MovieHibernate> {

    @Override
    public MovieHibernate convert(MovieCreateRequest source) {

        MovieHibernate movie = new MovieHibernate();

        movie.setDescription(source.getDescription());
        movie.setGenre(source.getGenre());
        movie.setAgeRestrictions(source.getAgeRestrictions());
        movie.setTitle(source.getTitle());
        movie.setAvailable(true);

        return movie;
    }
}
