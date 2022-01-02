
package gradecalculator;

import java.util.Scanner;
import java.io.*;

/**
 * This class calculates a students average grade either from a file or by manual entry
 * @author Nick
 */
public class GradeCalculator {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException{
        
        // Create Scanner object for user input
        Scanner scan = new Scanner(System.in);
        
       // Ask user if they would like to use mode1 (read from file)
       // or mode2 (enter name,muid,and grades manually)
       System.out.print("Welcome to the Grade Calculator! Press 1 to read from file, or press 2 to input manually. (Press -1 to exit): ");
       int choice = scan.nextInt();
       
       // Consume the remaining new line character
        scan.nextLine();
        
        // Selects mode 1 or 2 depending on the user's choice
        while(choice != -1){
            if(choice == 1){
                mode1();
                break;
            }
            else if(choice == 2){
                mode2();
                break;
            }
            else{
                System.out.print("Must choose either 1 or 2!: ");
                choice = scan.nextInt();
            }
        }
    }
    
    /**
     * This method reads a file specified by the user
     * @throws java.io.IOException
     */
    public static void mode1() throws IOException{
        //Create a Scanner object
        Scanner scan = new Scanner(System.in);
        // Ask the user for the full path of the file
        System.out.print("Enter the full path of the file to be read: ");
        String filename = scan.nextLine();
        // Open the file
        File file = new File(filename);
        Scanner fileScan = new Scanner(file);
        // Store the first line of the file into the name variable
        String name = fileScan.nextLine();
        // Store the second line of the file into the MUID variable
        String MUID = fileScan.nextLine();
        // Create while loop to read all of the grades from the file
        double gradeAdder = 0;
        int numGrades = 0;
        double grades = 0;
        while(fileScan.hasNext()){
            grades = fileScan.nextDouble();
            gradeAdder += grades;
            numGrades++;
        }
        // Initialize Student class into memory
        Student student;
        student = new Student(name, MUID, CalculateAverage(gradeAdder, numGrades));
        // Display the students name, MUID, and grade average to the user
        displayInfo(student.getName(), student.getMUID(), student.getGradesAverage() );
        // Close the file
        fileScan.close();
        
            
    }
    
    /**
     * This method allows the user to manually input the name, MUID, and grades of the student
     */
    public static void mode2(){
        // Create Scanner object for user input
        Scanner scan = new Scanner(System.in);
        // Ask the user for the name of the student and call the setName method to store the name
        System.out.print("Enter the name of the student: ");
        String name = scan.nextLine();
        // Ask user for the students MUID and call the setMUID method to store the MUID
        System.out.print("Enter " + name + "'s MUID: ");
        String MUID = scan.nextLine();
        // Create while loop for user to enter grades
        double gradeAdder = 0;
        int numGrades = 0;
        double grade = 0;
        System.out.print("Enter a grade for " + name + " or -1 to quit: ");
        grade = scan.nextDouble();
        while(grade != -1){
            if(grade < 0 || grade > 100){
                System.out.println("Grade must be between 0 and 100!");
            }
            gradeAdder += grade;
            numGrades++;
            System.out.print("Enter a grade for " + name + " or -1 to quit: ");
            grade = scan.nextDouble();
        }
        // Initialize Student class into memory
        Student student;
        student = new Student(name, MUID, CalculateAverage(gradeAdder, numGrades));
        // Display the students name, MUID, and grade average to the user
        displayInfo(student.getName(), student.getMUID(), student.getGradesAverage());

    }
    
    
    /**
     * This method returns the students average grade
     * @param gradeSum is the total of the student's grades
     * @param numGrades the number of grades the student has
     * @return the average
     */
    public static double CalculateAverage(double gradeSum, int numGrades){
        return (gradeSum / numGrades);     
    }
    
    /**
     * This method displays the students name, MUID, and grade average
     * @param Name retrieves the value name
     * @param MUID retrieves the value MUID
     * @param Average retrieves the value of the method CalculateAverage
     */
    public static void displayInfo(String Name, String MUID, double Average){
        System.out.printf(Name + " - " + MUID + ": %.1f\n", Average );
    }
}
