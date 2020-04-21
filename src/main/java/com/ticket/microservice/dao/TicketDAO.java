package com.ticket.microservice.dao;

import org.springframework.data.repository.CrudRepository;
import com.ticket.microservice.model.entity.Ticket;

public interface TicketDAO extends CrudRepository<Ticket,Long> {
}
