package com.noirix.controller.converter;

import com.fasterxml.jackson.databind.util.Converter;
import com.noirix.controller.requests.UserChangeRequest;
import com.noirix.controller.requests.UserCreateRequest;
import com.noirix.domain.Credentials;
import com.noirix.domain.UsersHibernate;
import com.noirix.repository.springdata.UserSpringDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserChangeConverter extends UserBaseConverter<UserChangeRequest, UsersHibernate> {

    private final UserSpringDataRepository repository;

    @Override
    public UsersHibernate convert(UserChangeRequest source) {

        Optional<UsersHibernate> user = repository.findById(source.getId());
        return doConvert(user.get(), source);
    }
}