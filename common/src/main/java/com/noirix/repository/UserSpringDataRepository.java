package com.noirix.repository;

import com.noirix.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserSpringDataRepository extends JpaRepository<User, Long> {

    @Query(value = "select u from User u")
    List<User> findByHQLQuery();

    List<User> findAll();

    Optional<User> findByCredentialsLogin(String login);

    Optional<User> findUsersHibernateByCredentialsLogin(String login);


}
