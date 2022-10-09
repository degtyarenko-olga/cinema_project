package com.noirix.controller.springdata;

import com.noirix.repository.springdata.MovieSpringDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/data/movie")
public class MovieController {

    private final MovieSpringDataRepository repository;

    @GetMapping
    public ResponseEntity<Object> findAllMovies() {

        return new ResponseEntity<>(
                Collections.singletonMap("movie", repository.findAllMovie()),
                HttpStatus.OK
        );
    }
}