package com.noirix.repository.springdata;

import com.noirix.domain.hibernate.RolesHibernate;
import com.noirix.domain.hibernate.SessionHibernate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SessionSpringDataRepository extends JpaRepository<SessionHibernate,Long> {

    @Query(value = "select s from SessionHibernate s")
    List<SessionHibernate> findAllSession();

        @Query(value = "select * from cinema.session", nativeQuery = true)
    List<SessionHibernate> findByHQLQueryNative();
}
