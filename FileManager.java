import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

/** 
 * Class that performs all necessary operations for File I/O
 * 
 * @author Logan C.W. Drescher
 * @version 0.0.0
 * Date Created:        April 21st, 2019
 * Date Last Edited:    April 21st, 2019
 */
public class FileManager{
    // Attributes
    BufferedReader inputStream;
    FileWriter outputStream;

    // Constructors
    public FileManager(){
        this("student_list.txt", "pairs_chart.csv");
    }

    public FileManager(String txt, String csv){
        // Input Construction
        try {
            inputStream = new BufferedReader(new FileReader(txt));
        } catch (FileNotFoundException f){
            System.out.println("Critical Error: core input file not found: Exiting...");
            System.exit(1);
        } catch (IOException e){
            System.out.println(e);
            System.exit(1);
        }

        // Output Construction
        try {
            outputStream = new FileWriter(csv);
        } catch (FileNotFoundException f){
            System.out.println("Critical Error: core input file not found: Exiting...");
            System.exit(1);
        } catch (IOException e){
            System.out.println(e);
            System.exit(1);
        }
    }

    // General Methods
    public Student getNextStudent(){
        String nameIn;
        if ((nameIn = inputStream.readLine()) == null){
            System.out.println("Error, End of File Reached");
            return null;
        }
        return new Student(nameIn);
    }

    public void printLineToCSV(String output){
        outputStream.write(output);
    }

    /**
     * Prints a list of data to a CSV file given an Iterator of Strings
     */
    public void pairListToCSV(Iterator<String> I){
        for(int i = 1; I.hasNext(); i++){
            outputStream.write(I.next() + "\n");
        }
    }
}