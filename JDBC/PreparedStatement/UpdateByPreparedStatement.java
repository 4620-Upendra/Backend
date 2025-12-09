package PreparedStatementExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateByPreparedStatement {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		final String URL="jdbc:mysql://localhost:3306/jdbcex";
		final String USER="root";
		final String PASSWORD="8122003@Up";
		Scanner sc=new Scanner(System.in);
		
		String query="update student set city=? where id=?";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
		
		PreparedStatement ps=con.prepareStatement(query);
		
		System.out.println("enter city name:");
		String city=sc.nextLine();
		System.out.println("enter id to update:");
		int id=sc.nextInt();
		
		ps.setString(1, city);
		ps.setInt(2, id);
		
		int row=ps.executeUpdate();
		
		System.out.println(row+" rows are updated successfully");
		
		con.close();
		ps.close();
		sc.close();
	}

}
