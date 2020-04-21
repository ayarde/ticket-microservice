package com.ticket.microservice.service.impl;

import com.ticket.microservice.dao.ItineraryDAO;
import com.ticket.microservice.model.entity.Itinerary;
import com.ticket.microservice.service.IItineraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ItineraryServiceImpl implements IItineraryService {
    @Autowired
    ItineraryDAO itineraryDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Itinerary> findAll() {
        return (List<Itinerary>) itineraryDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Itinerary findById(Long id) {
        return itineraryDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Itinerary save(Itinerary itinerary) {
        return itineraryDAO.save(itinerary);
    }
}
