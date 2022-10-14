package com.noirix.service;

import com.noirix.domain.UsersHibernate;
import com.noirix.repository.springdata.UserSpringDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserSpringDataRepository repository;


    public List<UsersHibernate> findAll() {
        return repository.findAll();
    }

    public UsersHibernate findOne(Long id){
        Optional<UsersHibernate> foundUser = repository.findById(id);
        return foundUser.orElse(null);
    }

    public Object findAll(PageRequest of) {
        return repository.findAll(of);
    }

    public Object findByHQLQuery() {
        return repository.findByHQLQuery();
    }

    public Object findUsersHibernateByCredentials_Login(String login) {
        return repository.findUsersHibernateByCredentials_Login(login);
    }
}
