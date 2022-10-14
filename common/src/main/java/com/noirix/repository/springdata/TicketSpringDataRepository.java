package com.noirix.repository.springdata;

import com.noirix.domain.TicketHibernate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TicketSpringDataRepository extends JpaRepository<TicketHibernate,Long> {

    @Query(value = "select t from TicketHibernate t")
    List<TicketHibernate> findAllTickets();
    List<TicketHibernate> findTicketHibernatesById(Long id);
}
