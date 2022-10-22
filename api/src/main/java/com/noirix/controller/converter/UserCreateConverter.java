package com.noirix.controller.converter;

import com.noirix.controller.requests.user.UserCreateRequest;
import com.noirix.domain.Credentials;
import com.noirix.domain.UsersHibernate;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class UserCreateConverter extends UserBaseConverter<UserCreateRequest, UsersHibernate> {

    private final PasswordEncoder passwordEncoder;


    @Override
    public UsersHibernate convert(UserCreateRequest source) {

        UsersHibernate usersHibernate = new UsersHibernate();

        Credentials credentials = new Credentials();
        credentials.setLogin(source.getLogin());
       // credentials.setPassword(passwordEncoder.encode(source.getPassword()));
        credentials.setPassword(source.getPassword());

        usersHibernate.setCredentials(credentials);

        usersHibernate.setCreationDate(new Timestamp(new Date().getTime()));

        return doConvert(usersHibernate, source);
    }
}
