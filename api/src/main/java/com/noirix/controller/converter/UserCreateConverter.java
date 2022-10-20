package com.noirix.controller.converter;

import com.noirix.controller.requests.user.UserCreateRequest;
import com.noirix.domain.UsersHibernate;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

@Component
public class UserCreateConverter extends UserBaseConverter<UserCreateRequest, UsersHibernate> {

    @Override
    public UsersHibernate convert(UserCreateRequest source) {

        UsersHibernate usersHibernate = new UsersHibernate();

        usersHibernate.setCreationDate(new Timestamp(new Date().getTime()));

        return doConvert(usersHibernate, source);
    }
}
