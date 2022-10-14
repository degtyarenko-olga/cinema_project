package com.noirix.controller.springdata;

import com.noirix.repository.springdata.TicketSpringDataRepository;
import com.noirix.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/data/tickets")
public class TicketsController {

   // private final TicketSpringDataRepository repository;

    private final TicketService service;

    @GetMapping
    public ResponseEntity<Object> findAllTickets() {

        return new ResponseEntity<>(
                Collections.singletonMap("tickets", service.findAllTickets()),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findTicketById(@PathVariable Long id) {

        return new ResponseEntity<>(
                Collections.singletonMap("tickets", service.findTicketHibernatesById(id)),
                HttpStatus.OK
        );
    }
}
