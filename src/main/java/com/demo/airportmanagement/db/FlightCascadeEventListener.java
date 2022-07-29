package com.demo.airportmanagement.db;

import com.demo.airportmanagement.domain.Airport;
import com.demo.airportmanagement.domain.FlightInformation;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

@Component
public class FlightCascadeEventListener extends AbstractMongoEventListener<Object> {

    private MongoTemplate mongoTemplate;

    public FlightCascadeEventListener(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Object> event) {
        Object doc = event.getSource();

        if((doc instanceof FlightInformation) && (((FlightInformation)doc).getDeparture() != null)) {
            Airport departure = ((FlightInformation)doc).getDeparture();
            mongoTemplate.save(departure);
        }

        if((doc instanceof FlightInformation) && (((FlightInformation)doc).getDestination() != null)) {
            Airport destination = ((FlightInformation)doc).getDestination();
            mongoTemplate.save(destination);
        }
    }

}
