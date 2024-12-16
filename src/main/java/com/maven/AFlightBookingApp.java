package com.maven;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * The class AFlightBookingApp is the main class for this Digital
 * Artefact system booking, it handles user sign-in, sign-up, flight reservation,
 * and checking reservations.
 */
public class AFlightBookingApp {

    /** They are final because we don't want them to change */
    // The list of users in the system
    private static final List<User> users = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    // The list of predefined destinations which our system allows
    static List<Destination> destinationList;

    /**
     * Method allows the logged in user to reserve a flight and select
     * destination
     * 
     * @param user the current logged-in user
     * 
     */
    public static void reserveFlight(User user) 
    {
        System.out.println("See the list of available Destinations: ");
        printDestinations();
        System.out.println("Enter the Destination Country you want to Travel: ");
        String country = scanner.nextLine();

        // Find the Destination based on the selected country
        Destination d = findDestinationByCountry(country);
        // If the Destination is not found
        if (d == null) {

            System.out.println("Destination does not exist ");
        }

        else {
            System.out.println("Your Desitnation is: ");
            System.out.println(d);
            System.out.println("What day do you want to Travel: ");

            // Scanner allows input of the day and will remove any whitespace
            String day = scanner.nextLine().trim().toLowerCase();

            // Map will check the availability of the selected day and the number of seats available
            Map<String, Integer> availability = d.getAvailability();
            Integer seats = availability.get(day);
            // Checks there are available seats and prints out the Statement in the String
            // ""
            if (seats != null) {
                if (seats > 0) {
                    System.out.println("There are " + seats + " seats available to be booked ");
                    // Ask user to confirm and updates the hashmap
                    System.out.println("Do you want to go ahead and book seats Yes/No ");
                    String answer = scanner.nextLine().trim().toLowerCase();
                    // If user inputs "yes" updates the hashmap and print out String "" statement
                    if (answer.equals("yes")) {
                        BookedFlight f = new BookedFlight(country, d.getAirline(), day);
                        user.addBookedFlight(f);
                        availability.put(day, seats - 1);
                        System.out.println("Flight now Reserved");
                    }
                } else {
                    // Flight is booked out
                    System.out.println("All seats for this flight is fully booked ");
                }

            } else {
                // Flight day doesnt exist
                System.out.println("Flight day does not exist ");
            }

        }

    }

    /**
     * Method prints the booked flights made by the user
     * 
     * @param user the user whose booked flight will be checked
     * 
     */
    public static void checkReservation(User user) 
    {
        System.out.println("See your booked reservation below: ");

        List<BookedFlight> bookedFlights = user.getBookedFlights();
        for (int i = 0; i < bookedFlights.size(); i++) {
            BookedFlight bookedflight = bookedFlights.get(i);
            String country = bookedflight.getCountry();
            String day = bookedflight.getDay();
            System.out.println("Booked " + "country: " + country + "," + " Day: " + day + "," + " " + "Airline: "
                    + bookedflight.getAirline());
        }

    }

    /**
     * ALlows the user to sign in by entering their email and password
     * 
     */
    public static void signIn() 
    {
        System.out.println("Option 1 - Sign In");
        scanner.nextLine(); // There was a bug with scanner and we had to consume the next line to solve the
                            // bug
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        User loggedInUser = null;
        //Check if there is a user with given email and password
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            boolean isEmail = user.getEmail().equals(email);
            boolean isPassword = user.getPasword().equals(password);
            if (isEmail == true && isPassword == true) {
                loggedInUser = user;
                break; // we found the user
            }
        }

        if (loggedInUser != null) {
            System.out.println("Welcome " + loggedInUser.getFullName());
            boolean flightResevationOption = true;
            // While the user is logged in we show the flight reservation options
            while (flightResevationOption) {
                System.out.println("[1] - Reserve flight ");
                System.out.println("[2] - Check Reservation ");
                System.out.println("[3] - LogOut ");
                System.out.print("Enter your choice: ");
                int reservationChoice = scanner.nextInt();
                scanner.nextLine();

                switch (reservationChoice) {
                    case 1:
                        reserveFlight(loggedInUser);
                        break;
                    case 2:
                        checkReservation(loggedInUser);
                        break;
                    case 3:
                        flightResevationOption = false;
                        break; // User logged out
                    default:
                        break;
                }
            }

        } else {
            System.out.println("User not found ");
        }

    }

    /**
     * Allows the user to sign up by entering thier details.
     */
    public static void signUp() 
    {
        scanner.nextLine();
        System.out.println("Option 2 - Sign Up");
        System.out.print("Full Name: ");
        String fullName = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        System.out.print("Enter Passport Number: ");
        String passportNumber = scanner.nextLine();
        System.out.print("Country of Origin: ");
        String countryOfOrigin = scanner.nextLine();
        System.out.print("Date of Birth (YYYY-MM-DD): ");
        String dateOfBirthString = scanner.nextLine();
        // parsing the date string in the format YYYY-MM-DD
        LocalDate dateOfBirth = LocalDate.parse(dateOfBirthString);
        User user = new User(fullName, email, password, passportNumber, countryOfOrigin, dateOfBirth);
        users.add(user);
    }

    /**
     * Prints the list of available destination
     */
    public static void printDestinations() 
    {
        for (int i = 0; i < destinationList.size(); i++) {
            System.out.println(destinationList.get(i));
        }
    }

    /**
     *Finds a destination by its country.
     * 
     * @param country the country to search for
     * @return the destination if found, otherwise null
     */
    public static Destination findDestinationByCountry(String country) 
    {
        for (int i = 0; i < destinationList.size(); i++) {
            // get the destination object from index i
            Destination d = destinationList.get(i);
            String c = d.getCountry();
            // we remove any whitespace and makesure we compare both in lower case
            if (c.toLowerCase().equals(country.toLowerCase().trim())) {
                return d;

            }

        }
        return null;
    }

    // The main method serve as the entry point to run the FlightBooking program
    public static void main(String[] args) 
    {
        destinationList = new ArrayList<Destination>();
        destinationList.add(
                new Destination(new HashMap<>(Map.of("monday", 127, "wednesday", 150)), "USA", "078",
                        "British Airline"));

        destinationList.add(
                new Destination(new HashMap<>(Map.of("monday", 127, "tuesday", 150, "thursday", 300)), "France", "078",
                        "France Air"));

        destinationList.add(
                new Destination(new HashMap<>(Map.of("monday", 127, "tuesday", 150, "thursday", 300)), "Jamaica", "078",
                        "Jamaica Airline"));

        destinationList.add(
                new Destination(new HashMap<>(Map.of("monday", 127, "tuesday", 150, "thursday", 300)), "Canada", "078",
                        "Canada Air"));

        System.out.println("WELCOME TO THRIZ AIRLINE BOOKING");
        boolean programState = true;
        while (programState) {
            System.out.println("[1] - Sign In");
            System.out.println("[2] - Sign up");
            System.out.println("[3] - Exit ");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    signIn();

                    break;
                case 2:
                    signUp();
                    break;

                case 3:
                    programState = false;
                    scanner.close();
                    break;
                default:

                    break;

            }

        }

    }
}
