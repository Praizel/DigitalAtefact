public class Destination {
    
private String country;
private Flight flight;



public Destination(String country, Flight flight){
   this.country = country;
   this.flight = flight;
}

public void setCountry(String country){
    this.country = country;

}

public String getCountry(){
    return country;
}

public void setFlight(Flight flight){
    this.flight = flight;

}

public Flight getFlight(){
     return flight;
}

@Override
public String toString() {
    return "Destination [country=" + country + ", flight=" + flight + "]";
}




}
