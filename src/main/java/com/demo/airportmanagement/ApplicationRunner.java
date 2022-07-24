package com.demo.airportmanagement;

import com.demo.airportmanagement.db.FlightInformationRepository;
import com.demo.airportmanagement.domain.Aircraft;
import com.demo.airportmanagement.domain.FlightInformation;
import com.demo.airportmanagement.domain.FlightPrinter;
import com.demo.airportmanagement.domain.FlightType;
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

    private FlightInformationRepository repository;

    public ApplicationRunner(FlightInformationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        printById("4d23fd8b-47a7-45f8-958c-94d0e21488b2");

        delayFlight("4d23fd8b-47a7-45f8-958c-94d0e21488b2", 30);

        removeFlight("4d23fd8b-47a7-45f8-958c-94d0e21488b2");

        printByDepartureAndDestination("Madrid", "Barcelona");

        printByMinNbSeats(200);
    }

    private void printById(String id) {
        System.out.println("Flight " + id);

        FlightInformation flight = this.repository.findById(id).get();
        FlightPrinter.print(Arrays.asList(flight));
    }

    private void delayFlight(String id, int duration) {
        FlightInformation flight = this.repository.findById(id).get();

        flight.setDurationMin(flight.getDurationMin() + duration);

        this.repository.save(flight);

        System.out.println("Updated flight " + id + "\n");
    }

    private void removeFlight(String id) {
        this.repository.deleteById(id);
        System.out.println("Deleted flight " + id + "\n");
    }

    private void printByDepartureAndDestination(String dep, String dst) {
        System.out.println("Flights from " + dep + " to " + dst);

        List<FlightInformation> flights = this.repository.findByDepartureCityAndDestinationCity(dep, dst);

        FlightPrinter.print(flights);
    }

    private void printByMinNbSeats(int minNbSeats) {
        System.out.println("Flights by min nb seats " + minNbSeats);

        List<FlightInformation> flights = this.repository.findByMinAircraftNbSeats(200);

        FlightPrinter.print(flights);
    }

}
