package com.demo.airportmanagement;

import com.demo.airportmanagement.com.demo.airportmanagement.domain.Aircraft;
import com.demo.airportmanagement.com.demo.airportmanagement.domain.FlightInformation;
import com.demo.airportmanagement.com.demo.airportmanagement.domain.FlightType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class ApplicationRunner implements CommandLineRunner {

    private MongoTemplate mongoTemplate;

    public ApplicationRunner(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
//        FlightInformation emptyFlight = new FlightInformation();
//        this.mongoTemplate.save(emptyFlight);

        System.out.println("Application started...");
    }

}
