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
@Order(2)
public class ApplicationRunner implements CommandLineRunner {

    private FlightInformationRepository flightRepository;
    private AirportRepository airportRepository;

    public ApplicationRunner(FlightInformationRepository flightRepository, AirportRepository airportRepository) {
        this.flightRepository = flightRepository;
        this.airportRepository = airportRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Airport rome = this.airportRepository.findById("1d1aab22-670b-48cb-a027-721e2055731f").get();
        rome.setName("Leonardo Da Vinci (Fiumicino)");
        this.airportRepository.save(rome);

        System.out.println("-> AFTER UPDATE TO ROME AIRPORT");
        List<FlightInformation> flights = this.flightRepository.findAll();
        FlightPrinter.print(flights);
    }

}
