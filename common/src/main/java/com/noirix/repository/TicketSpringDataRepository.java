package com.noirix.repository;

import com.noirix.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketSpringDataRepository extends JpaRepository<Ticket, Long> {

    @Query(value = "select t from Ticket t")
    List<Ticket> findByHQLQuery();

    Ticket findTicketHibernateById(Long id);
}
