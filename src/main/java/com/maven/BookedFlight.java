package com.maven;

public class BookedFlight extends BaseFlight {
    private String day;
    
    public BookedFlight (String country, String airline, String day) {
        super(country, airline);
        this.day = day;
    } 

    public String getDay() {

        return day;
    }
    
    public void setDay(String day) {
        this.day = day;
    }
}