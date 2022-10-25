package com.noirix.controller.converter.user;

import com.noirix.controller.requests.user.UserChangeRequest;
import com.noirix.domain.UsersHibernate;
import com.noirix.repository.UserSpringDataRepository;
import com.noirix.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
@RequiredArgsConstructor
public class UserChangeConverter extends UserBaseConverter<UserChangeRequest, UsersHibernate> {

    private final UserService service;

    @Override
    public UsersHibernate convert(UserChangeRequest source) {

        UsersHibernate user = service.findById(source.getId());

        return doConvert(user, source);

    }
}