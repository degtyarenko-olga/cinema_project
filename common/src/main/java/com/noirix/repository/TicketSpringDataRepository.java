package com.noirix.repository;

import com.noirix.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketSpringDataRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findAllByUserId(Long id);


}
