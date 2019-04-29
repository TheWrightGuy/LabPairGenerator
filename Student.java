import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/** 
 * Defines the student object and associated operations
 * 
 * @author Logan C.W. Drescher
 * @version 0.0.
 * Date Created:        April 21st, 2019
 * Date Last Edited:    April 28st, 2019
 */

public class Student {
    // Attributes
    private String name;
    private HashMap<String, Boolean> blackList;
    private HashMap<String, Boolean> whiteList;
    private HashMap<String, Boolean> previousList;

    // Constructors
    /**
     *  The 'simple' contructor, single argument parametric constructor 
     *  @param name name of the student
     */
    public Student (String name){
        this.name = name;
        blackList = new HashMap<>();
        whiteList = new HashMap<>();
        previousList = new HashMap<>();
    }

    public Student (String name, List<String> blackList, List<String> whiteList, List<String> previousPartners){
        this(name);
        Iterator<String> itter;
        // Check each list for their values, assuming they're not null
            // BlackList:
        if (blackList != null){
            itter = blackList.iterator();
            while(itter.hasNext()){
                String BLStudent = itter.next();
                Boolean isMapped = this.blackList.putIfAbsent(BLStudent, true);
                if (isMapped != null){  // The value has been mapped previously if this is true
                    System.out.println("Note: " + BLStudent + " has already been blacklisted.");
                }
            }
        }

            // WhiteList:
        if (whiteList != null){
            itter = whiteList.iterator();
            while(itter.hasNext()){
                String WLStudent = itter.next();
                Boolean isMapped = this.whiteList.putIfAbsent(WLStudent, true);
                if (isMapped != null){  // The value has been mapped previously if this is true
                    System.out.println("Note: " + WLStudent + " has already been whitelisted.");
                }
            }
        }

            // Previous Partners
        if (previousPartners != null){
            itter = previousPartners.iterator();
            while(itter.hasNext()){
                String PPStudent = itter.next();
                Boolean isMapped = this.previousList.putIfAbsent(PPStudent, true);
                if (isMapped != null){  // The value has been mapped previously if this is true
                    System.out.println("Note: " + PPStudent + 
                        " had already been partners with " + this + ".");
                }
            }
        }
    } // End of 4 param Constructor

    // General Methods

    public void addToBlackList(String s, boolean b){
        blackList.put(s, b);
    }

    public void addToWhiteList(String s, boolean b){
        whiteList.put(s, b);
    }

    public void addToPreviousList(String s, boolean b){
        previouskList.put(s, b);
    }

    public String removeFromBlackList(String s){
        if (blackList.containsKey(s)){
            return blackList.remove(s);
        } else {
            return null;
        }
    }

    public String removeFromWhiteList(String s){
        if (whiteList.containsKey(s)){
            return blackList.remove(s);
        } else {
            return null;
        }
    }

    public String removeFromPreviousList(String s){
        if (previousList.containsKey(s)){
            return blackList.remove(s);
        } else {
            return null;
        }
    }

    public boolean isBlackListed(String s){
        if(blackList.containsKey(s)){
            return true;
        }
        return false;
    }

    public boolean isWhiteListed(String s){
        if(whiteList.containsKey(s)){
            return true;
        }
        return false;
    }

    public boolean isPreviousListed(String s){
        if(previousList.containsKey(s)){
            return true;
        }
        return false;
    }

    /**
     * Override of the toString() method to work with students
     * @return name of the student represented by the class
     */
    @Override
    public String toString(){
        return name;
    }

    /**
     * Override of the equals(Object) method to work with students
     * @param o the object (hopefully student) being compared
     * @return the result of the equality check
     */
    @Override
    public boolean equals(Object o){
        // self check
        if(this == 0){
            return true;
        }

        // Null check
        if(o == null){
            return false;
        }

        // Class check
        if (this.getClass() != o.getClass()){
            return false;
        }

        // Cast Check
        return name.equals(o);
    }
}