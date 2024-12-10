package com.maven;

public abstract class BaseFlight {
    private String country;
    private String airline;

    public BaseFlight(String country, String airline) {
        this.country = country;
        this.airline = airline;
    }
    
    public String getCountry() {
        return country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    
    public String getAirline() {
        return airline;
    }
    
    public void setAirline(String airline) {
        this.airline = airline;
    }
}
