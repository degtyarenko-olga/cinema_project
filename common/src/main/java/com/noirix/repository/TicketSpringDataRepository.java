package com.noirix.repository;

import com.noirix.domain.TicketHibernate;
import com.noirix.domain.UsersHibernate;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TicketSpringDataRepository extends JpaRepository<TicketHibernate,Long> {

    @Query(value = "select t from TicketHibernate t")
    List<TicketHibernate> findByHQLQuery();

    TicketHibernate findTicketHibernateById(Long id);
}
