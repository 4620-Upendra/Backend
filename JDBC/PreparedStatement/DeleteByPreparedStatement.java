package PreparedStatementExample;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteByPreparedStatement {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		final String URL="jdbc:mysql://localhost:3306/jdbcex";
		final String USER="root";
		final String PASSWORD="8122003@Up";
		Scanner sc=new Scanner(System.in);
		
		String query="delete from student where id=?";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
		
		PreparedStatement ps=con.prepareStatement(query);
		
		System.out.println("enter id to delete user:");
		ps.setInt(1, sc.nextInt());
		
		int row=ps.executeUpdate();
		System.out.println(row+" rows are updated successfully");
		
		con.close();
		ps.close();
		sc.close();
		

	}

}
