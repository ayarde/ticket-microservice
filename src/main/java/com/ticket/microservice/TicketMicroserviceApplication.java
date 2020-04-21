package com.ticket.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.ticket.microservice.model.entity"})
public class TicketMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicketMicroserviceApplication.class, args);
    }

}
