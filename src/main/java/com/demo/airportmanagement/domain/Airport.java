package com.demo.airportmanagement.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("airports")
public class Airport {

    @Id
    private String id;
    private String name;
    private String city;
    private int passengersServed;

    public Airport(String id, String name, String city, int passengersServed) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.passengersServed = passengersServed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPassengersServed() {
        return passengersServed;
    }

    public void setPassengersServed(int passengersServed) {
        this.passengersServed = passengersServed;
    }

}
