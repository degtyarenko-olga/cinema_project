package com.noirix.repository;

import com.noirix.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserSpringDataRepository extends JpaRepository<User, Long> {

    List<User> findAll();

    Optional<User> findByLogin(String login);


}
