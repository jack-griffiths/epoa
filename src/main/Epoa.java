/*
 * EPOA - Emergency Patient Optimisation Application
 * Designed to optimise the hospital emergency department's processing of patients.
 * 
 */
package main;

import sqlconnect.DBConnector;

/**
 * @version alpha
 * @author JGRIFFIT
 */
public class Epoa {
    private static DBConnector dbc = new DBConnector();

    /**
     * @param args
     */
    public static void main(String[] args) {
        dbc.connect(); //connects to the database  
     
    }
    
    public Epoa() {

    }
    
    public void connect() {
        dbc.connect();
    }
    
    public void disconnect() {
        dbc.closeConnection();
    }
    
    
    
}
