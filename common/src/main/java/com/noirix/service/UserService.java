package com.noirix.service;

import com.noirix.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    User findById(Long id);

    List<User> findByHQLQuery();

    Long delete(Long id);

    User findByCredentialsLogin(String login);

    @Transactional
    User create(User user);

    @Transactional
    User update(User user);
}
