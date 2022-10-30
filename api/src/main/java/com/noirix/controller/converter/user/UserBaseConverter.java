package com.noirix.controller.converter.user;

import com.noirix.controller.dto.user.UserCreateRequest;
import com.noirix.entity.User;
import org.springframework.core.convert.converter.Converter;

import java.sql.Timestamp;
import java.util.Date;

public abstract class UserBaseConverter<S, T> implements Converter<S, T> {

    public User doConvert(User userForUpdate, UserCreateRequest request) {

        userForUpdate.setBirth(request.getBirth());
        userForUpdate.setEmail(request.getEmail());
        userForUpdate.setIsDeleted(false);

        userForUpdate.setModificationDate(new Timestamp(new Date().getTime()));
        return userForUpdate;

    }

}
