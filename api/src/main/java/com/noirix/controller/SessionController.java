package com.noirix.controller;

import com.noirix.controller.requests.movie.MovieCreateRequest;
import com.noirix.controller.requests.session.SessionCreateRequest;
import com.noirix.domain.MovieHibernate;
import com.noirix.domain.SessionHibernate;
import com.noirix.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/data/session")
public class SessionController {

    private final SessionService service;

    private final ConversionService converter;

    @GetMapping()
    public ResponseEntity<Object> findAllSession(){
        return new ResponseEntity<>(
                Collections.singletonMap("session",service.findAllSession()),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findSessionById(@PathVariable String id) {
        long sessionId = Long.parseLong(id);
        return new ResponseEntity<>(
                Collections.singletonMap("session", service.findById(sessionId)),
                HttpStatus.OK
        );
    }

    @Transactional
    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody SessionCreateRequest createRequest) {

        SessionHibernate session = converter.convert(createRequest, SessionHibernate.class);

        service.create(session);

        return new ResponseEntity<>(
                Collections.singletonMap("session", service.findById(session.getId())),
                HttpStatus.CREATED);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteSessionById(@PathVariable Long id) {

        service.delete(id);

        Map<String, Object> model = new HashMap<>();
        model.put("id", id);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }



}
