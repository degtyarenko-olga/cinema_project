package com.noirix.controller.springdata;

import com.noirix.repository.springdata.UserSpringDataRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/data/users")
public class UserController {

    private final UserSpringDataRepository repository;

    //private final RoleRepositoryInterface roleRepository;

    @GetMapping
    public ResponseEntity<Object> testEndpoint() {

        return new ResponseEntity<>(Collections.singletonMap("result",
                repository.findAll(PageRequest.of(0, 10))), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Object> findAllUsers(){
        return new ResponseEntity<>(Collections.singletonMap("result",repository.findByHQLQuery()),HttpStatus.OK);
    }

    @GetMapping("/test/{login}")
    public ResponseEntity<Object> testEndpointSearchQuery(@PathVariable String login) {
        return new ResponseEntity<>(Collections.singletonMap("result",
                repository.findUsersHibernateByCredentials_Login(login)), HttpStatus.OK);
    }
}
