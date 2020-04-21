package com.ticket.microservice.controller;

import com.ticket.microservice.model.entity.Itinerary;
import com.ticket.microservice.model.entity.Ticket;
import com.ticket.microservice.service.IItineraryService;
import com.ticket.microservice.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class TicketController {

    @Autowired
    private ITicketService ticketService;

    @Autowired
    private IItineraryService itineraryService;

    @GetMapping("/ticket/list/{id}")
    public Ticket listTicketById(@PathVariable Long id){
        return ticketService.findById(id);
    }

    @GetMapping("/itinerary/list/{id}")
    public Itinerary listItineraryById(@PathVariable Long id){
        return itineraryService.findById(id);
    }

    @PostMapping("/ticket/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Ticket create(@RequestBody Ticket ticket) {
        return ticketService.save(ticket);
    }
}
