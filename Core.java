
//For Chiss were only the core name, and maybe the family, is known.
public class Core {
    //instance variables
    private String name;
    private String family;
    //constructors
    public Core(String n, String f){
        //when name and family is known
        name = n;
        family = f;
    }
    public Core(String n) {
        //when only name is known
        name = n;
    }
    
    //getName method. Object name is ArrayList variable. Will always give
    //only name
    public String getName() {
        return name;
    }
    //get method that functions more like other getMethods here. Gives all
    //info on object that it can.
    public String getInfo() {
        if (family != null) {
            return name + " of the " + family + " family.";
        }
        else {
            return name;
        }
    }
}
