package net.codejava.sql;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class JavaConnect2SQL {

	public static void main(String[] args) {
		
	String url = "jdbc:sqlserver://DESKTOP-EROKGO6:1433;databaseName=Farmacie";
	String user ="sa";
	String password ="parola123";
	
	
	
	try {
		
		Connection connection = DriverManager.getConnection(url, user, password);
		
		System.out.println("Connected to Microsoft SQL Server");
		
		String sql ="SELECT * from Angajati";
		
		Statement statement = connection.createStatement();
		
		ResultSet result = statement.executeQuery(sql);
		
	
		System.out.println("AngajatID ManagerID Nume Prenume CNP Strada Numar Oras Judet Sex Data Nasterii Salariu");
		while(result.next()){
			
			System.out.println(result.getInt(1)+" "+result.getInt(2)+" "+result.getString(3)+" "+result.getString(4)+" "+result.getString(5)
			+" "+result.getString(6)+" "+result.getInt(7)+" "+result.getString(8)+" "+ result.getString(9)+ " " + result.getString(10)+ " " + result.getString(11)+ " " +result.getInt(12));
		
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*String sql="INSERT INTO student_details (name,mark)" + "VALUES (?,?)";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.setString(1, "HeiTest");
		statement.setInt(2, 99);
		
		//Statement statement = connection.createStatement();
		
		int rows = statement.executeUpdate();
		
		if(rows>0){
			System.out.println("Row has been inserted.");
		}
		*/
		connection.close();
		
	} catch (SQLException e) {
		System.out.println("Oops,there's an error:");
		
		e.printStackTrace();
	}
	
	}

}
