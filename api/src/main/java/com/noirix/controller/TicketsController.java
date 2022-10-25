package com.noirix.controller;

import com.noirix.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/data/tickets")
public class TicketsController {

    private final TicketService service;

    @GetMapping
    public ResponseEntity<Object> findAllTickets() {

        return new ResponseEntity<>(
                Collections.singletonMap("tickets", service.findAllTickets()),
                HttpStatus.OK
        );
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Object> findTicketById(@Valid @PathVariable("id") Long id){

        return new ResponseEntity<>(Collections.singletonMap("result",
                service.findById(id)), HttpStatus.OK);

    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteTicketById(@PathVariable Long id) {

        service.delete(id);

        Map<String, Object> model = new HashMap<>();
        model.put("id", id);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

}
