package com.airline.repositories;

import java.time.LocalDate;
import java.util.List;

import com.airline.models.Airport;
import com.airline.models.FlightInstance;

public class FlightInstanceRepository {

    public List<FlightInstance> findByDateAndRoute(Airport source, Airport destination, LocalDate journeyDate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByDateAndRoute'");
    }

}
