package com.demo.airportmanagement.db.migrations;

import com.demo.airportmanagement.domain.Airport;
import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import org.springframework.data.mongodb.core.MongoTemplate;

@ChangeLog(order = "002")
public class DbChangeLog002 {

    @ChangeSet(order = "001", id = "updateRomeAirport", author = "Dan Geabunea")
    public void updateRomeAirport(MongoTemplate mongoTemplate) {
        String romeAirportId = "1d1aab22-670b-48cb-a027-721e2055731f";
        Airport romeAirport = mongoTemplate.findById(romeAirportId, Airport.class);

        romeAirport.setName("Leonardo da Vinci (Fiumicino)");

        mongoTemplate.save(romeAirport);

        System.out.println("DB Migrations - ChangeLog 002, ChangeSet 001");
    }

}
