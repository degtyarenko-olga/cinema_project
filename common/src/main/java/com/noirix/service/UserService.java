package com.noirix.service;

import com.noirix.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    User findById(Long id);

    List<User> findAll();

    Long delete(Long id);

    User findByLogin(String login);

    User create(User user);

    User update(User user);
}
