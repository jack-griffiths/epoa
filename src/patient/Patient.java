/*
 * EPOA - Emergency Patient Optimisation Application
 * Designed to optimise the hospital emergency department's processing of patients.
 * 
 */
package patient;

/**
 *
 * @author JGRIFFIT
 */
public class Patient {
    String name;
    String dob;
    String firstLineAddress;
    
    public Patient(String name, String dob) { //constructor to create a patient (to add to the database)
        this.name = name;
        this.dob = dob;
    }
    
    public Patient(String name, String dob, String firstLineAddress) { //constructor when searching for a patient
        this.name = name;
        this.dob = dob;
        this.firstLineAddress = firstLineAddress;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }
        
        
    
}
