package com.noirix.controller;

import com.noirix.service.HallService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/data/hall")
public class HallController {

     private final HallService service;

    @GetMapping
    public ResponseEntity<Object> findAllHall() {

        return new ResponseEntity<>(
                Collections.singletonMap("hall", service.findAllHall()),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findHallById(@PathVariable("id") Long id) {

        return new ResponseEntity<>(Collections.singletonMap("hall", service.findById(id)),
                HttpStatus.OK
        );
    }

}
