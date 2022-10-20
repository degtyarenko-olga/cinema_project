package com.noirix.service;

import com.noirix.domain.UsersHibernate;
import com.noirix.repository.UserSpringDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserSpringDataRepository repository;

    private final BCryptPasswordEncoder passwordEncoder;


    public List<UsersHibernate> findAll() {
        return repository.findAll();
    }

    public Optional<UsersHibernate> findOne(Long id){
        return repository.findById(id);
    }

    public Object findAll(PageRequest of) {
        return repository.findAll(of);
    }

    public Object findByHQLQuery() {
        return repository.findByHQLQuery();
    }

    public Object findUsersHibernateByCredentials_Login(String login) {
        return repository.findByCredentialsLogin(login);
    }

    public UsersHibernate save(UsersHibernate user) {
        return repository.save(user);
    }
}
