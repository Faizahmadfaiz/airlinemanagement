package com.airline.services;

import java.time.LocalDate;
import java.util.List;

import com.airline.models.Airport;
import com.airline.models.FlightInstance;
import com.airline.models.FlightSchedule;
import com.airline.exceptions.NoInstancesException;
import com.airline.exceptions.NoScheduleException;
import com.airline.repositories.FlightInstanceRepository;
import com.airline.repositories.FlightScheduleRepository;

public class FlightService {
    private FlightInstanceRepository flightInstanceRepository;
    private FlightScheduleRepository flightScheduleRepository;

    public FlightService(FlightInstanceRepository flightInstanceRepository, FlightScheduleRepository flightScheduleRepository) {
        this.flightInstanceRepository = flightInstanceRepository;
        this.flightScheduleRepository = flightScheduleRepository;
    }

    public List<FlightInstance> searchFlights(Airport source, Airport destination, LocalDate journeyDate) throws NoScheduleException, NoInstancesException {
        // Fetch flight instances for the given date
        List<FlightInstance> flightInstances = flightInstanceRepository.findByDateAndRoute(source, destination, journeyDate);

        if (flightInstances.isEmpty()) {
            // Fetch the flight schedule to validate the journey date
            FlightSchedule schedule = flightScheduleRepository.findByRoute(source, destination);
            if (schedule == null) {
                throw new NoScheduleException("No schedule exists for the selected route.");
            }

            // Check if the journey date aligns with the schedule's frequency
            if (!schedule.isValidForDate(journeyDate)) {
                throw new NoInstancesException("No flight is scheduled for the given date.");
            }

            throw new NoInstancesException("This flight is not yet scheduled. Please try again later.");
        }

        return flightInstances;
    } 
}
