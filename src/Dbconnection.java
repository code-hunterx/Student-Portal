

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Dbconnection {
	
	public static final String USER="root";
	public static final String PASSWORD="1234";
	public static final String URL1="jdbc:mysql://127.0.0.1:3306/test";
	
	public static Connection getConnection()
	 {
		 try {
			return DriverManager.getConnection(URL1, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Connection failed");
			return null;
		}
	 }

}
