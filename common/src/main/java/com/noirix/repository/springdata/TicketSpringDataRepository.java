package com.noirix.repository.springdata;

import com.noirix.domain.hibernate.SessionHibernate;
import com.noirix.domain.hibernate.TicketHibernate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketSpringDataRepository extends JpaRepository<TicketHibernate,Long> {

    @Query(value = "select t from TicketHibernate t")
    List<TicketHibernate> findAllTickets();

    @Query(value = "select * from cinema.ticket where id = ?", nativeQuery = true)
    List<TicketHibernate> findTicketHibernateById(Long id);
    //select * from m_users where (login = ? and name = ?) or birth_date = ?
}
