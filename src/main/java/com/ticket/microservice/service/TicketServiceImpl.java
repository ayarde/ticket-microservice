package com.ticket.microservice.service;

import com.ticket.microservice.model.entity.Ticket;
import com.ticket.microservice.dao.TicketDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TicketServiceImpl implements ITicketService {
    @Autowired
    private TicketDAO ticketDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Ticket> findAll() {
        return (List<Ticket>) ticketDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Ticket findById(Long id) {
        return ticketDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Ticket save(Ticket ticket) {
        return ticketDAO.save(ticket);
    }
}
