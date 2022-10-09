package com.noirix.controller;

import com.noirix.exception.NoSuchEntityException;
import com.noirix.repository.hibernate.HibernateUserInterface;
import com.noirix.util.UUIDGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/users")
public class UserRestController {

  private  final HibernateUserInterface userRepository;

  @GetMapping
  @RequestMapping("/hibernate")
  //@ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Object> findAllHibernateUsers() {

    return new ResponseEntity<>(Collections.singletonMap("res", userRepository.findAll()),HttpStatus.OK);
      }

  @GetMapping
  @Secured("ROLE_ADMIN")
  //@ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Object> findAllUsers() {

    return new ResponseEntity<>(Collections.singletonMap("result", userRepository.findAll()), HttpStatus.OK);

    //return Collections.singletonMap("result", userService.findAll());
  }

//  @GetMapping("/search")
//  public ResponseEntity<Object> findAllUsersWithParams(@ModelAttribute UserSearchRequest userSearchRequest) {
//
//    int verifiedLimit = Integer.parseInt(userSearchRequest.getLimit());
//    int verifiedOffset = Integer.parseInt(userSearchRequest.getOffset());
//
//    List<User> users = userRepository.search(verifiedLimit, verifiedOffset);
//
//    Map<String, Object> model = new HashMap<>();
//    model.put("user", "Slava");
//    model.put("users", users);
//
//    return new ResponseEntity<>(model, HttpStatus.OK);
//  }

  @GetMapping("/{id}")
  public ResponseEntity<Map<String, Object>> findUserById(@PathVariable String id) {

    //We have added id parsing and number format checking
    long userId = Long.parseLong(id);

    return new ResponseEntity<>(Collections.singletonMap("user", userRepository.findById(userId)), HttpStatus.OK);
  }
  @GetMapping("/hibernate/{id}")
  public ResponseEntity<Map<String,Object>> findHibernateById(@PathVariable String id){
    long userId = Long.parseLong(id);
    if(userRepository.findById(userId) == null){
      throw new NoSuchEntityException("Entity User with id " + id + " does not exist", 404, UUIDGenerator.generateUUID());
    }
    return new ResponseEntity<>(Collections.singletonMap("user", userRepository.findById(userId)), HttpStatus.OK);
  }

//  @PostMapping
//  public ResponseEntity<Object> createUser(@RequestBody UserCreateRequest createRequest) {
//
//    User user = new User();
//    user.setLogin(createRequest.getUserName());
//    user.setPassword(createRequest.getPassword());
//    user.setBirth(new Timestamp(new Date().getTime()));
//    user.setCreationDate(new Timestamp(new Date().getTime()));
//    user.setModificationDate(new Timestamp(new Date().getTime()));
//    user.setEmail(createRequest.getEmail());
//    user.setIsDeleted(false);
//
//    userService.create(user);
//
//    List<User> users = userService.findAll();
//
//    Map<String, Object> model = new HashMap<>();
//    model.put("user", user.getLogin());
//    model.put("users", users);
//
//    return new ResponseEntity<>(model, HttpStatus.CREATED);
//  }

//  @DeleteMapping("/delete/{id}")
//  public ResponseEntity<Map<String, Object>> deleteUserById(@PathVariable String id) {
//
//    long userId = Long.parseLong(id);
//    if(userRepository.findById(userId) == null){
//      throw new NoSuchEntityException("Entity User with id " + id + " does not exist", 404,generateUUID());
//    }
//
//    return new ResponseEntity<>(Collections.singletonMap("user", userService.hardDelete(userId)), HttpStatus.OK);
//
//  }


}
