package com.noirix.controller.springdata;

import com.noirix.repository.springdata.PlaceSpringDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/data/place")
public class PlaceController {

    private final PlaceSpringDataRepository repository;

    @GetMapping("/all")
    public ResponseEntity<Object> findAllPlace(){
        return new ResponseEntity<>(Collections.singletonMap("result",repository.findAllBy()), HttpStatus.OK);
    }
}
