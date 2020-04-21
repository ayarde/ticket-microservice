package com.ticket.microservice.controller;

import com.ticket.microservice.AbstractTest;
import com.ticket.microservice.model.entity.Itinerary;
import com.ticket.microservice.model.entity.Ticket;
import com.ticket.microservice.service.IItineraryService;
import com.ticket.microservice.service.ITicketService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class TicketControllerTest extends AbstractTest {
    Itinerary itinerary;
    Ticket ticket;

    @MockBean
    private ITicketService ticketServiceMock;

    @MockBean
    private IItineraryService itineraryServiceMock;

    @Override
    @Before
    public void setUp() {
        itinerary = new Itinerary();
        LocalDate localDate = LocalDate.of(2020,5,12);
        LocalTime departureTime= LocalTime.of(15,15);
        LocalTime arrivalTime= LocalTime.of(16,0);

        itinerary.setId(1L);
        itinerary.setDepartureDate(localDate);
        itinerary.setArrivalDate(localDate);
        itinerary.setArrivalTime(arrivalTime);
        itinerary.setDepartureTime(departureTime);
        itinerary.setCityOrigin("Jujuy");
        itinerary.setCityDestination("Cordoba");

        ticket = new Ticket();
        ticket.setId(1L);
        ticket.setPassengerName("Pepe");
        ticket.setPassengerAge(55L);
        ticket.setPrice(256.3D);
        ticket.setLuggageStorage(true);
        ticket.setItinerary(itinerary);
        super.setUp();
    }

    @Test
    public void createTicket() throws Exception {

        when(ticketServiceMock.save(any(Ticket.class))).thenReturn(ticket);

        mvc.perform(post("/ticket/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"passengerName\":\"Pepe\",\"passengerAge\":55,\"price\":256.3,\"luggageStorage\":true," +
                        "\"itinerary\":{\"departureDate\":\"2020-05-12\",\"arrivalDate\":\"2020-05-12\",\"cityOrigin\":" +
                        "\"Jujuy\",\"cityDestination\":\"Cordoba\",\"departureTime\":\"15:00\",\"arrivalTime\":\"16:15\"}}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.passengerName").value("Pepe"))
                .andExpect(jsonPath("$.passengerAge").value(55));
    }

    @Test
    public void getTicketByID() throws Exception {
        when(ticketServiceMock.findById(1L)).thenReturn(ticket);
        mvc.perform(get("/ticket/list/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.passengerName").value("Pepe"))
                .andExpect(jsonPath("$.passengerAge").value(55));
    }

    @Test
    public void getItineraryByID() throws Exception {
        when(itineraryServiceMock.findById(1L)).thenReturn(itinerary);
        mvc.perform(get("/itinerary/list/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.cityOrigin").value("Jujuy"))
                .andExpect(jsonPath("$.cityDestination").value("Cordoba"));
    }

}
