package com.noirix.controller.converter;

import com.noirix.controller.requests.UserCreateRequest;
import com.noirix.domain.UsersHibernate;
import org.springframework.core.convert.converter.Converter;

import java.sql.Timestamp;
import java.util.Date;

public abstract class UserBaseConverter<S, T> implements Converter<S, T> {

    public UsersHibernate doConvert(UsersHibernate userForUpdate, UserCreateRequest request) {

        userForUpdate.setBirth(request.getBirth());

        /*System fields filling*/
        userForUpdate.setModificationDate(new Timestamp(new Date().getTime()));
        userForUpdate.setIsDeleted(false);

        return userForUpdate;
    }

}