package com.maven;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String fullName;
    private String email;
    private String password;
    private String passportNumber;
    private String countryOfOrigin;
    private LocalDate dateOfBirth;
    private List<BookedFlight> bookedFlights;

    public User(String fullName, String email, String password, String passportNumber, String coutryOfOrigin,
            LocalDate dateOfBirth) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.passportNumber = passportNumber;
        this.countryOfOrigin = coutryOfOrigin;
        this.dateOfBirth = dateOfBirth;
        this.bookedFlights = new ArrayList<>();
    }

    public void addBookedFlight(BookedFlight bookedFlight){
        bookedFlights.add(bookedFlight);
    }

    public List<BookedFlight> getBookedFlights() {
        return bookedFlights;
    }

    public void setBookedFlights(List<BookedFlight> bookedFlights) {
        this.bookedFlights = bookedFlights;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasword() {
        return password;
    }

}

// Create all arguments constructor