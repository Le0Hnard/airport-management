package com.demo.airportmanagement;

import com.demo.airportmanagement.db.AirportRepository;
import com.demo.airportmanagement.db.FlightInformationRepository;
import com.demo.airportmanagement.domain.*;
import com.demo.airportmanagement.queries.FlightInformationQueries;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ApplicationRunner implements CommandLineRunner {

    private FlightInformationRepository flightRepository;

    public ApplicationRunner(FlightInformationRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public void run(String... args) {
        List<FlightInformation> flights = this.flightRepository.findAll();
        FlightPrinter.print(flights);
    }

}
