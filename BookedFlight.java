public class BookedFlight {
    private String country;
    private String day;
    
    public BookedFlight(String country, String day) {
        this.country = country;
        this.day = day;
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
}
