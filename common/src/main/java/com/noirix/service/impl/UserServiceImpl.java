package com.noirix.service.impl;

import com.noirix.entity.Roles;
import com.noirix.entity.SystemRoles;
import com.noirix.entity.User;
import com.noirix.repository.RolesSpringDataRepository;
import com.noirix.repository.UserSpringDataRepository;
import com.noirix.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserSpringDataRepository repository;
    private final RolesSpringDataRepository dataRepository;

    @Override
    public User findById(Long id) {
        return repository.findById(id).orElse(new User());
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public User findByLogin(String login) {
        return repository.findByLogin(login).orElse(new User());
    }

    @Override
    @Transactional
    public User create(User user) {
        Roles roleUser = dataRepository.findRolesByRoleName(SystemRoles.ROLE_USER).orElse(new Roles());
        user.setRoles(Set.of(roleUser));
        roleUser.getUsers().add(user);
        return repository.save(user);
    }

    @Override
    @Transactional
    public User update(User user) {
        return repository.save(user);
    }

}
