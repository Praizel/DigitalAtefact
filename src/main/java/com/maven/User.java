package com.maven;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * User class represents a user in the system. It stores personal information
 * about the user and a list of thier booked flights
 */
public class User {
    private String fullName;
    private String email;
    private String password;
    private String passportNumber;
    private String countryOfOrigin;
    private LocalDate dateOfBirth;
    
    private List<BookedFlight> bookedFlights;
   
    /**
     * Constructs a User with the specified details
     * 
     * @param fullName the user's fullNmae
     * @param email the user's email
     * @param password the user's password
     * @param passportNumber user's passportNumber
     * @param countryOfOrigin user's countryOfOrigin
     * @param dateOfBirth user's date of birth
     */
    public User(String fullName, String email, String password, String passportNumber, String coutryOfOrigin,
            LocalDate dateOfBirth) 
    {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.passportNumber = passportNumber;
        this.countryOfOrigin = coutryOfOrigin;
        this.dateOfBirth = dateOfBirth;
        this.bookedFlights = new ArrayList<>();
    }

    /**
     * Adds a booked flight to the list of booked flights
     * @param bookedFlight the booked flight to add
     * 
     */
    public void addBookedFlight(BookedFlight bookedFlight)
    {
        bookedFlights.add(bookedFlight);
    }

    /**
     * Returns the list of booked flights.
     * @return the list of booked flights
     */
    public List<BookedFlight> getBookedFlights() 
    {
        return bookedFlights;
    }

    /**
     * Sets the list of booked Flight
     * @param bookedFlights is the list of bookedFlights to be set
     */
    public void setBookedFlights(List<BookedFlight> bookedFlights)
    {
        this.bookedFlights = bookedFlights;
    }
    
    /**
     * Sets the full Name
     * @param fullName is the full name to be set
     */
    public void setFullName(String fullName) 
    {
        this.fullName = fullName;
    }

    /**
     * Returns full name
     * @return the fullName as a String
     */
    public String getFullName() 
    {
        return fullName;
    }

    /**
     * Sets the email
     * @param email is the email to be set
     */
    public void setEmail(String email) 
    {
        this.email = email;
    }

    /**
     * Returns email
     * @return the email as String
     */
    public String getEmail() 
    {
        return email;
    }
    
    /**
     * Sets the password
     * @param password is the password to be set
     */
    public void setPassword(String password) 
    {
        this.password = password;
    }

    /**
     * Returns password
     * @return the password as a String
     */
    public String getPasword() 
    {
        return password;
    }

    /**
     * Sets the passportNumber
     * @param passportNumber is the passportNumber to be set
     */
    public void setPassportNumber(String passportNumber) 
    {
        this.passportNumber = passportNumber;
    }

    /**
     * Returns passportNumber
     * @return the passportNumber as a String
     */
    public String getPassportNumber() 
    {
        return passportNumber;
    }

    /**
     * Sets the countryOfOrigin
     * @param countryOfOrigin is the countryOfOrigin to be set
     */
    public void setCountryOfOrigin(String countryOfOrigin) 
    {
        this.countryOfOrigin = countryOfOrigin;
    }

     /**
     * Returns countryOfOrigin
     * @return the countryOfOrigin as a String
     */
    public String getCountryOfOrigin() 
    {
        return countryOfOrigin;
    }

    /**
     * Sets the dateOfBirth
     * @param dateOfBirth is the dateOfBirth to be set
     */
    public void setDateOfBirth(LocalDate dateOfBirth) 
    {
        this.dateOfBirth = dateOfBirth;
    }

     /**
     * Returns dateOfBirth
     * @return the dateOfBirth as a String
     */
    public LocalDate getDateOfBirth() 
    {
        return dateOfBirth;
    }

}

