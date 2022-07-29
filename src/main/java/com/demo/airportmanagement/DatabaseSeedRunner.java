package com.demo.airportmanagement;

import com.demo.airportmanagement.db.AirportRepository;
import com.demo.airportmanagement.db.FlightInformationRepository;
import com.demo.airportmanagement.domain.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
@Order(1)
public class DatabaseSeedRunner implements CommandLineRunner {

    private FlightInformationRepository flightRepository;
    private AirportRepository airportRepository;
    private MongoTemplate mongoTemplate;

    public DatabaseSeedRunner(FlightInformationRepository flightRepository, AirportRepository airportRepository, MongoTemplate mongoTemplate) {
        this.flightRepository = flightRepository;
        this.airportRepository = airportRepository;
        this.mongoTemplate = mongoTemplate;
    }

    private void seed() {
        Airport rome = new Airport("1d1aab22-670b-48cb-a027-721e2055731f", "Leonardo Da Vinci", "Rome", 42995119);
        Airport paris = new Airport("d04a8c26-7527-407c-81ef-680e5de34cea", "Charles De Gaulle", "Paris", 72229723);
        Airport copenhagen = new Airport("7ed990d2-6471-485d-931e-c77729dc0f25", "Copenhagen Airport", "Copenhagen", 30298531);

        // Data
        FlightInformation flightOne = new FlightInformation();
        flightOne.setId("b8b50563-ca90-4afc-9d43-b674892a525c");
        flightOne.setDelayed(false);
        flightOne.setDeparture(rome);
        flightOne.setDestination(paris);
        flightOne.setDepartureDate(LocalDate.of(2019, 3, 12));
        flightOne.setType(FlightType.International);
        flightOne.setDurationMin(80);
        flightOne.setAircraft(new Aircraft("737", 180));
        flightOne.setDescription("Flight from Rome to Paris");

        FlightInformation flightTwo = new FlightInformation();
        flightTwo.setId("c0725fbb-eebb-4aae-8b41-3887793d0c50");
        flightTwo.setDelayed(false);
        flightTwo.setDeparture(paris);
        flightTwo.setDestination(copenhagen);
        flightTwo.setDepartureDate(LocalDate.of(2019, 5, 11));
        flightTwo.setType(FlightType.International);
        flightTwo.setDurationMin(600);
        flightTwo.setAircraft(new Aircraft("747", 300));
        flightTwo.setDescription("Flight from NY to Copenhagen via Rome");

        // Seed
//        List<Airport> airports = Arrays.asList(rome, paris, copenhagen);
//        this.airportRepository.insert(airports);

        List<FlightInformation> flights = Arrays.asList(flightOne, flightTwo);
        this.flightRepository.insert(flights);

        FlightPrinter.print(flights);
    }

    private void empty() {
        this.mongoTemplate.dropCollection(Airport.class);
        this.mongoTemplate.dropCollection(FlightInformation.class);
    }

    @Override
    public void run(String... args) throws Exception {
        empty();
        seed();
    }
}
