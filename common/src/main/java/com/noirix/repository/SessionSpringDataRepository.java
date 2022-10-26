package com.noirix.repository;

import com.noirix.domain.SessionHibernate;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SessionSpringDataRepository extends JpaRepository<SessionHibernate,Long> {

    @Cacheable("session")
    @Query(value = "select s from SessionHibernate s")
    List<SessionHibernate> findAllSession();

        @Query(value = "select * from cinema.session", nativeQuery = true)
    List<SessionHibernate> findByHQLQueryNative();
}
