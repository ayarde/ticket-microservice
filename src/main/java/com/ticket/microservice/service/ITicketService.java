package com.ticket.microservice.service;

import com.ticket.microservice.model.entity.Ticket;

import java.util.List;

public interface ITicketService {
    public List<Ticket> findAll();
    public Ticket findById(Long id);
    public Ticket save(Ticket ticket);
}
