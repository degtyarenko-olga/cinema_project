package com.noirix.controller;

import com.noirix.service.SessionService;
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
@RequestMapping("/rest/data/session")
public class SessionController {

    private final SessionService service;

    @GetMapping()
    public ResponseEntity<Object> findAllSession(){
        return new ResponseEntity<>(
                Collections.singletonMap("session",service.findAllSession()),
                HttpStatus.OK);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Object> findSessionById(@PathVariable String id) {
//        long sessionId = Long.parseLong(id);
//        return new ResponseEntity<>(
//                Collections.singletonMap("user", service.findById(sessionId)),
//                HttpStatus.OK
//        );
//    }


}
