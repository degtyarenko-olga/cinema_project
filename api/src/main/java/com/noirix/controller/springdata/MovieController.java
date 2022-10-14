package com.noirix.controller.springdata;

import com.noirix.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/data/movie")
public class MovieController {

    private final MovieService service;

    @GetMapping
    public ResponseEntity<Object> findAllMovies() {

        return new ResponseEntity<>(
                Collections.singletonMap("movie", service.findAll()),
                HttpStatus.OK
        );
    }
    @GetMapping("/{title}")
    public ResponseEntity<Object> findMoviesByTitle(@PathVariable String title){

        return new ResponseEntity<>(Collections.singletonMap("result",
                service.findMovieHibernatesByTitle(title)), HttpStatus.OK);

    }

    @GetMapping("/{genre}")
    public ResponseEntity<Object> findMovieHibernatesByGenre(@PathVariable String genre){

        return new ResponseEntity<>(Collections.singletonMap("movie:",
                service.findAllByGenre(genre)),HttpStatus.OK);

    }
}
