package com.noirix.controller.springdata;

import com.noirix.controller.dto.movie.MovieChangeRequest;
import com.noirix.entity.Movie;
import com.noirix.service.impl.MovieServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/movie")
public class MovieController {
    private final MovieServiceImpl service;
    private final ConversionService converter;

    @Operation(summary = "Gets all movies")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found movies", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = Movie.class)))
                    })
    })
    @GetMapping
    public ResponseEntity<Object> findAllMovies() {

        return new ResponseEntity<>(
                Collections.singletonMap("movie", service.findAll()),
                HttpStatus.OK);

    }

    @Operation(summary = "Gets movie by TITLE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found movie", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = Movie.class)))
                    })
    })
    @GetMapping("/title/{title}")
    public ResponseEntity<Object> findMoviesByTitle(@PathVariable("title") String title) {
        return new ResponseEntity<>(Collections.singletonMap("result",
                service.findMovieHibernatesByTitle(title)), HttpStatus.OK);

    }

    @Operation(summary = "Gets movie by GENRE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found movie", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = Movie.class)))
                    })
    })
    @GetMapping("/genre/{genre}")
    public ResponseEntity<Object> findMoviesByGenre(@PathVariable("genre") String genre) {
        return new ResponseEntity<>(Collections.singletonMap("movie:",
                service.findAllByGenre(genre)), HttpStatus.OK);

    }

    @Transactional
    @PutMapping
    public ResponseEntity<Object> update(@Valid @RequestBody MovieChangeRequest createRequest) {
        Movie movie = converter.convert(createRequest, Movie.class);
        service.update(movie);

        return new ResponseEntity<>(
                Collections.singletonMap("movie", service.findById(movie.getId())),
                HttpStatus.CREATED);

    }

}
