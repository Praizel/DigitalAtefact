import java.util.Map;

public class Flight {

private Map<String, Integer> availability;
private String contact;
private String airline;

    public Flight( Map<String, Integer> a, String contact, String airline){
       this.availability = a;
       this.contact = contact;
       this.airline = airline;
      

    }

    public void setAvailability(Map<String, Integer> availability){
        this.availability =availability;
    }
    
    public Map<String, Integer> getAvailability(){
        return availability;
    }

    public void setContact(String contact){
        this.contact = contact;
    }

    public String getContact(){
        return contact;
    }

    public void setAirline(String airline){
        this.airline = airline;
    }

    public String getAirline(){
        return airline;
    }


    @Override
    public String toString() {
        return "Flight [availability=" + availability + ", contact=" + contact + ", airline=" + airline + "]";
    }

}
