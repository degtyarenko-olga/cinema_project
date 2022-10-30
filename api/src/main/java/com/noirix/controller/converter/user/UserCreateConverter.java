package com.noirix.controller.converter.user;

import com.noirix.controller.dto.user.UserCreateRequest;
import com.noirix.entity.Credentials;
import com.noirix.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class UserCreateConverter extends UserBaseConverter<UserCreateRequest, User> {
    private final PasswordEncoder passwordEncoder;

    @Override
    public User convert(UserCreateRequest source) {
        User user = new User();

        Credentials credentials = new Credentials();
        credentials.setLogin(source.getLogin());
        credentials.setPassword(passwordEncoder.encode(source.getPassword()));

        user.setCredentials(credentials);

        user.setCreationDate(new Timestamp(new Date().getTime()));
        return doConvert(user, source);

    }

}
