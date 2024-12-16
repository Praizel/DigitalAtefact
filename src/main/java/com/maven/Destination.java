package com.maven;
import java.util.Map;


/**
 * The Destination class represents a flight destination, including the 
 * availability of seats on different days and the airline's contact information.
 */
public class Destination extends BaseFlight {
     
    // A map where the key is the day and the value is the number of seats available on that day
    private Map<String, Integer> availability;
    // Airline contact number
    private String contact;

    /**
     * Constructs a Destination with the specified availability, country, contact, and airline.
     * 
     * @param availability a map of seat availability by day
     * @param country the country of the destination
     * @param contact the airline's contact number
     * @param airline the name of the airline
     */
    public Destination(Map<String, Integer> availability, String country, String contact, String airline) {
        super(country, airline);
        this.availability = availability;
        this.contact = contact;
    }

    /**
     * Sets the availability map
     * @param availability is the availability map to set
     */
    public void setAvailability(Map<String, Integer> availability) {
        this.availability = availability;
    }

    /**
     * Gets the availability map.
     * 
     * @return the availablity map
     */
    public Map<String, Integer> getAvailability() 
    {
        return availability;
    }

    /**
     * Sets the contact number
     * 
     * @param contact the contact number to set
     */
    public void setContact(String contact) 
    {
        this.contact = contact;
    }
    
    /**
     * Gets the contact number
     * 
     * @return the contact number as a String
     */
    public String getContact() 
    {
        return contact;
    }

  /**
   * Returns a String represention of the Destination object
   * @return a string that includes the country, availability, contact and airline information
   * 
   */
    @Override
    public String toString() 
    {
        return "Destination [country=" + super.getCountry() + ", availability=" + availability + ", contact=" + contact
                + ", airline=" + super.getAirline() + "]";
    }

}
