package com.ticket.microservice.dao;

import com.ticket.microservice.model.entity.Itinerary;
import org.springframework.data.repository.CrudRepository;

public interface ItineraryDAO extends CrudRepository<Itinerary,Long> {
}
