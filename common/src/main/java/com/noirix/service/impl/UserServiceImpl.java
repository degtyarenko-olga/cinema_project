package com.noirix.service.impl;

import com.noirix.entity.Roles;
import com.noirix.entity.SystemRoles;
import com.noirix.entity.User;
import com.noirix.repository.RolesSpringDataRepository;
import com.noirix.repository.UserSpringDataRepository;
import com.noirix.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
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
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);

    }

    @Override
    public List<User> findAll() {
        return repository.findAll();

    }

    @Override
    public Long delete(Long id) {
        repository.deleteById(id);
        return id;

    }

    @Override
    public User findByLogin(String login) {
        return repository.findByLogin(login).orElseThrow(EntityNotFoundException::new);

    }

    @Override
    @Transactional
    public User create(User user) {
        Roles roleUser = dataRepository.findRolesHibernateByRoleName(SystemRoles.ROLE_USER);

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
