package com.maven;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import java.util.ArrayList;
import java.util.List;


public class AFlightBookingAppTest {

    @Before
    public void setUp() 
    {
     // Initialize the destination list before each test
                
     AFlightBookingApp.destinationList = new ArrayList<>();
     AFlightBookingApp.destinationList.add(new Destination(new HashMap<>(Map.of("monday", 127)), "USA", "078", "British Airlines"));
     AFlightBookingApp.destinationList.add(new Destination(new HashMap<>(Map.of("tuesday", 150)), "France", "078", "France Air"));
     AFlightBookingApp.destinationList.add(new Destination(new HashMap<>(Map.of("thursday", 200)), "Canada", "078", "Canada Air"));
    }
                         

    @Test
    public void testFindDestinationByCountry_Found() 
    {
        // Test case where the destination is found
        Destination destination = AFlightBookingApp.findDestinationByCountry("USA");
        assertNotNull(destination);
        assertEquals("USA", destination.getCountry());
    }

    @Test
    public void testFindDestinationByCountry()
    {
        // Test case where the destination is found
        Destination d = AFlightBookingApp.findDestinationByCountry("France");
        assertFalse(d==null);
    }
  
    @Test
    public void testFindDestinationByCountry_NotFound() 
    {
        // Test case where the destination is not found
        Destination destination = AFlightBookingApp.findDestinationByCountry("Germany");
        assertNull(destination);
    }

    @Test
    public void testFindDestinationByCountry_CaseInsensitive() 
    {
        // Test case to check case insensitivity
        Destination destination = AFlightBookingApp.findDestinationByCountry("france");
        assertNotNull(destination);
        assertEquals("France", destination.getCountry());
    }

    @Test
    public void testFindDestinationByCountry_TrimWhitespace() 
    {
        // Test case to check trimming of whitespace
        Destination destinationList = AFlightBookingApp.findDestinationByCountry("  Canada  ");
        assertEquals("Canada", destinationList.getCountry());
    }
}