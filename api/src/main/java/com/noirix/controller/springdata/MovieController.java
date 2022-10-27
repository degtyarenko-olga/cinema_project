package com.noirix.controller.springdata;

import com.noirix.controller.requests.movie.MovieChangeRequest;
import com.noirix.controller.requests.movie.MovieCreateRequest;
import com.noirix.controller.requests.place.PlaceCreateRequest;
import com.noirix.domain.MovieHibernate;
import com.noirix.domain.PlaceHibernate;
import com.noirix.service.MovieService;
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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/movie")
public class MovieController {

    private final MovieService service;

    private final ConversionService converter;


    @Operation(summary = "Gets all movies")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found movies", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = MovieHibernate.class)))
                    })
    })
    @GetMapping
    public ResponseEntity<Object> findAllMovies() {

        return new ResponseEntity<>(
                Collections.singletonMap("movie", service.findAll()),
                HttpStatus.OK
        );
    }


    @Operation(summary = "Gets movie by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found movie", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = MovieHibernate.class)))
                    })
    })
    @GetMapping("/find/{id}")
    public ResponseEntity<Object> findMovieById(@Valid @PathVariable("id") Long id){

        return new ResponseEntity<>(Collections.singletonMap("result",
                service.findById(id)), HttpStatus.OK);

    }

    @Operation(summary = "Gets movie by TITLE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found movie", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = MovieHibernate.class)))
                    })
    })
    @GetMapping("/title/{title}")
    public ResponseEntity<Object> findMoviesByTitle(@PathVariable("title")String title){

        return new ResponseEntity<>(Collections.singletonMap("result",
                service.findMovieHibernatesByTitle(title)), HttpStatus.OK);

    }


    @Operation(summary = "Gets movie by GENRE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found movie", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = MovieHibernate.class)))
                    })
    })
    @GetMapping("/genre/{genre}")
    public ResponseEntity<Object> findMoviesByGenre(@PathVariable("genre") String genre){

        return new ResponseEntity<>(Collections.singletonMap("movie:",
                service.findAllByGenre(genre)),HttpStatus.OK);

    }


    @Operation(summary = "Create new movie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Movie created", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = MovieCreateRequest.class)))
                    })
    })
    @Transactional
    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody MovieCreateRequest createRequest) {

        MovieHibernate movie = converter.convert(createRequest, MovieHibernate.class);

        service.create(movie);

        return new ResponseEntity<>(
                Collections.singletonMap("movie", service.findById(movie.getId())),
                HttpStatus.CREATED);
    }

    @Transactional
    @PutMapping
    public ResponseEntity<Object> update(@Valid @RequestBody MovieChangeRequest createRequest) {

        MovieHibernate movie = converter.convert(createRequest, MovieHibernate.class);

        service.update(movie);

        return new ResponseEntity<>(
                Collections.singletonMap("movie", service.findById(movie.getId())),
                HttpStatus.CREATED);
    }


    @Operation(summary = "Delete movie by ID",
            responses = {@ApiResponse(responseCode = "200", description = "Movie deleted",
                    content = @Content)
            })
    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteMovieById(@PathVariable Long id) {

        service.delete(id);

        Map<String, Object> model = new HashMap<>();
        model.put("id", id);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }
}
