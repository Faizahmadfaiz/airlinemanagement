package com.airline.models;

import java.time.LocalDate;

import com.airline.enums.Frequency;

public class FlightSchedule {
    private int id; // primary key
    private String flightNumber;
    private int sourceAirportId; // foreign key: airport.id
    private int destinationAirportId; // foreign key: airport.id
    private String scheduledDepartureTime;
    private String scheduledArrivalTime;
    private Frequency frequency; // DAILY, WEEKLY, MONTHLY
    private int scheduledDayOfWeek; // 1 (Monday) to 7 (Sunday)
    // other attributes common to all instances
    
    public boolean isValidForDate(LocalDate journeyDate) {
        // Check if the journey date aligns with the schedule's frequency
        if (frequency == Frequency.DAILY) {
            return true; // Daily flights are valid for any date
        } else if (frequency == Frequency.WEEKLY) {
            return journeyDate.getDayOfWeek().getValue() == this.scheduledDayOfWeek;
        }
        // Add other frequency checks as needed
        return false;
    }
}
