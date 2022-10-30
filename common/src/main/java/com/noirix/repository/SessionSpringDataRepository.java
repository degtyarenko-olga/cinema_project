package com.noirix.repository;

import com.noirix.entity.Session;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionSpringDataRepository extends JpaRepository<Session, Long> {

    @Cacheable("session")
    @Query(value = "select s from Session s")
    List<Session> findAllSession();

    @Query(value = "select * from cinema.session", nativeQuery = true)
    List<Session> findByHQLQueryNative();
}
