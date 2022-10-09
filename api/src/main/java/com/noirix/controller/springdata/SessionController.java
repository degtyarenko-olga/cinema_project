package com.noirix.controller.springdata;

import com.noirix.repository.springdata.SessionSpringDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/data/session")
public class SessionController {

    private final SessionSpringDataRepository repository;

    @GetMapping()
    public ResponseEntity<Object> findAllSession(){
        return new ResponseEntity<>(
                Collections.singletonMap("session",repository.findAllSession()),
                HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Object> findAllSessionByH(){
        return new ResponseEntity<>(
                Collections.singletonMap("session",repository.findByHQLQueryNative()),
                HttpStatus.OK);
    }
}
