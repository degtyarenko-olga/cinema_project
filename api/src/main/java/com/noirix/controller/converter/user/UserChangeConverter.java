package com.noirix.controller.converter.user;

import com.noirix.controller.dto.user.UserChangeRequest;
import com.noirix.entity.User;
import com.noirix.service.UserService;
import com.noirix.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class UserChangeConverter extends UserBaseConverter<UserChangeRequest, User> {
    private final UserService service;

    @Override
    public User convert(UserChangeRequest source) {
        User user = service.findById(source.getId());
        return doConvert(user, source);

    }

}
