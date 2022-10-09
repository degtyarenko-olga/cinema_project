package com.noirix.controller.springdata;

import com.noirix.repository.springdata.HallSpringDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/data/hall")
public class HallController {

     private final HallSpringDataRepository repository;

    @GetMapping
    public ResponseEntity<Object> findAllHall() {

        return new ResponseEntity<>(
                Collections.singletonMap("hall", repository.findAllHall()),
                HttpStatus.OK
        );
    }
}
