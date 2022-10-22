package com.noirix.controller;


import com.noirix.controller.requests.user.UserCreateRequest;
import com.noirix.domain.RolesHibernate;
import com.noirix.domain.UsersHibernate;
import com.noirix.repository.UserSpringDataRepository;
import com.noirix.service.RolesService;
import com.noirix.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/data/users")
public class UserController {

    private final UserService service;

    private final RolesService rolesService;

    private final ConversionService converter;

    @GetMapping
    public ResponseEntity<Object> testEndpoint() {

        return new ResponseEntity<>(Collections.singletonMap("result",
                service.findAll(PageRequest.of(0, 10))), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Object> findAllUsers() {

        return new ResponseEntity<>(Collections.singletonMap("result",
                service.findByHQLQuery()), HttpStatus.OK);
    }

    @GetMapping("/test/{login}")
    public ResponseEntity<Object> testEndpointSearchQuery(@PathVariable String login) {

        return new ResponseEntity<>(Collections.singletonMap("result",
                service.findByCredentialsLogin(login)), HttpStatus.OK);
    }


    @Transactional
    @PostMapping
    public ResponseEntity<Object> create(@Valid  @RequestBody UserCreateRequest createRequest) {

        UsersHibernate user = converter.convert(createRequest, UsersHibernate.class);

       service.create(user);

        return new ResponseEntity<>(
                Collections.singletonMap("USER", service.findById(user.getId())),
                HttpStatus.OK
        );
    }
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Map<String, Object>> deleteUsersById(@PathVariable String id) {
//
//        long userId = Long.parseLong(id);
//
//    return new ResponseEntity<>(service.deleteById(userId),HttpStatus.OK);
//    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> findUserById(@PathVariable Long id) {

        return new ResponseEntity<>(
                Collections.singletonMap("user", service.findById(id)),
                HttpStatus.OK
        );
    }

}
