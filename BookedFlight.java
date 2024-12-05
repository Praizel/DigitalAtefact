public class BookedFlight {
    private String country;
    private String day;
    private String airline;
    
    public BookedFlight(String country, String day, String airline) {
        this.country = country;
        this.day = day;
        this.airline = airline;
    }

    public String getCountry() {
        return country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
    public String getAirline(){
        return airline;
    }

    public void setAirline(String airline){
        this.airline = airline;
    }
}
