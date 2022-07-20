package com.demo.airportmanagement.com.demo.airportmanagement.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Document("flights")
public class FlightInformation {

    @Id
    private String id;

    @Field("departure")
    @Indexed
    private String departureCity;

    @Field("destination")
    @Indexed
    private String destinationCity;
    private FlightType type;
    private boolean isDelayed;
    private int durationWin;
    private LocalDate departureDate;
    private Aircraft aircraft;

    @Transient
    private LocalDate createdAt;

    public FlightInformation() {

    }

    public FlightInformation(String departureCity, String destinationCity, FlightType type, boolean isDelayed, int durationWin, LocalDate departureDate, Aircraft aircraft) {
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
        this.type = type;
        this.isDelayed = isDelayed;
        this.durationWin = durationWin;
        this.departureDate = departureDate;
        this.aircraft = aircraft;
        this.createdAt = LocalDate.now();
    }

    public FlightInformation(LocalDate createdAt) {
        this.createdAt = LocalDate.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public FlightType getType() {
        return type;
    }

    public void setType(FlightType type) {
        this.type = type;
    }

    public boolean isDelayed() {
        return isDelayed;
    }

    public void setDelayed(boolean delayed) {
        isDelayed = delayed;
    }

    public int getDurationWin() {
        return durationWin;
    }

    public void setDurationWin(int durationWin) {
        this.durationWin = durationWin;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

}
