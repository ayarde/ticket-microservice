package com.ticket.microservice.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ticket")
@Data
public class Ticket implements Serializable {

    private static final long serialVersionUID = 6461579876619102075L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String passengerName;
    private Long passengerAge;
    private Double price;
    private Boolean luggageStorage;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="itinerary_id")
    private Itinerary itinerary;
}
