package com.demo.airportmanagement.db;

import com.demo.airportmanagement.domain.FlightInformation;
import com.demo.airportmanagement.domain.FlightType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightInformationRepository extends MongoRepository<FlightInformation, String> {

//    List<FlightInformation> findByDepartureCityAndDestinationCity(String departure, String destination);
    List<FlightInformation> findByDelayedTrue();

    List<FlightInformation> fundByType(FlightType flightType);

    @Query("{'aircraft.nbSeats': {$gte: ?0}}")
    List<FlightInformation> findByMinAircraftNbSeats(int minNbSeats);

}
