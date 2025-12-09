package PreparedStatementExample;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Connection;

public class InsertByPSExample {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// inserting data into table by using prepared statement
		final String URL="jdbc:mysql://localhost:3306/jdbcex";
		final String USER="root";
		final String PASSWORD="8122003@Up";
		
		String query="insert into student values(?,?,?,?)";
		Scanner sc=new Scanner(System.in);
		
		// step 1: load driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//step 2: create connection
		Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
		
		// step 3: create preparedStatement
		PreparedStatement ps=con.prepareStatement(query);
		
		// assigning values at compile time
//		ps.setInt(1, 2);
//		ps.setString(2,"Amosh");
//		ps.setInt(3, 23);
//		ps.setString(4, "Vizag");
		
		// assigning values at runtime
		System.out.println("enter the id of student:");
		ps.setInt(1, sc.nextInt());
		System.out.println("enter name of student:");
		ps.setString(2, sc.next());
		System.out.println("enter age of student:");
		ps.setInt(3, sc.nextInt());
		System.out.println("enter city of studen:");
		ps.setString(4, sc.next());
		
		
		int row=ps.executeUpdate();
		System.out.println(row+" rows are inserted successfully");
		
		//step 4:close connection
		con.close();
		ps.close();	
		sc.close();
		
	}

}
