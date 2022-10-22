package com.noirix.controller.converter;

import com.noirix.controller.requests.user.UserChangeRequest;
import com.noirix.domain.UsersHibernate;
import com.noirix.repository.UserSpringDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
@RequiredArgsConstructor
public class UserChangeConverter extends UserBaseConverter<UserChangeRequest, UsersHibernate> {

    private final UserSpringDataRepository service;

    @Override
    public UsersHibernate convert(UserChangeRequest source) {

        Optional<UsersHibernate> user = service.findById(source.getId());

        return doConvert(user.get(), source);

    }
}