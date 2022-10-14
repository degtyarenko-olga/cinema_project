package com.noirix.controller.converter;

import com.noirix.controller.requests.UserCreateRequest;
import com.noirix.domain.Credentials;
import com.noirix.domain.UsersHibernate;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

@Component
public class UserCreateConverter extends UserBaseConverter<UserCreateRequest, UsersHibernate> {

    @Override
    public UsersHibernate convert(UserCreateRequest source) {

        UsersHibernate usersHibernate = new UsersHibernate();

        usersHibernate.setCreationDate(new Timestamp(new Date().getTime()));

        Credentials credentials = new Credentials(
                RandomStringUtils.randomAlphabetic(10),
                RandomStringUtils.randomAlphabetic(10)
        );

        usersHibernate.setCredentials(credentials);

        return doConvert(usersHibernate, source);
    }
}
