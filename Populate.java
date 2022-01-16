

//Code adapted from the Review Lab from the AP Computer Science A course.

//modules needed for parsing the text files. Some may be unessecary, I don't
//know which, as I'm adapting code from my class last year.   
import java.util.Scanner;
import java.io.File;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;

//code will always use the data for the canon new eu as of the publishing
//of Thrawn Ascendancy Lesser Evil without modification of the source code.
public class Populate {
    //private ArrayLists manage the unformatted data straight from the .txt files
    private static ArrayList<String> Names = new ArrayList<String>();
    private static ArrayList<String> Cores = new ArrayList<String>();
    private static ArrayList<String> Families = new ArrayList<String>();
    
    //public ArrayLists handle the collections of objects based on data read from
    //the private ArrayLists.
    public static ArrayList<Chiss> ChissNames = new ArrayList<Chiss>();
    public static ArrayList<Core> CoreNames = new ArrayList<Core>();
    public static ArrayList<Family> ChissFamilies = new ArrayList<Family>();
    
    //this method will read data from files and put it unformated into
    //the private ArrayLists
    public static void read() {
        //read and save data on full names in names.txt
        try {
            Scanner input = new Scanner(new File("names.txt"));
            while(input.hasNextLine()) {
                String temp = input.nextLine().trim();
                Names.add(temp);
                //testing
                //System.out.println(temp);
            }
            input.close();
        }
        catch(Exception e) {
            System.out.println("Error reading or parsing names.txt" + e);
        }
        //read and save data on core names only in core.txt
        try {
            Scanner input = new Scanner(new File("core.txt"));
            while(input.hasNextLine()) {
                String temp = input.nextLine().trim();
                Cores.add(temp);
                //testing
                //System.out.println(temp);
            }
            input.close();
        }
        catch(Exception e) {
            System.out.println("Error reading or parsing core.txt" + e);
        }
        //read and save data on Chiss families in families.txt
        try {
            Scanner input = new Scanner(new File("families.txt"));
            while(input.hasNextLine()) {
                String temp = input.nextLine().trim();
                Families.add(temp);
                //testing
                //System.out.println(temp);
            }
            input.close();
        }
        catch(Exception e) {
            System.out.println("Error reading or parsing families.txt" + e);
        }
    }
    //this method takes the unformated data, creates the apporiate objects, and
    //stores them in the public ArrayLists
    public static void format() {
        //formatting full names
        for (int i = 0; i < Names.size(); i++) {
            //aurgements for the construtor
            String core = ""; //variables initalized as empty strings to
            String suffix = ""; //avoid errors that would happen otherwise
            String personal = "";
            String family = "";
            int counter = 0; //keeps track of how many times segements
            //have been removed from the string
            //while , in String.
            while (Names.get(i).indexOf(",") > -1) {
                String temp = Names.get(i).substring(0, 
                   Names.get(i).indexOf(",")); //temp holds everything
                    //before the ,
                //to make sure temp is stored in the proper aurgement.
                if (counter == 0) {
                    core = temp;
                }
                else if (counter == 1) {
                    suffix = temp;
                }
                else{
                    personal = temp;
                }
                
                //increments temp to make sure different aurgement
                //storage occurs next loop.
                counter++;
                //replaces name with previously input value gone
                Names.set(i, Names.get(i).
                    substring(Names.get(i).indexOf(",") + 1));
            }
            //sets last aurgement, as loop breaks after last , has been
            //removed.
            if (counter == 1) {
                suffix = Names.get(i);
            }
            else if (counter == 2) {
                personal = Names.get(i);
            }
            else {
                family = Names.get(i);
            }
            
            
            //creates objects now that proper aurgements have been set 
            //up. Places them in the public ListArray. Uses index of
            //ListArray as objectname.
            //conditionals to avoid passing null strings and ensure 
            //right constructor is used.
            if (family != "") {
              ChissNames.add(new Chiss(core, suffix, personal, family));
            }
            else if (personal != "") {
                ChissNames.add(new Chiss(core, suffix, personal));
            }
            else {
                ChissNames.add(new Chiss(core, suffix));
            }
        }
        //formating core names
        for (int i = 0; i < Cores.size(); i++) {
            //aurgements for the construtor
            String core = ""; //variables initalized as empty strings to
            String family = "";//avoid errors that would happen otherwise
            //if statement because only one optional aurgement
            if (Cores.get(i).indexOf(",") > -1) {
                core = Cores.get(i).substring(0, 
                    Cores.get(i).indexOf(","));
                family = Cores.get(i).substring(Cores.get(i).
                    indexOf(",") + 1);
            }
            else {
                core = Cores.get(i);
            }
            //make sure proper constructor is used.
            if (family != "") {
                CoreNames.add(new Core(core, family));
            }
            else {
                CoreNames.add(new Core(core));
            }
        }
        //formatting families
        for (int i = 0; i < Families.size(); i++) {
            //aurgements for the construtor
            String name = ""; //variables initalized as empty strings to
            String status = "";//avoid errors that would happen otherwise
            //if statement because only one optional aurgement
            if (Families.get(i).indexOf(",") > -1) {
                name = Families.get(i).substring(0, 
                    Families.get(i).indexOf(","));
                status = Families.get(i).substring(Families.get(i).
                    indexOf(",") + 1);
            }
            else {
                name = Families.get(i);
            }
            //make sure proper constructor is used.
            if (status != "") {
                ChissFamilies.add(new Family(name, status));
            }
            else {
                ChissFamilies.add(new Family(name));
            }
        }
    }
    
    //APPARENTLY, making the Arraylists public isn't enough and I need
    //to use a get method to pass them to the main method.
    public static ArrayList<Chiss> getChissNames() {
        return ChissNames;
    }
    public static ArrayList<Core> getCoreNames() {
        return CoreNames;
    }
    public static ArrayList<Family> getChissFamilies() {
        return ChissFamilies;
    }
}
