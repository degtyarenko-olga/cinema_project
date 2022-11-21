package com.noirix.controller.converter.user;

import com.noirix.controller.dto.user.UserCreateRequest;
import com.noirix.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class UserCreateConverter implements Converter<UserCreateRequest, User> {
    private final PasswordEncoder passwordEncoder;

    @Override
    public User convert(UserCreateRequest source) {
        User user = new User();
        user.setBirth(source.getBirth());
        user.setEmail(source.getEmail());
        user.setLogin(source.getLogin());
        user.setPassword(passwordEncoder.encode(source.getPassword()));
        user.setCreationDate(new Timestamp(new Date().getTime()));
        user.setModificationDate(new Timestamp(new Date().getTime()));
        return user;
    }

}
