package com.demo.airportmanagement;

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

    private MongoTemplate mongoTemplate;

    public ApplicationRunner(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
//
//    @Override
//    public void run(String... args) throws Exception {
////        FlightInformation emptyFlight = new FlightInformation();
////        this.mongoTemplate.save(emptyFlight);
//
//        System.out.println("Application started...");
//    }

//    private FlightInformationQueries flightInformationQueries;
//
//    public ApplicationRunner(FlightInformationQueries flightInformationQueries) {
//        this.flightInformationQueries = flightInformationQueries;
//    }

    @Override
    public void run(String... args) {
//        System.out.println("-----\nQUERY: All flights ordered by departure");
//        List<FlightInformation> allFlightsOrdered = this.flightInformationQueries
//                .findAll("departure", 0, 10);
//        FlightPrinter.print(allFlightsOrdered);
//
//        System.out.println("-----\nQUERY: Free text search: Rome");
//        List<FlightInformation> flightsByFreeText = this.flightInformationQueries
//                .findByFreeText("Rome");
//        FlightPrinter.print(flightsByFreeText);

        markAllFlightsToRomeAsDelayed();
        removeFlightsWithDurationLessThanTwoHours();
    }

    void markAllFlightsToRomeAsDelayed() {
        Query departingFromRome = Query.query(Criteria.where("destination").is("Rome"));

        Update setDelayed = Update.update("isDelayed", true);

        this.mongoTemplate.updateMulti(departingFromRome, setDelayed, FlightInformation.class);
    }

    void removeFlightsWithDurationLessThanTwoHours() {
        Query lessThanTwoHours = Query.query(Criteria.where("duration").lt(120));
        this.mongoTemplate.findAllAndRemove(lessThanTwoHours, FlightInformation.class);
    }

}
