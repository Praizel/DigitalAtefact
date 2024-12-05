import java.util.Map;

public class Flight {

private Map<String, Integer> availability;
private String contact;

    public Flight( Map<String, Integer> a, String contact ){
       this.availability = a;
       this.contact = contact;

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

    @Override
    public String toString() {
        return "Flight [availability=" + availability + ", contact=" + contact + "]";
    }

}
