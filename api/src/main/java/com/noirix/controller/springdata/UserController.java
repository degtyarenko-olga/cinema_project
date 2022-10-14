package com.noirix.controller.springdata;

import com.noirix.repository.springdata.UserSpringDataRepository;

import com.noirix.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/data/users")
public class UserController {

    private final UserService service;

    @GetMapping
    public ResponseEntity<Object> testEndpoint() {

        return new ResponseEntity<>(Collections.singletonMap("result",
                service.findAll(PageRequest.of(0, 10))), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Object> findAllUsers(){

        return new ResponseEntity<>(Collections.singletonMap("result",
                service.findByHQLQuery()),HttpStatus.OK);
    }

    @GetMapping("/test/{login}")
    public ResponseEntity<Object> testEndpointSearchQuery(@PathVariable String login) {

        return new ResponseEntity<>(Collections.singletonMap("result",
                service.findUsersHibernateByCredentials_Login(login)), HttpStatus.OK);
    }

//    @GetMapping("/{id}")
//    public String show(@PathVariable("id") Long id, Model model) {
//        model.addAttribute("user", service.findOne(id));
//        return "user/show";
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findUserById(@PathVariable Long id) {

        return new ResponseEntity<>(
                Collections.singletonMap("user", service.findOne(id)),
                HttpStatus.OK
        );
    }
}
