package com.noirix.controller.converter;

import com.noirix.controller.requests.user.UserCreateRequest;
import com.noirix.domain.Credentials;
import com.noirix.domain.UsersHibernate;
import org.springframework.core.convert.converter.Converter;

import java.sql.Timestamp;
import java.util.Date;

public abstract class UserBaseConverter<S, T> implements Converter<S, T> {

    public UsersHibernate doConvert(UsersHibernate userForUpdate, UserCreateRequest request) {

        userForUpdate.setBirth(request.getBirth());
        userForUpdate.setEmail(request.getEmail());
        userForUpdate.setIsDeleted(false);

        userForUpdate.setModificationDate(new Timestamp(new Date().getTime()));


        return userForUpdate;
    }

}