
package gradecalculator;

/**
 *
 * @author Nick
 */
public class Student {

    private String Name;
    private String MUID;
    private double GradesAverage;

    public Student(String Name, String MUID, double GradesAverage) {
        this.Name = Name;
        this.MUID = MUID;
        this.GradesAverage = GradesAverage;
    }
   
    
    /**
     * This method retrieves the value in the Name field
     * @return the value in the name field
     */
    public String getName(){
        return Name;
    }
    
    /**
     * This method returns the value in the MUID field
     * @return the value in the MUID field
     */
    public String getMUID(){
        return MUID;
    }
    
    /**
     * This method returns the value in the GradesAverage field
     * @return the value in the GradesAverage field
     */
    public double getGradesAverage(){
        return GradesAverage;
    }
    
}
