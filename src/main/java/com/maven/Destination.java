package com.maven;
import java.util.Map;

public class Destination extends BaseFlight {

    private Map<String, Integer> availability;
    private String contact;

    public Destination(Map<String, Integer> availability, String country, String contact, String airline) {
        super(country, airline);
        this.availability = availability;
        this.contact = contact;
    }

    public void setAvailability(Map<String, Integer> availability) {
        this.availability = availability;
    }

    public Map<String, Integer> getAvailability() {
        return availability;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContact() {
        return contact;
    }



    @Override
    public String toString() {
        return "Destination [country=" + super.getCountry() + ", availability=" + availability + ", contact=" + contact
                + ", airline=" + super.getAirline() + "]";
    }

}
