import java.util.ArrayList;
import java.util.ArrayList;
import java.util.ArrayList;

public class Chiss {
    //instance variables
    private String personal;
    private String family;
    private String suffix;
    private String core;

    //constructors
    public Chiss(String cor, String suf) {
        //store unquie suffixes without creating duplicate names
        core = cor;
        suffix = suf;
    }
    public Chiss(String cor, String suf, String per) {
        //store names for those without families
        suffix = suf;
        personal = per;
        core = cor;
    }
    public Chiss(String cor, String suf, String per, String fam) {
        //store Chiss will full length names
        core = cor;
        suffix = suf;
        personal = per;
        family = fam;
    }
    
    //get function to find full name from search feature.
    public String getName() {
        String result = "There has been a problem"; //legacy stuff.
        //too lazy to fix
        //figuring out what information is known
        if (family != null) {
            result = "Their name is " + family + "'" + personal + "'" + suffix
                + " and their core name(s) is/are " + core + ".";
            return result;
        }
        else if (personal != null) {
            result = "Their name is " + personal + "'" + suffix + ".";
            return result;
        }
        else {
            result = "The suffix " + suffix + " goes to the core names " 
                + core + ".";
            return result;
        }
    }
}
