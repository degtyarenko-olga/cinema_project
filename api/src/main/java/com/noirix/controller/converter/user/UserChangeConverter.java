package com.noirix.controller.converter.user;

import com.noirix.controller.dto.user.UserChangeRequest;
import com.noirix.entity.User;
import com.noirix.service.UserService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class UserChangeConverter implements Converter<UserChangeRequest, User> {
    private final UserService service;
    private final PasswordEncoder passwordEncoder;

    public UserChangeConverter(UserService service, PasswordEncoder passwordEncoder) {
        this.service = service;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User convert(UserChangeRequest source) {
        User user = service.findById(source.getId());

        user.setBirth(source.getBirth());
        user.setEmail(source.getEmail());
        user.setLogin(source.getLogin());
        user.setPassword(passwordEncoder.encode(source.getPassword()));

        return user;
    }

}
