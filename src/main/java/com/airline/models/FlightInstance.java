package com.airline.models;

import java.util.Date;
import java.util.List;

import com.airline.enums.FlightStatus;

public class FlightInstance {
    private String id;
    private FlightSchedule flightSchedule;
    private Date flightDate;
    private Date actualDepartureTime;
    private Date actualArrivalTime;
    private FlightStatus status;
    private Aircraft assignedAircraft;
    private List<FlightSeat> flightSeats;
    private List<Crew> assignedCrew;
}
