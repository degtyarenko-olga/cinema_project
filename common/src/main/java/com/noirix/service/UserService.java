package com.noirix.service;

import com.noirix.domain.RolesHibernate;
import com.noirix.domain.SystemRoles;
import com.noirix.domain.UsersHibernate;
import com.noirix.exception.UserNotFoundException;
import com.noirix.repository.RolesSpringDataRepository;
import com.noirix.repository.UserSpringDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserSpringDataRepository repository;

    private final RolesSpringDataRepository dataRepository;


    public List<UsersHibernate> findAll() {
        return repository.findAll();
    }


    public UsersHibernate findById(Long id) {
       return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Object findAll(PageRequest of) {
        return repository.findAll(of);
    }

    public Object findByHQLQuery() {
        return repository.findByHQLQuery();
    }

    public Object findByHQLQueryId(Long id){
        return repository.findUsersHibernateById(id);
    }

    @Transactional
    public UsersHibernate save(UsersHibernate user) {
        return repository.save(user);
    }

    @Transactional
    public Long delete(Long id) {
        repository.deleteById(id);
        return id;
    }

    public Object findByCredentialsLogin(String login) {
       // return repository.findByCredentialsLogin(login);
        return repository.findUsersHibernateByCredentialsLogin(login).orElseThrow(EntityNotFoundException::new);
    }

    @Transactional
    public Object create(UsersHibernate user) {

        RolesHibernate roleUser = dataRepository.findRolesHibernateByRoleName(SystemRoles.ROLE_USER);

        user.setRoles(Set.of(roleUser));
        roleUser.getUsers().add(user);

        UsersHibernate usersHibernate = repository.save(user);
        return usersHibernate;
    }


}
