package com.noirix.repository.springdata;

import com.noirix.domain.SessionHibernate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SessionSpringDataRepository extends JpaRepository<SessionHibernate,Long> {

    @Query(value = "select s from SessionHibernate s")
    List<SessionHibernate> findAllSession();

        @Query(value = "select * from cinema.session", nativeQuery = true)
    List<SessionHibernate> findByHQLQueryNative();
}
