package com.noirix.controller;

import com.noirix.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/data/place")
public class PlaceController {

    private final PlaceService service;

    private final ConversionService converter;

    @GetMapping("/all")
    public ResponseEntity<Object> findAllPlace(){
        return new ResponseEntity<>(Collections.singletonMap("result",service.findAllBy()), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Object> findPlaceById(@Valid @PathVariable("id") Long id){

        return new ResponseEntity<>(Collections.singletonMap("result",
                service.findById(id)), HttpStatus.OK);

    }

    @GetMapping("/{row}")
    public ResponseEntity<Object> findPlaceByPlaceNumber(@PathVariable("row")int row){

        return new ResponseEntity<>(Collections.singletonMap("result",

                service.findAllPlaceByRow(row)), HttpStatus.OK);
    }

}
