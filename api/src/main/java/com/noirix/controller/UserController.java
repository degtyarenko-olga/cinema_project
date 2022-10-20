package com.noirix.controller;


import com.noirix.controller.requests.user.UserCreateRequest;
import com.noirix.domain.Credentials;
import com.noirix.domain.RolesHibernate;
import com.noirix.domain.UsersHibernate;
import com.noirix.repository.UserSpringDataRepository;
import com.noirix.service.RolesService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/data/users")
public class UserController {

    private final UserSpringDataRepository service;

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


    @PostMapping
    @Transactional
    public ResponseEntity<Object> createUser(@Valid  @RequestBody UserCreateRequest createRequest) {

        UsersHibernate user = converter.convert(createRequest, UsersHibernate.class);
        UsersHibernate usersHibernate = service.save(setRoles(user));
        Map<String, Object> model = new HashMap<>();
        model.put("user", service.findById(usersHibernate.getId()).get());

        return new ResponseEntity<>(model, HttpStatus.CREATED);
    }

//    @PostMapping
//    @Transactional
//    @ResponseStatus(HttpStatus.CREATED)
//    public UsersHibernate savingUser(@RequestBody UserCreateRequest userCreateRequest) {
//        //converters
//        UsersHibernate user = new UsersHibernate();
//        user.setCredentials(
//                new Credentials(userCreateRequest.getLogin(), userCreateRequest.getPassword()));
//        user.setEmail(userCreateRequest.getEmail());
//        user.setBirth(userCreateRequest.getBirth());
//        user.setIsDeleted(false);
//        user.setCreationDate(new Timestamp(new Date().getTime()));
//        user.setModificationDate(new Timestamp(new Date().getTime()));
//
//        return service.save(user);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findUserById(@PathVariable Long id) {

        return new ResponseEntity<>(
                Collections.singletonMap("user", service.findById(id)),
                HttpStatus.OK
        );
    }

    private UsersHibernate setRoles(UsersHibernate user) {
        Set<RolesHibernate> roles = user.getRoles();

        Set<RolesHibernate> updatedRoles = new HashSet<>();

        if (!CollectionUtils.isEmpty(roles)) {
            updatedRoles.addAll(roles);
        }
       // updatedRoles.add(rolesService.findOne(21).get());
       updatedRoles.add(rolesService.findOne(2L).get());
        user.setRoles(updatedRoles);

        return user;
    }
}
