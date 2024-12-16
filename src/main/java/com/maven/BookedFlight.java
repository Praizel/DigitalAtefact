package com.maven;

/**
 * The BookedFlight class represents a flight that has been booked.
 * It extends the BaseFlight class to include additional information about
 * the booking day.
 * 
 */
public class BookedFlight extends BaseFlight {
    private String day;

    /**
     * Constructs a BookedFlight with the specified country, airline, and day.
     * 
     * @param country the country associated with the flight
     * @param airline the airline associated with the flight
     * @param day     the day the flight was booked
     */
    public BookedFlight(String country, String airline, String day) {
        super(country, airline);
        this.day = day;
    }

    /**
     * Gets the day the flight was booked
     * 
     * @return the booking day as a String
     */
    public String getDay() {
        return day;
    }

    /**
     * Sets the day the flight was booked
     * 
     * @param day the booking day to set
     */
    public void setDay(String day) {
        this.day = day;
    }
}