package TransactionManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RollbackWhenRowIsNOTInserted {

	public static void main(String[] args) {
		final String URL="jdbc:mysql://localhost:3306/jdbcex";
		final String USER="root";
		final String PASSWORD="8122003@Up";
		
		String query="insert into student value(?,?,?,?);";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(URL, USER, PASSWORD);
			
			con.setAutoCommit(false); // Start transaction
			
			PreparedStatement ps=con.prepareStatement(query);
			
			
			ps.setInt(1, 201);
			ps.setString(2, "Kiran");
			ps.setInt(3, 23);
			ps.setString(4, "chinnai");
			
			int rows=ps.executeUpdate();
			
			if(rows==0) {
				 System.out.println("Row not inserted Rolling back");
				con.rollback();
				return;
			}
			// If row inserted → commit transaction
			con.commit();
			System.out.println("Row inserted, transaction committed");
			
			con.close();
			
		}catch(Exception e) {
			 System.out.println("Exception occurred! Rolling back...");
			 
			 try {
				Connection con=DriverManager.getConnection(URL, USER,PASSWORD);
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			 
			
			e.getStackTrace();
		}
	}

}
