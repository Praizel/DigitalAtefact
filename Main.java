import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//Class declaration
public class Main {

    // Main class used for all other classes

    // private static final declared so it will not be accessed from outside of this
    // class
    // ArrayList will hold all the User objects and can be accesed by other objects
    // in this class
    private static final List<User> users = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static List<Destination> destinationList;

    // Method used to add new user to the ArrayList
    
    public static void reserveFlight(User user) {
        System.out.println("See the list of available Destinations: ");
        printDestinations();
        System.out.println("Enter the Destination Country you want to Travel: ");
        String country = scanner.nextLine();
         
        //Destination as type  d assigned the function findDestinationByCountry(country)
        Destination d = findDestinationByCountry(country);
        if (d == null) {
            System.out.println("Destination does not exist ");  
        }
        else{
            System.out.println("Your Desitnation is: "); 
            System.out.println(d);
            System.out.println("What day do you want to Travel: ");
            String day = scanner.nextLine().trim().toLowerCase();
    
            Flight flight = d.getFlight();
            Map<String, Integer> availability = flight.getAvailability();
            Integer seats = availability.get(day);
            if(seats != null){
                if(seats > 0){
                    // there are available seats
                    System.out.println("There are available " + seats + "seats to be booked ");
                    // ask user to confirm and update hashmap
                    System.out.println("Do you want to go ahead and book seats Yes/No ");
                    String answer = scanner.nextLine().trim().toLowerCase();
                    if(answer.equals("yes")){
                        BookedFlight f = new BookedFlight(country, day);
                        user.addBookedFlight(f);
                        availability.put(day, seats-1);
                    }
                }
                else{
                    // flight is booked out
                    System.out.println("All seats for this flight is fully booked ");
                }

            }
            else{
                // flight day doesnt exist
                System.out.println("Flight day does not exist ");
            }
 
       
        }
        // Ask the  user for the destination and print this 
    
    }
  // 
    public static void checkReservation(User user) {
        System.out.println("See your booked reservation below: ");
        List<BookedFlight> bookedFlights = user.getBookedFlights();
        for (int i =0; i < bookedFlights.size(); i++){
            BookedFlight bookedflight = bookedFlights.get(i);
            String country = bookedflight.getCountry();
            String day = bookedflight.getDay();
            System.out.println("Booked " + "country: " + country + " day: " + day );

        }


    }

    public static void signIn() {
        System.out.println("Option 1 - Sign In");
        scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        User loggedInUser = null;
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            boolean isEmail = user.getEmail().equals(email);
            boolean isPassword = user.getPasword().equals(password);
            if (isEmail == true && isPassword == true) {
                loggedInUser = user;
                break;
            }
        }
        
        if (loggedInUser != null) {
            System.out.println("Welcome " + loggedInUser.getFullName());
            // Ask user from list of option what user wants to do
            boolean flightResevationOption = true;
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
                        break;
                    default:
                        break;
                }
            }

        }
        else
        {
            System.out.println("User not found ");
        }

    }

    public static void signUp() {
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
        LocalDate dateOfBirth = LocalDate.parse(dateOfBirthString);
        User user = new User(fullName, email, password, passportNumber, countryOfOrigin, dateOfBirth);
        users.add(user);
    }

    public static void printDestinations() {
        for (int i = 0; i < destinationList.size(); i++) {
            System.out.println(destinationList.get(i));
        }
    }

    public static Destination findDestinationByCountry(String country) {
        for (int i = 0; i < destinationList.size(); i++) {
            Destination d = destinationList.get(i);
            String c = d.getCountry();
            if (c.toLowerCase().equals(country.toLowerCase().trim())) {
                return d;

            }

        }
        return null;
    }

    public static void main(String[] args) {
        destinationList = new ArrayList<>();
        destinationList.add(
                new Destination(
                        "America",
                        new Flight(new HashMap<>(Map.of("monday", 127, "wednesday", 150)), "078")));

        destinationList.add(
                new Destination(
                        "France",
                        new Flight(new HashMap<>(Map.of("monday", 127, "tuesday", 150, "thursday", 300)), "078")));

        destinationList.add(
                new Destination(
                        "Jamiaca",
                        new Flight(new HashMap<>(Map.of("monday", 127, "tuesday", 150, "thursday", 300)), "078")));

        destinationList.add(
                new Destination(
                        "Canada",
                        new Flight(new HashMap<>(Map.of("monday", 127, "tuesday", 150, "thursday", 300)), "078")));

        // Destination d1 = destinationList.get(0);
        // int d1n = d1.getFlight().getAvailability().get("Monday");
        // d1.getFlight().setContact("123");
        // Destination d2 = destinationList.get(1);
        // d2.setCountry("Spain");
        // int var = d2.getFlight().getAvailability().get("Tuesday");

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
