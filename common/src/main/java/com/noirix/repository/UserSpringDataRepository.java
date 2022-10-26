package com.noirix.repository;

import com.noirix.domain.UsersHibernate;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserSpringDataRepository extends JpaRepository<UsersHibernate, Long> {

    @Query(value = "select u from UsersHibernate u")
    List<UsersHibernate> findByHQLQuery();

    List<UsersHibernate> findAll();

    Optional<UsersHibernate> findByCredentialsLogin(String login);

    Optional<UsersHibernate> findUsersHibernateByCredentialsLogin(String login);


}
