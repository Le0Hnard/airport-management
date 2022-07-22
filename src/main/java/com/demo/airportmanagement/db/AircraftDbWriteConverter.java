package com.demo.airportmanagement.db;

import com.demo.airportmanagement.domain.Aircraft;
import org.springframework.core.convert.converter.Converter;

public class AircraftDbWriteConverter implements Converter<Aircraft, String> {

    @Override
    public String convert(Aircraft aircraft) {
        return aircraft.getModel() + "/" + aircraft.getNbSeats();
    }

}
