package com.ticket.microservice.service;

import com.ticket.microservice.model.entity.Itinerary;

import java.util.List;

public interface IItineraryService {
    public List<Itinerary> findAll();
    public Itinerary findById(Long id);
    public Itinerary save(Itinerary itinerary);
}
