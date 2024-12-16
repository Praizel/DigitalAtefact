package com.maven;



/**
 * The BaseFlight class is an abstract representation of a flight including the
 * country and airline. It is extended by the classes, BookedFlight and Destination 
 */
public abstract class BaseFlight {
    private String country;
    private String airline;

    /**
     * 
     * @param country the country associated with the Baseflight
     * @param airline the airline associated with the airline
     */
    public BaseFlight(String country, String airline) 
    {
        this.country = country;
        this.airline = airline;
    }
    
    /**
     * Gets the country 
     * @return the country as String
     */
    public String getCountry() 
    {
        return country;
    }
    
    /**
     * Sets the country 
     * @param country is the country to be set
     */
    public void setCountry(String country) 
    {
        this.country = country;
    }
    
    /**
     * Gets the airline 
     * @return the airline as String
     */
    public String getAirline() 
    {
        return airline;
    }
    
    /**
     * Sets the airline field
     * @param airline is the airline to be set
     */
    public void setAirline(String airline) 
    {
        this.airline = airline;
    }
}
