package com.noirix.service;

import com.noirix.entity.User;

import java.util.List;

public interface UserService {
    User findById(Long id);

    List<User> findAll();

    void delete(Long id);

    User findByLogin(String login);

    User create(User user);

    User update(User user);

}
