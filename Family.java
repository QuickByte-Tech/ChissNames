import java.util.ArrayList;
import java.util.ArrayList;

public class Family {
    //instance variables
    private String name;
    private String status;
    
    //constructors
    public Family(String n, String s) {
        //name and status
        name = n;
        status = s;
    }
    public Family(String n) {
        //name only
        name = n;
    }
    //get method. Object name arrayList index.
    public String getFamily() {
        //alternate response based on information known
        if (status != null) {
            return "The " + name + " are one of the " + status + " Families.";
        }
        else {
            return "The " + name + " family.";
        }
    }
}
