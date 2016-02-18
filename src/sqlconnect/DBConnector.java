/**
 * 
 */
package sqlconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ELLWILSO
 *
 */
public class DBConnector {
	private Connection connection;
	private ArrayList<String> details;
	private Scanner scanner;
        private boolean connected;
        @SuppressWarnings("CallToPrintStackTrace")
	
	public DBConnector() {
 		connection = null;
                connected = false;
	}
	
	public void registerOjdbcDriver() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Oracle driver unsuccessfully loaded.");
			e.printStackTrace();
			return;
		}
		System.out.println("Oracle driver successfully loaded.");
	}
	
	public void connect() {
		try {
			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl", 
					"c##oracleuser", "oracleUserPassword"); //gets the details from login
		} catch (SQLException e) {
			System.out.println("Connection failed.");
			e.printStackTrace();
		}
		
		if(connection != null){
			System.out.println("Connected.");
                        setConnected(true);
		}
		else {
			System.out.println("Connection null.");
                        setConnected(false);
		}
	}
        
	
        
        public void setConnected(boolean tf) {
            connected = tf;
        }
        
        public boolean getConnected() {
            return connected;
        }
        
	
	public ResultSet runSqlQuery(String query) {
		ResultSet rs = null;
		Statement stmt;
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}				
		return rs;
	}
	
	
	

	public void closeConnection(){
		try{
			connection.close();
                        System.out.println("Disconnected.");
		}catch(SQLException e){
			System.out.println("Error closing connection");
			e.printStackTrace();
		}
	}
	
	public void takeInput(){
		 scanner = new Scanner(System.in);
		 String input = scanner.next();
	}
	
}