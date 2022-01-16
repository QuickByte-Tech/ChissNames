// @author - AbsolxGuardian
//main class
//imports
import java.util.ArrayList;

public class Main{
    public static void main(String[] args){
       //testing
       //names of the ListArrays:
       //ChissNames and Chiss object for full names
       //CoreNames and Core object for just core names and families
       //ChissFamilies and Family object for just families and family status
       //place holder main method versions of the List Arrays
       ArrayList<Chiss> ChissNames = new ArrayList<Chiss>();
       ArrayList<Core> CoreNames = new ArrayList<Core>();
       ArrayList<Family> ChissFamilies = new ArrayList<Family>();
       //creates objects in ListArrays from .txt file data
       Populate.read();
       Populate.format();
       
       //calling get methods from Populate because apparently making the
       //ListArrays public isn't enough for some reason.
       ChissNames = Populate.getChissNames();
       CoreNames = Populate.getCoreNames();
       ChissFamilies = Populate.getChissFamilies();
       
       //prints out all items in the ListArrays using formating from the
       //get methods of their classes.
       for (int i = 0; i < ChissNames.size(); i++) {
           System.out.println(ChissNames.get(i).getName());
       }
       for (int i = 0; i < CoreNames.size(); i++) {
           System.out.println(CoreNames.get(i).getInfo());
       }
       for (int i = 0; i < ChissFamilies.size(); i++) {
           System.out.println(ChissFamilies.get(i).getFamily());
       }
    }
}
