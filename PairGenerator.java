import java.util.HashMap;
import java.util.Random;

/** 
 * Master class that links together sub classes
 * 
 * @author Logan C.W. Drescher
 * @version 0.0.0
 * Date Created:        April 21st, 2019
 * Date Last Edited:    April 21st, 2019
 */

 public class PairGenerator{
     // Attributes
    private HashMap<Integer, Student> labSection;

     // Constructors
    public PairGenerator(){
        labSection = new HashMap<>();
        labSection.put(null,null); // Dummy line to clear warnings. Delete
    }
     // Getters / Setters

     // General Methods
    public void addToSection(List<Student> l){
        for (Student s : l){
            labSection.put(labSection.size(), s);
        }
    }

    public String[] generateNextSection(){
        // Local variables
        Random rng = new Random();
        int first, second;
        boolean flag = true;

        // Generate pairs
        first = rng.nextInt(labSection.size());
        do{
            second = rng.nextInt(labSection.size());
            if (second != first){
                if (!(labSection.get(first).isBlackListed(labSection.get(second).toString()))){
                    if (labSection.get(first).isWhiteListed(labSection.get(second).toString())){
                        flag = false;
                    } else {
                        if(!(labSection.get(first).isPreviousListed(labSection.get(second).toString()))){
                            flag = false;
                        }
                    }
                }
            }
        } while (flag);
        //TODO: Finish this method;
        return null;
    }
 }