package com.noirix.service;

import com.noirix.domain.RolesHibernate;
import com.noirix.domain.SystemRoles;
import com.noirix.domain.UsersHibernate;
import com.noirix.exception.UserNotFoundException;
import com.noirix.repository.RolesSpringDataRepository;
import com.noirix.repository.UserSpringDataRepository;
import com.noirix.service.request.UserUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserSpringDataRepository repository;

    private final RolesSpringDataRepository dataRepository;


    public List<UsersHibernate> findAll() {
        return repository.findAll();
    }

    public UsersHibernate findById(Long id) {
        if (repository.existsById(id)) {
            return repository.findUsersHibernateByIdAndAndIsDeletedFalse(id);
        } else {
            throw new UserNotFoundException(id);
        }
    }

    public Object findAll(PageRequest of) {
        return repository.findAll(of);
    }

    public Object findByHQLQuery() {
        return repository.findByHQLQuery();
    }


    public UsersHibernate save(UsersHibernate user) {
        return repository.save(user);
    }

    public Long delete(Long id) {
        repository.deleteById(id);
        return id;
    }

    public Object findByCredentialsLogin(String login) {
        return repository.findByCredentialsLogin(login);
    }


    public Object create(UsersHibernate user) {

        RolesHibernate roleUser = dataRepository.findRolesHibernateByRoleName(SystemRoles.ROLE_USER);

        user.setRoles(Set.of(roleUser));
        roleUser.getUsers().add(user);

        UsersHibernate usersHibernate = repository.save(user);
        return usersHibernate;
    }


}
